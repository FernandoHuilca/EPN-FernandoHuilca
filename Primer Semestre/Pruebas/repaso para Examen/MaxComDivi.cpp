// Author Fernando Huilca 
/*Escribir un programa que lea 3 numeros enteros e imprima en pantalla el maximo comun divisor de ellos*/
#include <iostream> 
using namespace std;

int main()
{
    int a, b;
    char opcion;
    char aux;
 
    do
    {
        cout << "Escriba el primer numero " << endl;
        cin >> a;
        cout << "Escriba el segundo numero numero " << endl;
        cin >> b;

        // a = 22 b = 33 
        if (a > 0 && b > 0 && a != b)
        {
            if (a > b)
            {
                aux = a;
                a = b;
                b = aux;
            }
            bool isMCD = false;
            int x = a;
            while (!isMCD)
            {
                if (a % x == 0 && b % x == 0)
                {
                    cout << "El maximo comun divisor de los numeros es " << x << endl;
                    isMCD = true;
                }
                x--;
            }

        }
        else
        {
            if (a == b)
            {
                cout << "ERROR: numeros ingresados son iguales " << endl;
            }
            else
                cout << "ERROR: Numeros ingresados negativos " << endl;
        }


        cout << "Desea continuar en el programa si (y) no (n)" << endl;
        cin >> opcion;
    } while (opcion == 'Y' || opcion == 'y');

}