#pragma once
#include <iostream>
#include <string>
using namespace std;
#include <fstream>
#include "Estructura.h"

void alquilar(tlistaLibros& lista, tUserslist& list, bool& control, int& pos);
// modifica la estrucutura de libros y usuarios
void devolver(tlistaLibros& lista, tUserslist& list, bool& control);
// se debe definir una opccion para devolver el libro desde el inicio del programa
void cargar_prestamistas(tUserslist& list, bool& ok);
void Guardar_prestados(tUserslist& list);