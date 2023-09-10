#pragma once
#include "Estructura.h"
#include "rlutil.h"

int buscar_nombre(const tlistaLibros lista, bool& encontrado);
void buscar_autor(const tlistaLibros lista);
void buscar_codigo(const tlistaLibros lista);
void buscar_por_categoria(tlistaLibros lista, int num_categoria);