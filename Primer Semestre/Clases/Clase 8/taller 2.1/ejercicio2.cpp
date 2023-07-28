// Tengo un dato de entrada 
#include <iostream> 
using namespace std;
#include <fstream> // Para usar leer files (carpetas)

int main()
{
    int dat1= 1234, invertido; //nombres claros 
    while (dat1 > 0) // se ingresa al bucle
    {
        invertido = dat1 % 10; // residuo me da el ultimo numero
        dat1 = dat1 / 10; // quito el ultimo numero porque son datos enteros 
        cout << invertido; // imprimo el numero 
    }
    



}