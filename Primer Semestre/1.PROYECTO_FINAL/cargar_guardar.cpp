#include "cargar_guardar.h"


void cargar(tlistaLibros& lista, bool& ok)
{
    tLibros libro;
    ifstream leer_archivos;
    char aux;
    lista.contador_libros = 0;
    leer_archivos.open("Libros.txt");
    if (!leer_archivos.is_open())
    {
        ok = false;
    }
    else
    {
        ok = true;

        while ((!leer_archivos.eof()) && (lista.contador_libros < DIM_BOOK))
        {
            getline(leer_archivos, libro.nombre);
            getline(leer_archivos, libro.autor);
            getline(leer_archivos, libro.genero);
            getline(leer_archivos, libro.codigo);
            leer_archivos >> libro.existentes;
            leer_archivos.get(aux);
            leer_archivos >> libro.prestados;
            leer_archivos.get(aux);

            lista.ele_libros[lista.contador_libros] = libro;
            lista.contador_libros++;

        }
        leer_archivos.close();

    }

}




void Guardar(tlistaLibros& lista)
{

    ofstream escribir_archivo;
    escribir_archivo.open("Libros.txt");
    for (int i = 0; i < lista.contador_libros; i++)
    {
        escribir_archivo << lista.ele_libros[i].nombre << endl;
        escribir_archivo << lista.ele_libros[i].autor << endl;
        escribir_archivo << lista.ele_libros[i].genero << endl;
        escribir_archivo << lista.ele_libros[i].codigo << endl;
        escribir_archivo << lista.ele_libros[i].existentes << endl;
        escribir_archivo << lista.ele_libros[i].prestados << endl;
    }
    escribir_archivo.close();
}