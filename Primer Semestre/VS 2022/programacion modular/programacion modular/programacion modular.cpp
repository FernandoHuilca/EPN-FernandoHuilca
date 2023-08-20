#include <iostream>
#include <string>
using namespace std;
#include <iomanip>
#include "lista.h"
int menu();
string contrasenia = "12345", password;
string usuario = "FernandoHuilca", user;



int main() 
{

	bool acceso = true;
	do
	{
		cout << "Ingrese Usuario: " << endl;
		getline(cin, user);
		cout << "Ingrese Contrasenia: " << endl;
		getline(cin, password);
		if ((user == usuario) && (contrasenia == password))
		{
			acceso = false;
			tLista lista;
			bool ok = true;
			int op, pos;

			if (!ok)
			{
				cout << "No se ha podido abrir el archivo!" << endl;
			}
			else
			{
				do
				{

					op = menu();
					if (op == 1)
					{
						tRegistro registro = nuevo();
						insertar(lista, registro, ok);
						if (!ok)
						{
							cout << "Error: Lista llena!" << endl;
						}
					}
					else if (op == 2)
					{
						cout << "Posición: ";
						cin >> pos;
						eliminar(lista, pos, ok);
						if (!ok)
						{
							cout << "Error: Posicion inexistente!" << endl;
						}
					}
					else if (op == 3)
					{
						string nombre;
						cin.sync();
						cout << "Nombre: ";
						cin >> nombre;
					}
				} while (op != 0);

			}
		}
		else
		{
			cout << "Usuario y contrasenia incorrectos" << endl;
			cout << "Intente nuevamente" << endl;
			acceso = true; 
		}



	} while (acceso);
	
	return 0;
}
int menu() 
{
	cout << endl;
	cout << "1 - Insertar" << endl;
	cout << "2 - Eliminar" << endl;
	cout << "3 - Buscar" << endl;
	cout << "0 - Salir" << endl;
	int op;
	cin >> op;
	return op;
}