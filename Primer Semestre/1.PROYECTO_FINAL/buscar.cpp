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
            rlutil::setColor(rlutil::COLOR::LIGHTMAGENTA);
            cout << numeracion << ". " << "\"" <<  lista.ele_libros[i].nombre << "\"" << " Código: " << lista.ele_libros[i].codigo;
            if (contador % 11 == 0 )
            {
                cambioColumna += 38; 
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


void buscar_codigo(const tlistaLibros lista)
{
    string codigo;
    cin.sync();
    int contador = 0;
    rlutil::locate(30, 10);
    cout << "Ingrese el codigo del libro que busca: ";
    getline(cin, codigo);
    for (int i = 0; i < lista.contador_libros; i++) {
        if (lista.ele_libros[i].codigo == codigo)
        {

            rlutil::locate(15, 13);
            rlutil::setColor(rlutil::COLOR::BLACK);
            cout << "El libro de codigo " << "\"" << codigo << "\"" << " es: ";
      

            rlutil::locate(15, 15);
            rlutil::setColor(rlutil::COLOR::LIGHTMAGENTA);
            cout << "1. " << "\"" << lista.ele_libros[i].nombre << "\"" << " del escritor: " << lista.ele_libros[i].autor;
            contador = 1;

        }
    }
    if (contador == 0)
    {
        rlutil::locate(10, 15);
        rlutil::setColor(rlutil::COLOR::RED);
        cout << "ERROR:";
        rlutil::locate(10, 17);
        rlutil::setColor(rlutil::COLOR::BLACK);
        cout << "No se encontró ningun libro con el código: " << codigo;
    }
}

void buscar_por_categoria(tlistaLibros lista, int num_categoria)
{
    switch (num_categoria)
    {
    case 0:
    {
        int contador = 0;
        system("cls");
        rlutil::locate(8, 8);
        rlutil::setColor(rlutil::COLOR::BLACK);
        cout << "Los libros de la categoría " << "\"" << "ficción" << "\"" << " son: ";
        for (int i = 0; i < lista.contador_libros; i++)
        {
            if (lista.ele_libros[i].genero == "Ficción")
            {
                contador++;
                rlutil::locate(9, 9+contador);
                rlutil::setColor(rlutil::COLOR::LIGHTMAGENTA);
                cout << contador << ". " << "\"" << lista.ele_libros[i].nombre << "\"" << " del escritor: " << lista.ele_libros[i].autor;
                

            }
        }
        break;
    }
    case 1:
    {
        int contador = 0;
        system("cls");
        rlutil::locate(8, 8);
        rlutil::setColor(rlutil::COLOR::BLACK);
        cout << "Los libros de la categoría " << "\"" << "fantasía" << "\"" << " son: ";
        for (int i = 0; i < lista.contador_libros; i++)
        {
            if (lista.ele_libros[i].genero == "Fantasía")
            {
                contador++;
                rlutil::locate(9, 9 + contador);
                rlutil::setColor(rlutil::COLOR::LIGHTMAGENTA);
                cout << contador << ". " << "\"" << lista.ele_libros[i].nombre << "\"" << " del escritor: " << lista.ele_libros[i].autor;


            }
        }
        break;
    }
    case 2:
    {
        int contador = 0;
        system("cls");
        rlutil::locate(8, 8);
        rlutil::setColor(rlutil::COLOR::BLACK);
        cout << "Los libros de la categoría " << "\"" << "educación" << "\"" << " son: ";
        for (int i = 0; i < lista.contador_libros; i++)
        {
            if (lista.ele_libros[i].genero == "Educación")
            {
                contador++;
                rlutil::locate(9, 9 + contador);
                rlutil::setColor(rlutil::COLOR::LIGHTMAGENTA);
                cout << contador << ". " << "\"" << lista.ele_libros[i].nombre << "\"" << " del escritor: " << lista.ele_libros[i].autor;


            }
        }
        break;
    }
    case 3:
    {
        int contador = 0;
        system("cls");
        rlutil::locate(8, 8);
        rlutil::setColor(rlutil::COLOR::BLACK);
        cout << "Los libros de la categoría " << "\"" << "juvenil" << "\"" << " son: ";
        for (int i = 0; i < lista.contador_libros; i++)
        {
            if (lista.ele_libros[i].genero == "Juvenil")
            {
                contador++;
                rlutil::locate(9, 9 + contador);
                rlutil::setColor(rlutil::COLOR::LIGHTMAGENTA);
                cout << contador << ". " << "\"" << lista.ele_libros[i].nombre << "\"" << " del escritor: " << lista.ele_libros[i].autor;


            }
        }
        break;
    }
    case 4:
    {
        int contador = 0;
        system("cls");
        rlutil::locate(8, 8);
        rlutil::setColor(rlutil::COLOR::BLACK);
        cout << "Los libros de la categoría " << "\"" << "clásicos" << "\"" << " son: ";
        for (int i = 0; i < lista.contador_libros; i++)
        {
            if (lista.ele_libros[i].genero == "Clásicos")
            {
                contador++;
                rlutil::locate(9, 9 + contador);
                rlutil::setColor(rlutil::COLOR::LIGHTMAGENTA);
                cout << contador << ". " << "\"" << lista.ele_libros[i].nombre << "\"" << " del escritor: " << lista.ele_libros[i].autor;


            }
        }
        break;
    }
    default:
    {
        rlutil::setColor(rlutil::COLOR::LIGHTMAGENTA);
    }
        break;
    }
}