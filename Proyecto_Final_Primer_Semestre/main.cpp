#include <iostream>
#include "rlutil.h"
using namespace std;
#include <stdlib.h>
#include <Windows.h>
void ColorSeleccion(const char* text, int posX, int posY, bool selected);

int Menu_principal();
int Menu_Buscar();
int Menu_Categoria();





/**********************************COMIENZO DEL MAIN**************************************************************/
int main()
{
    
    //system("color 5B"); // color a toda la consola de fondo debe coincidir 
    int opcion, opcion_buscar, opcion_categoria;

    do
    {
        opcion = Menu_principal();
        switch (opcion)
        {
        case 0:
        {
            do
            {
                opcion_buscar = Menu_Buscar();
                switch (opcion_buscar)
                {
                case 0:
                {

                    break;
                }
                case 1:
                {
                    break;
                }
                case 2:
                {
                    system("cls");
                    opcion_categoria = Menu_Categoria();
                    break;
                }
                case 3:
                {
                    break;
                }
                case 4:
                {
                    system("cls");
                    break;
                }

                }
            } while (opcion_buscar != 4);
            


            break;
        }
        case 1:
        {
            break;
        }
        case 2:
        {
            break;
        }
        case 3:
        {
            break;
        }


        }
    } while (opcion != 4);

    

}
/**********************************FINAL DEL MAIN**************************************************************/




//Menu principal 

int Menu_principal()
{
    system("color 7B"); //Pinta la consola
    int opcion = 1; //para presentar una y otra vez lo mismo en consola 
    int key; //almacenar el valor de cada tecla tecleada xd 
    int subir_bajar = 0; //para controlar la flecha que aplaste y devolver donde esta el cursor 
    int Columna = 45; //MODIFICAR LA COLUMNA EN LA QUE APARECEN 
    int FILA = 12; //MODIFICAR LA FILA EN LA QUE APARECEN 
    int CURSOR_FLECHA = 10;//MODIFICA DONDE SE PRESENTA EL INDICAR >>
    
    do
    {
        
        rlutil::setColor(rlutil::COLOR::BLACK); //Le da color a las letras 

        ColorSeleccion(" Menu principal____________", Columna, FILA, subir_bajar == 7);
        ColorSeleccion("           BUSCA            ", Columna, FILA +1, subir_bajar == 0);
        ColorSeleccion("           AGREGAR          ", Columna, FILA + 2, subir_bajar == 1);
        ColorSeleccion("           ELIMINAR         ", Columna, FILA + 3, subir_bajar == 2);
        ColorSeleccion("           MODIFICAR        ", Columna, FILA + 4, subir_bajar == 3);
        ColorSeleccion("           SALIR            ", Columna, FILA + 5, subir_bajar == 4);
        ColorSeleccion(" --------------------------", Columna, FILA + 6, subir_bajar == 5);

        rlutil::locate(Columna -2, FILA + 1 + subir_bajar);
        cout << (char)175 << endl; //(char)175 estamos casteando interpretando lo que se imprime

        key = rlutil::getkey(); //Me permite asignar un numero al aplastar una tecla 
        //cout << "KEY: " << key << endl; 
        //rlutil::anykey(); 
        switch (key)
        {
        case 14: //Subir
        {
            rlutil::locate(Columna - 2, FILA+1 + subir_bajar);
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
            if (subir_bajar > 4)
            {
                subir_bajar = 4; // Para que no baje mas de las opciones dadas
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



    } while (opcion != 0);
}

void ColorSeleccion(const char* text, int posX, int posY, bool selected)
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

    //rlutil::locate(posX, posY);
    //cout << text << endl; //Escribimos en pantalla

}

/***************************************************************************************/
int Menu_Buscar()
{
    system("color 7B");
    int opcion = 1;
    int key;
    int subir_bajar = 0;
    int Columna = 75; //MODIFICAR LA COLUMNA EN LA QUE APARECEN 
    int FILA = 13; //MODIFICAR LA FILA EN LA QUE APARECEN 
    int CURSOR_FLECHA = 10;//MODIFICA DONDE SE PRESENTA EL INDICAR >>
    rlutil::hidecursor();
    do
    {
        //rlutil::cls();
        //rlutil::setBackgroundColor(rlutil::COLOR::BLACK);
        rlutil::setColor(rlutil::COLOR::BLACK);

        ColorSeleccion(" Buscar ___________________", Columna, FILA, subir_bajar == 7);
        ColorSeleccion("|     Buscar por nombre    |", Columna, FILA + 1, subir_bajar == 0);
        ColorSeleccion("|     Buscar por autor     |", Columna, FILA + 2, subir_bajar == 1);
        ColorSeleccion("|     Buscar por categoria |", Columna, FILA + 3, subir_bajar == 2);
        ColorSeleccion("|     Buscar por codigo    |", Columna, FILA + 4, subir_bajar == 3);
        ColorSeleccion("|     Volver               |", Columna, FILA + 5, subir_bajar == 4);
        ColorSeleccion(" --------------------------", Columna, FILA + 6, subir_bajar == 5);
        //rlutil::locate(30,10); // Primer numero es la columna y segundo es la fila
        /*cout << "____Super Calculadora____" << endl;
        rlutil::locate(30, 11);
        cout << "1. Operaciones Basicas   " << endl;
        rlutil::locate(30, 12);
        cout << "2. Operaciones avanzadas " << endl;
        rlutil::locate(30, 13);
        cout << "3. Conversion de medidas " << endl;
        rlutil::locate(30, 14);
        cout << "0. Salir                 " << endl;
        rlutil::locate(30, 15);
        cout << "-------------------------" << endl;*/
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
            cout << " " << endl;
            subir_bajar--;
            if (subir_bajar < 0)
            {
                subir_bajar = 0;
            }
            break;
        }
        case 15: //bajar 
        {
            rlutil::locate(Columna - 2, FILA + 1 + subir_bajar);
            cout << " " << endl;
            subir_bajar++;
            if (subir_bajar > 4)
            {
                subir_bajar = 4;
            }
            break;
        }
        case 1: // Enter
        {
            return subir_bajar;

        }

        }

    } while (opcion != 0);
}




