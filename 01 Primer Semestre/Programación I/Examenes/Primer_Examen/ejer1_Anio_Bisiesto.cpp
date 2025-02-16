/*1.	(10 puntos) Años bisiestos. En PSEINT realizar el seudocódigo para saber cuando un año es bisiesto.
El programa solicitará al usuario ingresar un año entre 1800 y el año 2200, si el usuario no ingresa un valor
en ese rango se le pedirá que ingrese un número correcto, cuando el valor sea correcto se presentará alguno de los dos mensajes:
“El año ingresado es bisiesto” o “El año ingresado NO es bisiesto”. Para esto, considere que: un año es bisiesto si divisible por 4, e
xcepto el último de cada siglo, excepto si este es divisible por 400. Pegar el seudocódigo de PSEINT.*/

//Author Fernando Huilca
#include <iostream>
using namespace std;

//PROTOTIPOS DE FUNCIONES
//Funcion que evalua si el anio ingresado es o no bisiesto
bool anio_bisiesto(bool& bisiesto, int& anio);


int main()
{
	bool correcto = true;
	bool bisiesto;
	cout << "________Bienvenido al programa de anios Bisiestos________" << endl << endl;
	while (correcto)
	{
		int anio;
		cout << "Escriba un anio (entre 1800 y 2200) para saber si es bisiesto \nEscriba 0 (cero) para salir: ";
		cin >> anio;

		if ((anio >= 1800) && (anio <= 2200))
		{
			correcto = true;
			if (anio_bisiesto(bisiesto, anio))
			{
				cout << "\nEl anio " << anio << " SI es bisiesto" << endl << endl;
			}
			else
			{
				cout << "\nEl anio " << anio << " NO es bisiesto" << endl << endl;
			}

		}
		else
		{
			if (anio == 0)
			{
				correcto = false;
			}
			else
			{
				correcto = true;
				cout << "\nERROR: \n El anio ingresado no esta entre 1800 y 2200 \n intente nuevamente." << endl << endl;
			}

		}
	}

	return 0;
}


bool anio_bisiesto(bool& bisiesto, int& anio)
{
	if ((anio & 4) == 0)
	{

		bisiesto = true;
	}
	else
	{
		bisiesto = false;
	}
	return bisiesto;
}