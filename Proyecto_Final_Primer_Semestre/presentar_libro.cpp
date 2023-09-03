#include "presentar_libro.h"




void dibujo_libro()
{

    int columna = 63, fila = 6;

    rlutil::locate(columna, fila);
    cout << " (`/\\ " << endl;
    rlutil::locate(columna, fila+1);
    cout << " `=\\/\\ __...--~~~~~-._   _.-~~~~~--...__" << endl;
    rlutil::locate(columna, fila+2);
    cout << "  `=\\/\\               \\ /               \\\\" << endl;
    rlutil::locate(columna, fila+3);
    cout << "   `=\\/                V                 \\\\" << endl;
    rlutil::locate(columna, fila+4);;
    cout << "    //_\\___--~~~~~~-._  |  _.-~~~~~~--...__\\\\" << endl;
    rlutil::locate(columna, fila+5);;
    cout << "   //  ) (..----~~~~._\\ | /_.~~~~----.....__\\\\" << endl;
    rlutil::locate(columna, fila+6);;
    cout << "  ===( FER )==========\\\\|//====================" << endl;
    rlutil::locate(columna, fila+7);
    cout << " _____\\___/____________`---`____________________" << endl;

}

void presentar_Info_libro(tlistaLibros& lista, int pos)
{
    int columna = 11, fila = 10;
    dibujo_libro();
    dibujo_cuadro();
    rlutil::locate(columna, fila);
    cout << "NOMBRE DEL LIBRO: " << "\"" << lista.ele_libros[pos].nombre << "\"";
    rlutil::locate(columna, fila+2);
    cout << "AUTOR: " << lista.ele_libros[pos].autor;
    rlutil::locate(columna, fila+4);
    cout << "CATEGORIA: " << lista.ele_libros[pos].genero;
    rlutil::locate(columna, fila+6);
    cout << "CODIGO UNICO: " << lista.ele_libros[pos].codigo;
    rlutil::locate(columna, fila+8);
    cout << "DISPONIBLES: " << (lista.ele_libros[pos].existentes) - (lista.ele_libros[pos].prestados);
    rlutil::locate(columna, fila+10);
    cout << "PRESTADOS: " << lista.ele_libros[pos].prestados;
    rlutil::locate(columna, fila+12);
    cout << "EXISTENTES: " << lista.ele_libros[pos].existentes;
}

int presentar_opciones_libro()
{
    //system("color 7B"); //Pinta la consola
    int key; //almacenar el valor de cada tecla tecleada xd 
    int subir_bajar = 0; //para controlar la flecha que aplaste y devolver donde esta el cursor 
    int Columna = 73; //MODIFICAR LA COLUMNA EN LA QUE APARECEN 
    int FILA = 17; //MODIFICAR LA FILA EN LA QUE APARECEN 
    int numero_de_opciones = 4;

    while (true)
    {

        rlutil::setColor(rlutil::COLOR::BLACK); //Le da color a las letras 
        ColorSeleccion_presentar("Menu de opciones____________", Columna, FILA, subir_bajar == 7);
        ColorSeleccion_presentar("           ALQUILAR          ", Columna, FILA + 1, subir_bajar == 0);
        ColorSeleccion_presentar("           DEVOLVER          ", Columna, FILA + 2, subir_bajar == 1);
        ColorSeleccion_presentar("           NO SE Q +         ", Columna, FILA + 3, subir_bajar == 2);
        ColorSeleccion_presentar("           SALIR             ", Columna, FILA + 4, subir_bajar == 3);
        ColorSeleccion_presentar("----------------------------", Columna, FILA + 5, subir_bajar == 4);

        rlutil::locate(Columna - 2, FILA + 1 + subir_bajar);
        cout << (char)175 << endl; //(char)175 estamos casteando interpretando lo que se imprime

        key = rlutil::getkey(); //Me permite asignar un numero al aplastar una tecla 
        //cout << "KEY: " << key << endl; 
        //rlutil::anykey(); 
        switch (key)
        {
        case 14: //Subir
        {
            rlutil::locate(Columna - 2, FILA + 1 + subir_bajar);
            cout << " " << endl; // DONDE ESTABA >> Dibuja un espacio vacio jeje 
            subir_bajar--;
            if (subir_bajar < 0)
            {
                subir_bajar = 0; // Para que no suba mas de las opciones dadas 
            }
            break;
        }
        case 15: //bajar 
        {
            rlutil::locate(Columna - 2, FILA + 1 + subir_bajar);
            cout << " " << endl;
            subir_bajar++;
            if (subir_bajar > numero_de_opciones-1)
            {
                subir_bajar = numero_de_opciones - 1; // Para que no baje mas de las opciones dadas
            }
            break;
        }
        case 1: // Enter
        {
            return subir_bajar;

        }
        default: //Si preciona cualquier otra tecla no hace nada, hasta que "deje de ser necio"
            break;
        }



    }
}

void dibujo_cuadro()
{
    int columna = 69, fila = 15;
    int largo = columna +37, ancho= fila + 10;
    // Línea superior
    rlutil::locate(columna-1, fila);
    cout << (char)218;
    for (int i = columna; i <=  largo; i++) 
    {
        rlutil::locate(i, fila);
        cout << (char)196;
    }
    cout << (char)191;
    // Líneas verticales izquierda 
    for (int i = fila+1; i < ancho; i++) 
    {
        rlutil::locate(columna-1, i); 
        cout << (char)179;
    }
    rlutil::locate(columna-1, ancho);
    cout << (char)192;
    // Lineas verticales derecha
    for (int i = fila+1; i < ancho; i++)
    {
        rlutil::locate(largo+1, i);
        cout << (char)179;
    }
    rlutil::locate( largo+1, ancho);
    cout << (char)217;

    // Línea inferior
    for (int i = columna; i <= largo; i++) 
    {   
        rlutil::locate(i, ancho);
        cout << (char)196;
    }

}

void ColorSeleccion_presentar(string text, int posX, int posY, bool selected)
{

    if (selected)
    {
        rlutil::setBackgroundColor(rlutil::COLOR::LIGHTCYAN); // damos color al contorno del texto seleccionado 
        rlutil::locate(posX, posY);
        cout << text << endl;
    }
    else
    {
        rlutil::setBackgroundColor(rlutil::COLOR::GREY); //Igual damos contorno pero del mismo color de consola pa disimular XD
        rlutil::locate(posX, posY);
        cout << " " << text << endl;
    }
}