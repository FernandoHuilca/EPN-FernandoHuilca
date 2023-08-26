#include <iostream>
#include "rlutil.h"
using namespace std;
void ColorSeleccion(const char* text, int posX, int posY, bool selected);




int main()
{
    int opcion=1;
    int key;
    int subir_bajar = 0;
    rlutil::hidecursor(); 
    do
    {
        //rlutil::cls();
        rlutil::setBackgroundColor(rlutil::COLOR::BLACK);
        rlutil::setColor(rlutil::COLOR::WHITE);

        ColorSeleccion("____Super Calculadora____", 30, 10, subir_bajar == 7);
        ColorSeleccion("1. Operaciones Basicas   ", 30, 11, subir_bajar == 0);
        ColorSeleccion("2. Operaciones avanzadas ", 30, 12, subir_bajar == 1);
        ColorSeleccion("3. Conversion de medidas ", 30, 13, subir_bajar == 2);
        ColorSeleccion("0. Salir                 ", 30, 14, subir_bajar == 3);
        ColorSeleccion("-------------------------", 30, 15, subir_bajar == 4);
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
        rlutil::locate(28, 11 + subir_bajar);
        cout << (char)175 << endl; //(char)175 estamos casteando interpretando lo que se imprime

        key = rlutil::getkey(); //Me permite asignar un numero al aplastar una tecla 
        //cout << "KEY: " << key << endl; 
        //rlutil::anykey(); 
        switch (key)
        {
        case 14: //Subir
        {
            rlutil::locate(28, 11 + subir_bajar);
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
            rlutil::locate(28, 11 + subir_bajar);
            cout << " " << endl;
            subir_bajar++;
            if (subir_bajar > 3)
            {
                subir_bajar = 3;
            }
            break;
        }
        case 1: // Enter
        {
            switch (subir_bajar)
            {
                case 0: 
                {
                    cout << "Operaciones basicas " << endl;
                    break;
                }
                case 1:
                {
                    cout << "Operaciones avanzadas " << endl;
                    break;
                }
                case 2:
                {
                    cout << "Operaciones medidas " << endl;
                    break;
                }
                case 3:
                {
                    cout << "salir " << endl;
                    break;
                }
            } 
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
        rlutil::setBackgroundColor(rlutil::COLOR::LIGHTCYAN);
    }
    else
    {
        rlutil::setBackgroundColor(rlutil::COLOR::BLACK);
    }
    rlutil::locate(posX, posY);
    cout << text << endl;
}