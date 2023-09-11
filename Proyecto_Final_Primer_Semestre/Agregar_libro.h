#pragma once
#include <iostream>
using namespace std;
#include "Estructura.h"
#include "rlutil.h"
void ColorSeleccionn(string text, int posX, int posY, bool selected);
int seleccion_categoria();
void insertar_Insertar(tlistaLibros &lista, tLibros &libro, bool& ok);
void leer_libro(tlistaLibros& lista, tLibros& libro, bool& ok);