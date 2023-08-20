#include "avanzados.h"

void potencia()
{
	int base, exponente; 
	double resultado; 
	cout << "Ingrese la base de la potencia: ";
	cin >> base; 
	cout << "Ingrese el exponente de la potencia: ";
	cin >> exponente; 
	resultado = 1; 
	if (exponente == 0)
	{
		cout << "El resultado de la potencia es: " << 1 << endl;
	}
	else if (exponente < 0)
	{
		for (int i = 0; i < (-1*exponente); i++)
		{
			resultado *= base;
		}
		cout << "El resultado de la potencia es: " << 1/resultado << endl;

	}
	else
	{
		for (int i = 0; i < exponente; i++)
		{
			resultado *= base;
		}
		cout << "El resultado de la potencia es: " << resultado << endl;
	}

}

void raiz_cuadrada()
{
	double numero, raiz;

	cout << "Ingrese un numero para calcular su raiz cuadrada: ";
	cin >> numero;

	//Función sqrt()
	raiz = sqrt(numero);

	cout << "La raiz cuadrada de " << numero << " es: " << raiz << endl;

}


void factorial()
{
	double numero, factorial;
	do
	{
		cout << "Escriba el numero que desea calcular el factorial: ";
		cin >> numero;
		factorial = numero;
		if (numero != static_cast<int>(numero))
		{
			cout << " ERROR: El numero ingresado es decimal \n intente con otro numero" << endl;
		}
		else if (numero < 0)
		{
			cout << "ERROR: El numero ingresado es negativo \n intente con otro numero" << endl;
		}
		else if (numero == 0)
		{
			cout << "El factorial del Cero es igual a: 1" << endl;
		}
		else
		{
			for (int i = numero; i > 0; i--)
			{
				factorial *= i;
			}

			cout << "El factorial del " << numero << " es: " << factorial << endl;
		}
	} while ((numero != static_cast<int>(numero)) || (numero < 0));


}


void fibonacci() 
{
	int extencion;

	cout << "Ingresa el numero de terminos de la serie de Fibonacci que deseas ver: ";
	cin >> extencion;

	int primero = 0, segundo = 1;

	cout << "Serie de Fibonacci de " << extencion<< " terminos:" << endl;

	for (int i = 0; i < extencion; i++) {
		cout << primero << " ";

		int siguiente = primero + segundo;
		primero = segundo;
		segundo = siguiente;
	}

	cout << endl;


}