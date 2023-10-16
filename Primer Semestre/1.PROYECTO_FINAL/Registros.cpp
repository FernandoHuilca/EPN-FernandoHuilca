
#include "Registros.h"


bool cargar(Tlista_usuarios& lista)
{
	ifstream leer_archivo;
	bool ok = true;
	Tusuarios usuario;
	lista.contador = 0;

	leer_archivo.open("Registros.txt");
	if (!leer_archivo.is_open())
	{
		ok = false;
		rlutil::setColor(rlutil::COLOR::RED);
		cout << "ERROR:";
		rlutil::setColor(rlutil::COLOR::WHITE);
		cout << "No se puedo abrir el archivo de usuarios." << endl;
	}
	else
	{
		ok = true;
		while ((!leer_archivo.eof()) && (lista.contador < DIM_user))
		{
			getline(leer_archivo, usuario.user);
			//cout << usuario.user << endl; 
			getline(leer_archivo, usuario.password);
			//cout << usuario.password << endl; 

			lista.elemen_usuarios[lista.contador] = usuario;
			lista.contador++;
		}
	}

	return ok;
}

bool login(Tlista_usuarios& lista, int& pos_usuario)
{
	string usuario;
	string contrasenia;
	bool acceso = true, correcto = false;
	while (acceso)
	{

		system("color 7B");

		if (correcto)
		{
			system("cls");
			rlutil::locate(56, 21);
			rlutil::setColor(rlutil::COLOR::RED);
			cout << "ERROR: ";
			rlutil::locate(48, 22);
			rlutil::setColor(rlutil::COLOR::BLACK);
			cout << "Intente nuevamente.";
			rlutil::locate(48, 23);
			cout << "¿Olvidó su contraseña ? " << endl;
		}

		rlutil::setColor(rlutil::COLOR::BLACK);
		Dibujar_contorno_login();
		Dib_Contorno_login();
		dibujo_cuadro_usuario();
		dibujo_cuadro_password();
		rlutil::locate(55, 11);
		cout << "LOGIN";
		rlutil::locate(45, 18);
		cout << "Contraseña: ";
		rlutil::locate(45, 14);
		cout << "Usuario: ";
		getline(cin, usuario);
		rlutil::locate(45, 18);
		cout << "Contraseña: ";
		getline(cin, contrasenia);
		for (int i = 0; (i < lista.contador) && (acceso); i++)
		{
			if ((usuario == lista.elemen_usuarios[i].user) && (contrasenia == lista.elemen_usuarios[i].password))
			{
				pos_usuario = i;
				acceso = false;
			}
			else
			{
				correcto = true;
			}
		}



	}

	return true;

}


void Dib_Contorno_login()
{
	int columna = 45, fila = 9;
	int largo = columna + 28, ancho = fila + 9;
	int aux = 0;
	for (int i = columna; i <= largo; i++)
	{
		rlutil::locate(i, fila);
		if (aux % 2 == 0)
		{
			cout << " ";
		}
		else
		{
			cout << (char)42;
		}
		aux++;

	}
	aux = 0;
	// Líneas oblicuas izquierda 
	for (int i = fila + 1; i < ancho; i++)
	{
		rlutil::locate((columna - 1) - aux, i);
		cout << (char)42;
		aux++;
	}
	for (int i = fila + 1; i < ancho; i++)
	{
		rlutil::locate((columna + 1) - aux, i + (ancho - fila) - 1);
		cout << (char)42;
		aux--;
	}
	//linea oblicuas derechas
	for (int i = fila + 1; i < ancho; i++)
	{
		rlutil::locate((largo + 1) + aux, i);
		cout << (char)42;
		aux++;
	}
	for (int i = fila + 1; i < ancho; i++)
	{
		rlutil::locate((largo)+aux, i + (ancho - fila) - 2);
		cout << (char)42;
		aux--;
	}

	// Línea inferior 
	for (int i = columna; i <= largo; i++)
	{
		rlutil::locate(i, ancho + (ancho - fila) - 2);
		if (aux % 2 == 0)
		{
			cout << " ";
		}
		else
		{
			cout << (char)42;
		}

		aux++;
	}

}

void dibujo_cuadro_usuario()
{
	int columna = 45, fila = 13;
	int largo = columna + 28, ancho = fila + 2;
	// Línea superior
	rlutil::locate(columna - 1, fila);
	cout << (char)218;
	for (int i = columna; i <= largo; i++)
	{
		rlutil::locate(i, fila);
		cout << (char)196;
	}
	cout << (char)191;
	// Líneas verticales izquierda 
	for (int i = fila + 1; i < ancho; i++)
	{
		rlutil::locate(columna - 1, i);
		cout << (char)179;
	}
	rlutil::locate(columna - 1, ancho);
	cout << (char)192;
	// Lineas verticales derecha
	for (int i = fila + 1; i < ancho; i++)
	{
		rlutil::locate(largo + 1, i);
		cout << (char)179;
	}
	rlutil::locate(largo + 1, ancho);
	cout << (char)217;

	// Línea inferior
	for (int i = columna; i <= largo; i++)
	{
		rlutil::locate(i, ancho);
		cout << (char)196;
	}

}
void dibujo_cuadro_password()
{
	int columna = 45, fila = 17;
	int largo = columna + 28, ancho = fila + 2;
	// Línea superior
	rlutil::locate(columna - 1, fila);
	cout << (char)218;
	for (int i = columna; i <= largo; i++)
	{
		rlutil::locate(i, fila);
		cout << (char)196;
	}
	cout << (char)191;
	// Líneas verticales izquierda 
	for (int i = fila + 1; i < ancho; i++)
	{
		rlutil::locate(columna - 1, i);
		cout << (char)179;
	}
	rlutil::locate(columna - 1, ancho);
	cout << (char)192;
	// Lineas verticales derecha
	for (int i = fila + 1; i < ancho; i++)
	{
		rlutil::locate(largo + 1, i);
		cout << (char)179;
	}
	rlutil::locate(largo + 1, ancho);
	cout << (char)217;

	// Línea inferior
	for (int i = columna; i <= largo; i++)
	{
		rlutil::locate(i, ancho);
		cout << (char)196;
	}

}

void Dibujar_contorno_login()
{
	// Línea superior
	for (int i = 4; i < 118; i++)
	{
		rlutil::locate(i, 3);
		cout << (char)205;
	}


	// Líneas verticales izquierda y derecha
	for (int i = 4; i < 28; i++)
	{
		rlutil::locate(3, i);
		cout << (char)186;

		rlutil::locate(118, i);
		cout << (char)186;
	}
	rlutil::locate(3, 2);
	// Línea inferior
	for (int i = 4; i < 118; i++)
	{
		rlutil::locate(i, 28);
		cout << (char)205;
	}

}