int Menu_Categoria()
{
    system("color 7B");
    int opcion = 1;
    int key;
    int subir_bajar = 0;
    int Columna = 45; //MODIFICAR LA COLUMNA EN LA QUE APARECEN 
    int FILA = 12; //MODIFICAR LA FILA EN LA QUE APARECEN 
    int CURSOR_FLECHA = 10;//MODIFICA DONDE SE PRESENTA EL INDICAR >>
    int  cantidad_de_opciones = 5;
    rlutil::hidecursor();
    do
    {
        //rlutil::cls();
        //rlutil::setBackgroundColor(rlutil::COLOR::BLACK);
        rlutil::setColor(rlutil::COLOR::BLACK);

        ColorSeleccion(" Menu Categorias____________", Columna, FILA, subir_bajar == 7);
        ColorSeleccion("|         Comedia          |", Columna, FILA + 1, subir_bajar == 0);
        ColorSeleccion("|         Fantasia         |", Columna, FILA + 2, subir_bajar == 1);
        ColorSeleccion("|         Historica        |", Columna, FILA + 3, subir_bajar == 2);
        ColorSeleccion("|         Suspenso         |", Columna, FILA + 4, subir_bajar == 3);
        ColorSeleccion("|         Romance          |", Columna, FILA + 5, subir_bajar == 4);
        ColorSeleccion("|         Volver           |", Columna, FILA + 6, subir_bajar == 5);
        ColorSeleccion(" --------------------------", Columna, FILA + 7, subir_bajar == 6);
        //rlutil::locate(30,10); // Primer numero es la columna y segundo es la fila
        /*cout << "____Super Calculadora____" << endl;
        rlutil::locate(30, 11);
        cout << "1. Operaciones Basicas   " << endl;
        rlutil::locate(30, 12);
        cout << "2. Operaciones avanzadas " << endl;
        rlutil::locate(30, 13);
        cout << "3. Conversion de medidas " << endl;
        rlutil::locate(30, 14);
        cout << "0. Salir                 " << endl;
        rlutil::locate(30, 15);
        cout << "-------------------------" << endl;*/
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
            cout << " " << endl;
            subir_bajar--;
            if (subir_bajar < 0)
            {
                subir_bajar = 0;
            }
            break;
        }
        case 15: //bajar 
        {
            rlutil::locate(Columna - 2, FILA + 1 + subir_bajar);
            cout << " " << endl;
            subir_bajar++;
            if (subir_bajar > cantidad_de_opciones)
            {
                subir_bajar = cantidad_de_opciones;
            }
            break;
        }
        case 1: // Enter
        {
            return subir_bajar;
           
        }

        }



    } while (opcion != 0);
}
