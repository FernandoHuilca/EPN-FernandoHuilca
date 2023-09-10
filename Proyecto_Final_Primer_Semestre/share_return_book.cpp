#include "share_return_book.h"

void alquilar(tlistaLibros& lista, tUserslist& list, bool& control, int& pos) {
    // el "int& pos" apunta a la posicion del libro y de ahi guarda los datos del usuario en el arreglo de tUserlist
    tUsuarios userdat;
    int i = 0;
    control = true;
    cout << "Ingresa tus datos.\n"
        << "Nombre y Apellido: ";
    getline(cin, userdat.usuario);
    cout << "NIF: ";
    getline(cin, userdat.cedula);
    cout << "Telefono: ";
    getline(cin, userdat.telefono);
    lista.ele_libros[pos].prestados++;
    if (lista.ele_libros[pos].prestados == lista.ele_libros[pos].existentes) { // analiza si existe copias disponibles o no 
        cout << "Ya no se dispone de copias disponibles de \""
            << lista.ele_libros[pos].nombre << "\" \n";
    }
    else
    {
        while (i < list.contador && !control) {  // analiza si ha devuelvo o no un libro alquilado
            if (list.user[i].cedula == userdat.cedula) {
                control = false;

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
/*void devolver(tlistaLibros& lista, tUserslist& list) {
    string cedula1, codigo1;
    int indice = -1, annio, mes, dia, multa;
    bool control = false;
    cout << "Ingrese su cedula: ";
    cin >> cedula1;
    for (int i = 0; i < list.contador; i++) {
        if (cedula1 == list.user[i].cedula) {
            indice = i;
        }
    }
    if (indice == -1) {
        cout << "Usted no ha solicitado ningun libro" << endl;
    }
    else {
        if (list.user[indice].anio == 0) {
            cout << "Usted no tiene libros por devolver" << endl;

        }
        else {
            time_t now = time(0);
            tm* timeinfo = localtime(&now);
            annio = timeinfo->tm_year + 1900;
            mes = timeinfo->tm_mon + 1;
            dia = timeinfo->tm_mday;

            if ((dia - list.user[indice].dia) > 3) {
                multa = dia - list.user[indice].dia;
                multa = (multa - 3);
                cout << "Usted no puede pedir prestado un libro, no ha regresado uno desde: ";
                cout << list.user[indice].dia << "/" << list.user[indice].mes << "/" << list.user[indice].anio << endl;
                cout << "Debe la cantidad de: " << multa << " dolares." << endl;
            }
            if ((dia - list.user[indice].dia) < 3) {
                cout << "Ingrese el codigo del libro: ";
                cin >> codigo1;

                for (int i = 0; i < lista.contador_libros; i++) {
                    if (lista.ele_libros[i].codigo == codigo1) {
                        lista.ele_libros[i].prestados = lista.ele_libros[i].prestados - 1;
                    }
                }
                list.user[indice].anio = 0;
                cout << "Gracias, eso es todo... " << endl;
            }
        }


    }
}*/
void cargar_prestamistas(tUserslist& list, bool& ok)
{
    //setlocale(LC_CTYPE, "Spanish"); 
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

        while ((!leer_archivos.eof()) && (list.contador < DIM_BOOK))
        {
            getline(leer_archivos, userdat.usuario);
            getline(leer_archivos, userdat.cedula);
            getline(leer_archivos, userdat.telefono);
            //leer_archivos.get(aux);

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
    for (int i = 0; i <= list.contador; i++)
    {
        escribir_archivo << list.user[i].usuario << endl;
        escribir_archivo << list.user[i].cedula << endl;
        escribir_archivo << list.user[i].telefono << endl;

    }
    escribir_archivo.close();
}