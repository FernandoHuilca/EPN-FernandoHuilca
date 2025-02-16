//Author Fernando Huilca 
/*1. Escriba un programa que calcule la suma de los números primos que existe entre un rango de valores. El programa le preguntará al usuario el limite inferior y el limite superior de este rango, luego presentará el resultado. Se debe comprobar que los valores ingresados son enteros positivos y que el limite inferior es menor al limite superior. EL programa debe permitir realizar este cálculo las veces que el usuario requiera.*/
#include <iostream> 
using namespace std; 
bool isPrimo(int num); 

int main ()
{
    int limitesuperior, limiteinferior;
    char opcion= 'Y';
      

    do 
    {
        

        cout << "Ingrese el limite inferior: " << endl; 
        cin >> limiteinferior; 
        cout << "Ingrese el limite superior: " << endl; 
        cin >> limitesuperior; 
        if ( limiteinferior > 0 && limiteinferior < limitesuperior)
        {
            int suma = 0;

            for (int x = limiteinferior; x <= limitesuperior; x++)
            {
                if (isPrimo(x))
                {
                    suma += x; 
                }
            }
            cout << "El resultado de la suma de los numero primos entre " << limiteinferior << " y " 
            << limitesuperior << " es igual a " << suma << endl; 
            cout << "Desea seguir ocupando la calculadora de limites? SI (y) NO (n)" << endl;
            cin >> opcion; 
        }
        else 
        {
            cout << "Numeros ingresados incorrectos. Intentelo nuevamente " << endl;
        }
    }
    while (opcion == 'y' || opcion == 'Y');

    return 0;
}


// codigo para saber si un numero es primo o no 
bool isPrimo (int num)
{
    if (num <= 1)
    {
        return false; 
    }
   
    for (int i = 2 ; i  < num; i++) //Tambien se puede hacer con for (int i = 2 ; i * i <= num; i++) que seria incluso mejor 
    {
        if (num % i == 0)
        {
            return false; 
        } 
    }

    return true;     
}
