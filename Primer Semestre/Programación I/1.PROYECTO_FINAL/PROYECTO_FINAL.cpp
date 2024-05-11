#include <iostream>
#include "rlutil.h"
using namespace std;                               
#include <stdlib.h>
#include <Windows.h>
#include "Estructura.h"
#include "cargar_guardar.h"
#include "presentar_libro.h"                                  
#include "buscar.h"
#include "Registros.h"
#include "share_return_book.h"
#include "Agregar_libro.h"  


//Prototipos de funciones
void ColorSeleccion(string text, int posX, int posY, bool selected);

int Menu_principal();
int Menu_Buscar();
int Menu_Categoria();
void Dibujar_contorno(string& nombre);
void Dibujar_contorno_menu_principal();
void letras_biblio();
int Menu_Enter_Para_salir();



string Nombre_Del_Usuario;

/**********************************COMIENZO DEL MAIN**************************************************************/
int main()
{
    tlistaLibros lista_de_libros;
    tUserslist lista_de_pretamistas; 
    tLibros EsteLibro;
    bool exito = true;
    bool devolvio = true;
    bool Control_prestamos = true; 
    bool AgregarLibroOK;
    cargar(lista_de_libros, exito);
    Tlista_usuarios lista;
    int pos_usuario;
    bool funciona = true;
    cargar_prestamistas(lista_de_pretamistas, funciona);

    
 

    if (!exito)
    {
        cout << "ERROR: NO SE PUDO CARGAR LA LISTA DE LIBROS!!" << endl;
    }
    else
    {
        if (cargar(lista))
        {
            if (login(lista, pos_usuario))
            {
                Nombre_Del_Usuario = " " + lista.elemen_usuarios[pos_usuario].user + " ";
                system("cls");
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
                            Dibujar_contorno(Nombre_Del_Usuario);
                            opcion_buscar = Menu_Buscar();
                            switch (opcion_buscar)
                            {
                            case 0:
                            {
                                bool existente;
                                int pos;
                                system("cls");
                                Dibujar_contorno(Nombre_Del_Usuario);
                                pos = buscar_nombre(lista_de_libros, existente);
                                if (!existente)
                                {
                                    system("cls");
                                    rlutil::locate(25, 14);
                                    rlutil::setColor(rlutil::COLOR::RED);
                                    cout << "ERROR: ";
                                    rlutil::locate(25, 16);
                                    rlutil::setColor(rlutil::COLOR::BLACK);
                                    cout << "El nombre que ingresaste no corresponde";
                                    rlutil::locate(25, 17);
                                    cout << "a ningun libro de la liblioteca." << endl;
                                }
                                else
                                {
                                    system("cls");
                                    Dibujar_contorno(Nombre_Del_Usuario);
                                    presentar_Info_libro(lista_de_libros, pos);
                                    switch (presentar_opciones_libro())
                                    {
                                    case 0: 
                                    {
                                        if (!funciona)
                                        {
                                            cout << "ERROR: NO SE PUDO CARGAR LA LISTA DE LIBROS!!" << endl;
                                        }
                                        else
                                        {
                                            system("cls");
                                            Dibujar_contorno(Nombre_Del_Usuario);
                                            alquilar(lista_de_libros, lista_de_pretamistas,Control_prestamos, pos);
                                            /*if (!Control_prestamos)
                                            {
                                                system("cls");
                                                rlutil::locate(25, 14);
                                                rlutil::setColor(rlutil::COLOR::RED);
                                                cout << "ERROR: ";
                                                rlutil::locate(25, 16);
                                                rlutil::setColor(rlutil::COLOR::BLACK);
                                                cout << "El usuario ya ha alquilado un libro.";
                                                rlutil::locate(25, 17);
                                                cout << "devuélvalo para poder alquilar otro." << endl;
                                            }
                                            else
                                            {
                                                Guardar_prestados(lista_de_pretamistas);
                                            }
                                            Menu_Enter_Para_salir();*/
                                            
                                        }
                                        system("cls");
                                        break;
                                    }
                                    case 1:
                                    {


                                        break;
                                    }
                                    default:
                                    {
                                        system("cls");
                                    }
                                        break;
                                    }
                                }
                                break;
                            }
                            case 1:
                            {
                                system("cls");
                                Dibujar_contorno(Nombre_Del_Usuario);
                                buscar_autor(lista_de_libros);
                                break;
                            }
                            case 2:
                            {
                                system("cls");
                                buscar_por_categoria(lista_de_libros, Menu_Categoria());
                                
                                break;
                            }
                            case 3:
                            {
                                system("cls");
                                Dibujar_contorno(Nombre_Del_Usuario);
                                buscar_codigo(lista_de_libros);
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
                        int atras;
                        system("cls");
                        rlutil::setColor(rlutil::COLOR::BLACK);
                        Dibujar_contorno(Nombre_Del_Usuario);
                        leer_libro(lista_de_libros, EsteLibro, AgregarLibroOK);
                        insertar_Insertar(lista_de_libros, EsteLibro, AgregarLibroOK);
                        Menu_Enter_Para_salir();
                        system("cls");
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
        }
        
        
    }

    

    

}
/**********************************FINAL DEL MAIN**************************************************************/




//Menu principal 

int Menu_principal()
{

    system("color 7B"); //Pinta la consola
    int key; //almacenar el valor de cada tecla tecleada xd 
    int subir_bajar = 0; //para controlar la flecha que aplaste y devolver donde esta el cursor 
    int Columna = 45; //MODIFICAR LA COLUMNA EN LA QUE APARECEN 
    int FILA = 12; //MODIFICAR LA FILA EN LA QUE APARECEN 
    
    while (true)
    {
        
        rlutil::setColor(rlutil::COLOR::BLACK); //Le da color a las letras 

        Dibujar_contorno(Nombre_Del_Usuario);
        Dibujar_contorno_menu_principal();
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



    } 
}

void ColorSeleccion(string text, int posX, int posY, bool selected)
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

/***************************************************************************************/
int Menu_Buscar()
{
    //system("color 7B");
    int key;
    int subir_bajar = 0;
    int Columna = 75; //MODIFICAR LA COLUMNA EN LA QUE APARECEN 
    int FILA = 13; //MODIFICAR LA FILA EN LA QUE APARECEN 
    while (true)
    {
        rlutil::setColor(rlutil::COLOR::BLACK);

        ColorSeleccion(" Buscar ___________________", Columna, FILA, subir_bajar == 7);
        ColorSeleccion("|     Buscar por nombre    |", Columna, FILA + 1, subir_bajar == 0);
        ColorSeleccion("|     Buscar por autor     |", Columna, FILA + 2, subir_bajar == 1);
        ColorSeleccion("|     Buscar por categoria |", Columna, FILA + 3, subir_bajar == 2);
        ColorSeleccion("|     Buscar por codigo    |", Columna, FILA + 4, subir_bajar == 3);
        ColorSeleccion("|     Volver               |", Columna, FILA + 5, subir_bajar == 4);
        ColorSeleccion(" --------------------------", Columna, FILA + 6, subir_bajar == 5);

        rlutil::locate(Columna - 2, FILA + 1 + subir_bajar);
        cout << (char)175 << endl; //(char)175 estamos casteando interpretando lo que se imprime

        key = rlutil::getkey(); //Me permite asignar un numero al aplastar una tecla 

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

    } 
}



int Menu_Categoria()
{

    system("color 7B");
    int key;
    int subir_bajar = 0;
    int Columna = 45; //MODIFICAR LA COLUMNA EN LA QUE APARECEN 
    int FILA = 12; //MODIFICAR LA FILA EN LA QUE APARECEN 
    int  cantidad_de_opciones = 5;

    while (true)
    {
        rlutil::setColor(rlutil::COLOR::BLACK);
        Dibujar_contorno(Nombre_Del_Usuario);
        ColorSeleccion(" Menu Categorias____________", Columna, FILA, subir_bajar == 7);
        ColorSeleccion("|         Ficcion          |", Columna, FILA + 1, subir_bajar == 0);
        ColorSeleccion("|         Fantasía         |", Columna, FILA + 2, subir_bajar == 1);
        ColorSeleccion("|         Educacion        |", Columna, FILA + 3, subir_bajar == 2);
        ColorSeleccion("|         Juvenil          |", Columna, FILA + 4, subir_bajar == 3);
        ColorSeleccion("|         Clasicos         |", Columna, FILA + 5, subir_bajar == 4);
        ColorSeleccion("|         Volver           |", Columna, FILA + 6, subir_bajar == 5);
        ColorSeleccion(" --------------------------", Columna, FILA + 7, subir_bajar == 6);

        rlutil::locate(Columna - 2, FILA + 1 + subir_bajar);
        cout << (char)175 << endl; //(char)175 estamos casteando interpretando lo que se imprime

        key = rlutil::getkey(); //Me permite asignar un numero al aplastar una tecla 
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



    } 
}




void Dibujar_contorno(string &nombre)
{
    // Línea superior
    for (int i = 24; i < 118; i++)
    {
        rlutil::locate(i, 3);
        cout << (char)205;
    }

    // Título en el centro


    // Líneas verticales izquierda 
    for (int i = 8; i < 28; i++)
    {
        rlutil::locate(3, i);
        cout << (char)186;

    }
    // Lineas verticales derecha
    for (int i = 4; i < 28; i++)
    {

        rlutil::locate(118, i);
        cout << (char)186;
    }

    rlutil::locate(3, 2);
    letras_biblio();
    // Línea inferior
    for (int i = 4; i < 118; i++)
    {
        rlutil::locate(i, 28);
        cout << (char)205;
    }

    // Nombre en el centro inferior
    rlutil::locate(50, 28);
    cout << nombre;
}

void Dibujar_contorno_menu_principal()
{
    // Línea superior
    rlutil::locate(39, 10);
    cout << (char)218;
    for (int i = 40; i <= 77; i++) // Cambié < por <=
    {
        rlutil::locate(i, 10);
        cout << (char)196;
    }
    cout << (char)191;
    // Líneas verticales izquierda 
    for (int i = 11; i < 20; i++) // Comencé en 11 en lugar de 10
    {
        rlutil::locate(39, i); 
        cout << (char)179;
    }
    rlutil::locate(39, 20);
    cout << (char)192;
    // Lineas verticales derecha
    for (int i = 11; i < 20; i++)
    { 
        rlutil::locate(78, i);
        cout << (char)179;
    }
    rlutil::locate(78, 20);
    cout << (char)217;

    // Línea inferior
    for (int i = 40; i <= 77; i++) // Cambié < por <=
    {
        rlutil::locate(i, 20);
        cout << (char)196;
    }
}

void letras_biblio()
{
    cout << " ____    _    ____" << endl;
    rlutil::locate(3, 3);
    cout << "| __ )  | |  | __ )  " << endl;
    rlutil::locate(3, 4);
    cout << "| _ \\   | |  | _ \\" << endl;
    rlutil::locate(3, 5);
    cout << "| |_) | | |  | |_) |" << endl;
    rlutil::locate(3, 6);
    cout << "|____/  |_|  |____/" << endl;
    rlutil::locate(3, 7);
    cout << "  " << endl;

}

int Menu_Enter_Para_salir()
{

    int key;
    int subir_bajar = 0;
    int Columna = 88; //MODIFICAR LA COLUMNA EN LA QUE APARECEN 
    int FILA = 25; //MODIFICAR LA FILA EN LA QUE APARECEN 
    int  cantidad_de_opciones = 0;

    while (true)
    {
        rlutil::setColor(rlutil::COLOR::BLACK);
        Dibujar_contorno(Nombre_Del_Usuario);
        ColorSeleccion(" Menu _____________________", Columna, FILA, subir_bajar == 7);
        ColorSeleccion("         Volver           ", Columna, FILA + 1, subir_bajar == 0);
        ColorSeleccion(" --------------------------", Columna, FILA + 2, subir_bajar == 6);
      
        rlutil::locate(Columna - 2, FILA + 1 + subir_bajar);
        cout << (char)175 << endl; //(char)175 estamos casteando interpretando lo que se imprime

        key = rlutil::getkey(); //Me permite asignar un numero al aplastar una tecla 
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



    }
}

