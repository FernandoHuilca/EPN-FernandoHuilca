#pragma once
#include <iostream>
#include <sstream>
using namespace std; 

//constantes:
int const DIM_AMIGOS = 500;

typedef struct
{
	string nombre; 
	string usuario; 
	string contrasenia; 
	Amigo amigo[DIM_AMIGOS];
}tUsuario;

class Amigo
{
public:
	Amigo();
	~Amigo();

private:

};

Amigo::Amigo()
{
}

Amigo::~Amigo()
{
}