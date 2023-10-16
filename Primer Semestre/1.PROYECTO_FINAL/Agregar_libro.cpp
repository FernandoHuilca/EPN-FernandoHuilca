#include "Agregar_libro.h"


void leer_libro(tlistaLibros &lista, tLibros &libro, bool &ok)
{
    int num_agregar, num_de_existentes;
    ok = true; 
    cin.ignore();
    int columna = 11, fila = 10;
    rlutil::locate(columna, fila);
    cout << "Nombre del libro que desea agregar: ";
    getline(cin, libro.nombre);
    for (int i = 0; (i < lista.contador_libros) && (ok); i++)
    {
        if (libro.nombre == lista.ele_libros[i].nombre)
        {
            ok = false; 
            rlutil::locate(columna, fila +2);
            cout << "El libro que intenta agregar ya se encuentra en nuestro registro";
            rlutil::locate(columna, fila+3);
            cout << "Agregue el numero de libros que quiere añadir: ";
            cin >> num_agregar; 
            lista.ele_libros[i].existentes += num_agregar;
            rlutil::locate(columna, fila+4);
            cout << "Se ha agregado con exito el numero libros: ";
            cout << lista.ele_libros[i].nombre;
            rlutil::locate(columna, fila+5);
            cout << "Ahora se dispone de " << lista.ele_libros[i].existentes << " libros existentes.";
        }
    }
    if (ok)
    {
        rlutil::locate(columna, fila+1);
        cout << "Autor del libro: ";
        getline(cin, libro.autor);
        rlutil::locate(columna, fila+2);
        cout << "Selecciona una de nuestras categorias a la que pertenezca: ";
        switch (seleccion_categoria())
        {
        case 0:
        {
            libro.genero = "Ficcion";
            break;
        }
        case 1:
        {
            libro.genero = "Fantasía";
            break;
        }
        case 2:
        {
            libro.genero = "Educación";
            break;
        }
        case 3:
        {
            libro.genero = "Juvenil";
            break;
        }
        case 4:
        {
            libro.genero = "Clásicos";
            break;
        }
        default:
            break;
        }
        libro.codigo = (lista.contador_libros + 10);
        rlutil::locate(columna, fila+10);
        cout << "Cual es la cantidad de este libro que se ingresa: ";
        cin >> num_de_existentes; 
        libro.existentes = num_de_existentes;
        libro.prestados = 0; 

    }
}


void insertar_Insertar(tlistaLibros& lista, tLibros& libro, bool& ok)
{
    if (ok)
    {
         int columna = 11, fila = 10;
            //INSERTARDO AL FINAL
            lista.ele_libros[lista.contador_libros] = libro;
            lista.contador_libros++;
            rlutil::locate(columna, fila +11);
            cout << "El libro se ha agregado con Exito!! ";
    }
   
}


int seleccion_categoria()
{
    int key;
    int subir_bajar = 0;
    int Columna = 11; //MODIFICAR LA COLUMNA EN LA QUE APARECEN 
    int FILA = 13; //MODIFICAR LA FILA EN LA QUE APARECEN 
    int  cantidad_de_opciones = 5;

    while (true)
    {
        rlutil::setColor(rlutil::COLOR::BLACK);
        ColorSeleccionn("Categorias _______________", Columna, FILA, subir_bajar == 7);
        ColorSeleccionn("         Ficcion          ", Columna, FILA + 1, subir_bajar == 0);
        ColorSeleccionn("         Fantasía         ", Columna, FILA + 2, subir_bajar == 1);
        ColorSeleccionn("         Educacion        ", Columna, FILA + 3, subir_bajar == 2);
        ColorSeleccionn("         Juvenil          ", Columna, FILA + 4, subir_bajar == 3);
        ColorSeleccionn("         Clasicos         ", Columna, FILA + 5, subir_bajar == 4);
        ColorSeleccionn("--------------------------", Columna, FILA + 6, subir_bajar == 6);

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

void ColorSeleccionn(string text, int posX, int posY, bool selected)
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
