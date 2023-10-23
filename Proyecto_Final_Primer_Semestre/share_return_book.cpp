#include "share_return_book.h"

void alquilar(tlistaLibros& lista, tUserslist& list, bool& control, int& pos) {
    tUsuarios userdat;
    int i = 0;
    control = true;
    // declaracion de variables 
    int columna = 15, fila = 10;
    dibujo_libro();
    dibujo_cuadro();
    rlutil::locate(columna, fila);
    // ^^^codigo impresion en pantalla^^^
    cout << "Ingresa tus datos.\n";
    rlutil::locate(columna, fila + 2);
    cout << "Nombre y Apellido: "; getline(cin, userdat.usuario);
    rlutil::locate(columna, fila + 4);
    cout << "NIF: "; getline(cin, userdat.cedula);
    rlutil::locate(columna, fila + 6);
    cout << "Telefono: "; getline(cin, userdat.telefono);
    rlutil::locate(columna, fila + 8);
    cout << "Fecha de alquiler (dd/mm/aa).\n";
    rlutil::locate(columna, fila + 10);
    cout << "Dia: "; cin >> userdat.dia;
    rlutil::locate(columna, fila + 12);
    cout << "Mes: "; cin >> userdat.mes;
    rlutil::locate(columna, fila + 14);
    cout << "A�o: "; cin >> userdat.anio;
    userdat.libro = lista.ele_libros[pos].nombre;

    lista.ele_libros[pos].prestados++; // incrementa el contador de libros prestados 

    if (lista.ele_libros[pos].prestados == lista.ele_libros[pos].existentes) { // analiza si existe copias disponibles o no 
        cout << "Ya no se dispone de copias disponibles de \""
            << lista.ele_libros[pos].nombre << "\" \n";
        rlutil::locate(columna, fila + 16);
    }
    else
    {
        while (i < list.contador && control) {  // analiza si ha devuelvo o no un libro alquilado
            if (userdat.cedula == list.user[i].cedula) {
                control = false;

            }
            else if (i == 0) {
                control = true;
                list.user[list.contador] = userdat;

                list.contador++;
            }
            else if (i + 1 == list.contador) {
                control = true;
                list.user[list.contador] = userdat;

                list.contador++;
            }
            i++;
        }
    }


}

//Funcion para regresar el libro a la biblioteca
void devolver(tlistaLibros& lista, tUserslist& list) {
    string cedula1, control;
    string codigo;
    int indice, dia, mes, anio;
    bool ok = false;
    // declaracion de variables 
    int columna = 15, fila = 10;
    dibujo_libro();
    dibujo_cuadro();
    // ^^^codigo impresion en pantalla^^^
    rlutil::locate(columna, fila);
    cout << "Ingrese su cedula por favor: "; cin >> cedula1;
    for (int i = 0; i < list.contador; i++) {
        if (list.user[i].cedula == cedula1) {
            ok = true;
            indice = i;
        }
    }
    if (ok == true) {
        rlutil::locate(columna, fila + 2);
        cout << "Ingrese el codigo del libro ha devolver: "; cin >> codigo;
        rlutil::locate(columna, fila + 4);
        cout << "Ingrese la fecha de devolucion: " << endl;
        rlutil::locate(columna, fila + 6);
        cout << "Dia: "; cin >> dia;
        rlutil::locate(columna, fila + 8);
        cout << "Mes: "; cin >> mes;
        rlutil::locate(columna, fila + 10);
        cout << "A�o: "; cin >> anio;
        if ((dia - list.user[indice].dia) > 3) {
            rlutil::locate(columna, fila + 11);
            cout << "Usted se ha pasado " << (dia - list.user[indice].dia) << " dia(s) " << endl;
            rlutil::locate(columna, fila + 12);
            cout << "Tiene una deuda de: " << (dia - list.user[indice].dia) << "Dolares" << endl;
            rlutil::locate(columna, fila + 13);
            cout << "Cancelo (s/n): "; cin >> control;

            if (control == "s") {
                for (int i = indice; i < list.contador - 1; i++) {
                    list.user[i] = list.user[i + 1];
                }
                list.contador--;

                for (int i = 0; i < lista.contador_libros; i++) {
                    if (codigo == lista.ele_libros[i].codigo) {
                        lista.ele_libros[i].prestados--;
                    }
                }
                rlutil::locate(columna, fila + 15);
                cout << "!!Gracias!!" << endl;


            }
            else {
                rlutil::locate(columna, fila + 15);
                cout << "Su deuda sigue pendiente... :(" << endl;

            }
        }
        else {
            for (int i = indice; i < list.contador - 1; i++) {
                list.user[i] = list.user[i + 1];
            }
            for (int i = 0; i < lista.contador_libros; i++) {
                if (codigo == lista.ele_libros[i].codigo) {
                    lista.ele_libros[i].prestados--;
                }
            }
            list.contador--;
            rlutil::locate(columna, fila + 16);
            cout << "Gracias por devolver a tiempo..." << endl;
            Guardar_prestados(list);
        }
    }
    else {
        rlutil::locate(columna, fila + 8);
        cout << "Usted no ha solicitado ningun libro" << endl;

    }
}
void cargar_prestamistas(tUserslist& list, bool& ok)
{
    //setlocale(LC_CTYPE, "Spanish"); 
    ok = true;
    tUsuarios userdat;
    ifstream leer_archivos;
    char aux = ' ';
    list.contador = 0;
    leer_archivos.open("clientes_libros.txt");
    if (!leer_archivos.is_open())
    {
        ok = false;
    }
    else
    {
        ok = true;

        while ((!leer_archivos.eof()) && (list.contador < USER))
        {
            getline(leer_archivos, userdat.usuario);
            getline(leer_archivos, userdat.cedula);
            getline(leer_archivos, userdat.telefono);
            getline(leer_archivos, userdat.libro);
            leer_archivos.get(aux);
            leer_archivos >> userdat.dia >> userdat.mes >> userdat.anio;


            list.user[list.contador] = userdat;
            list.contador++;

        }
        leer_archivos.close();

    }

}


void Guardar_prestados(tUserslist& list)
{
    ofstream escribir_archivo;
    escribir_archivo.open("clientes_libros.txt");
    for (int i = 0; i < list.contador; i++)
    {
        escribir_archivo << list.user[i].usuario << endl
            << list.user[i].cedula << endl
            << list.user[i].telefono << endl
            << list.user[i].libro << endl
            << list.user[i].dia << " " << list.user[i].mes << " " << list.user[i].anio << endl;

    }
    escribir_archivo.close();
}
