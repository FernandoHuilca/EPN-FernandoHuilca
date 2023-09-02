#pragma once
#include <string>
#include <iostream>
using namespace std;
const int DIM_BOOK = 500;

typedef struct
{
    string nombre, autor, genero, codigo;
    int existentes;
    int prestados;
}tLibros;
typedef struct
{
    tLibros ele_libros[DIM_BOOK];
    int contador_libros;
}tlistaLibros;
