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

