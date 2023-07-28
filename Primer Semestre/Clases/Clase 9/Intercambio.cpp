//Author Fernando Huilca 
#include <iostream>
#include <string>
using namespace std;
void modificar(double &a );

int main()

{
    double num1, num2;
    cout << "Valor1: " ;
    cin >> num1; 
    cout << "Valor2: " ;
    cin >> num2;
    cout << "Valor1 es igual a " << num1 << endl; 
    cout << "Valor2 es igual a " << num2 << endl; 
    cout << "La dirreccion de valor 1 es: " << &num1 << endl;
    cout << "La dirreccion de valor 2 es: " << &num2 << endl;
    modificar (num1);
    cout << "Valor1 es igual a: " << num1 << endl;
}
void modificar (double &a)
{
    a++;
}
    

