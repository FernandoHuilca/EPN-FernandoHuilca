#pragma once
#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
using namespace std;

#include "Estructura.h"



//Prototipos
void cargar(tlistaLibros& lista, bool& ok);
void Guardar(tlistaLibros& lista);