#include "buscar.h"


int buscar_nombre(const tlistaLibros lista, bool & encontrado) {
    int pos;
    string nombre; 
    encontrado = false;
    char aux;
    cin.sync();
    rlutil::locate(30, 10);
    cout << "Ingrese el nombre del libro que busca: "; 
    getline(cin,nombre); 
    for (int i = 0; ((i < lista.contador_libros) && (!encontrado)); i++) {
        if (lista.ele_libros[i].nombre == nombre) {
            pos = i;
            encontrado = true;
        }
        else {
            pos = -1;
            encontrado = false; 
        }
    }
    return pos;
}


void buscar_autor(const tlistaLibros lista) 
{
    string autor;
    cin.sync();
    rlutil::locate(30, 10);
    int contador=0, cambioColumna = 0, numeracion = 0;
    cout << "Ingrese el nombre del autor que busca: ";
    getline(cin, autor);
    for (int i = 0; i < lista.contador_libros; i++) {
        if (lista.ele_libros[i].autor == autor) 
        {
            numeracion++;
            contador++;
            if (contador == 1)
            {
                rlutil::locate(15, 13);
                rlutil::setColor(rlutil::COLOR::BLACK);
                cout << "Los libros de " << "\"" << autor << "\"" << " son: ";
                contador = 2; 
            }

            rlutil::locate(15+cambioColumna, 13 + contador);
            rlutil::setColor(rlutil::COLOR::BROWN); 
            cout << numeracion << ". " <<  lista.ele_libros[i].nombre;
            if (contador % 11 == 0 )
            {
                cambioColumna += 30; 
                contador = 1; 
            }
            
        }
    }
    if (contador == 0)
    {
        rlutil::locate(10, 15);
        rlutil::setColor(rlutil::COLOR::RED);
        cout << "ERROR:";
        rlutil::locate(10, 17);
        rlutil::setColor(rlutil::COLOR::BLACK);
        cout << "No se encontró ningun libro del autor: " << autor;
    }
}


/*void buscar_codigo(const tlistaLibros lista)
{
    string codigo;
    cin.sync();
    rlutil::locate(30, 10);
    int contador = 0, cambioColumna = 0, numeracion = 0;
    cout << "Ingrese el codigo del libro que busca: ";
    getline(cin, codigo);
    for (int i = 0; i < lista.contador_libros; i++) {
        if (lista.ele_libros[i].codigo == codigo)
        {
            numeracion++;
            contador++;
            if (contador == 1)
            {
                rlutil::locate(15, 13);
                rlutil::setColor(rlutil::COLOR::BLACK);
                cout << "Los libros de codigo " << "\"" << codigo << "\"" << " son: ";
                contador = 2;
            }

            rlutil::locate(15 + cambioColumna, 13 + contador);
            rlutil::setColor(rlutil::COLOR::BROWN);
            cout << numeracion << ". " << lista.ele_libros[i].nombre;
            if (contador % 11 == 0)
            {
                cambioColumna += 30;
                contador = 1;
            }

        }
    }
    if (contador == 0)
    {
        rlutil::locate(10, 15);
        rlutil::setColor(rlutil::COLOR::RED);
        cout << "ERROR:";
        rlutil::locate(10, 17);
        rlutil::setColor(rlutil::COLOR::BLACK);
        cout << "No se encontró ningun libro del autor: " << autor;
    }
}*/
