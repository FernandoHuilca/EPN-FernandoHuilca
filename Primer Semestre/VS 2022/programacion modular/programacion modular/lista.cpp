#include <iostream>
#include <string>
using namespace std;
#include <fstream>
#include <iomanip>
#include "lista.h"
tRegistro nuevo()
{
	tRegistro registro;
	cout << "Introduce el código: ";
	cin >> registro.codigo;
	cout << "Introduce el nombre: ";
	cin >> registro.nombre;
	cout << "Introduce el sueldo: ";
	cin >> registro.sueldo;
	return registro;
}
	void insertar(tLista & lista, tRegistro registro, bool& ok) 
	{
		ok = true;
		if (lista.cont == N) {
			ok = false; // Lista llena
		}
		else {
			int i = 0;
			// Insertamos en la posición i
			for (int j = lista.cont; j > i; j--) {
				// Desplazamos a la derecha
				lista.registros[j] = lista.registros[j - 1];
			}
			lista.registros[i] = registro;
			lista.cont++;
		}
	}
	void eliminar(tLista& lista, int pos, bool& ok) { // pos = 1..
		ok = true;
		if ((pos < 1) || (pos > lista.cont)) {
			ok = false; // Posición inexistente
		}
		else {
			pos--; // Pasamos a índice del array
			for (int i = pos + 1; i < lista.cont; i++) {
				// Desplazamos a la izquierda
				lista.registros[i - 1] = lista.registros[i];
			}
			lista.cont--;
		}
	}
