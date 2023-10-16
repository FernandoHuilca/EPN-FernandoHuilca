#pragma once
#include <string>
#include <iostream>
#include <ctime>
using namespace std;
const int DIM_BOOK = 500;
const int USER = 100;

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
typedef struct
{
    string usuario, cedula, telefono, libro;
    int anio, mes;
    int dia;
}tUsuarios;
typedef struct
{
    tUsuarios user[USER];
    int contador;
}tUserslist;