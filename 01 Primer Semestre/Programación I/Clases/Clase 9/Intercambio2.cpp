//Author Fernando Huilca 
#include <iostream>
#include <string>
using namespace std;
void intercambia(double &a, double &b);

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
    intercambia (num1, num2);
    cout << "****INTERCAMBIO*****" << endl; 
    cout << "Valor1 es igual a: " << num1 << endl;
    cout << "Valor2 es igual a: " << num2 << endl;
}
void intercambia (double &a, double &b)
{
    double aux; 
    aux = a; 
    a = b; 
    b = aux; 

}
    

