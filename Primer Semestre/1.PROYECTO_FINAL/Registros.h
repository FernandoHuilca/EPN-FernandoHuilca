#pragma once
#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
#include "rlutil.h"	
using namespace std;


const int DIM_user = 100;

typedef struct
{
	string user;
	string password;

}Tusuarios;

typedef struct
{
	Tusuarios elemen_usuarios[DIM_user];
	int contador;
}Tlista_usuarios;


//Prototipos
bool login(Tlista_usuarios& lista, int& pos_usuario);
bool cargar(Tlista_usuarios& lista);
void Dib_Contorno_login();
void dibujo_cuadro_usuario();
void dibujo_cuadro_password();
void Dibujar_contorno_login();