#pragma once
#include <string>
//#include <iostream>
using namespace std;
const int N = 100;
typedef struct {
	int codigo;
	string nombre;
	double sueldo;
} tRegistro;
typedef tRegistro tArray[N];
typedef struct {
	tArray registros;
	int cont;
} tLista;

const string BD = "bd.txt";

tRegistro nuevo();
void insertar(tLista& lista, tRegistro registro, bool& ok);
void eliminar(tLista& lista, int pos, bool& ok); // pos = 1..N
