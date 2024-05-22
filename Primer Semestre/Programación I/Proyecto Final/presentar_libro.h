#pragma once

#include "Estructura.h"
#include "rlutil.h"

void dibujo_libro();
void presentar_Info_libro(tlistaLibros& lista, int pos);
void dibujo_cuadro();
int presentar_opciones_libro();
void ColorSeleccion_presentar(string text, int posX, int posY, bool selected);
