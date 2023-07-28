// Author Fernando Huica
/*6.	Escriba un programa que lea tres valores double distintos de cero, y que determine e imprima si podrían representar los lados de un triángulo.*/

#include <iostream>
using namespace std; 

int main() 
{
    double a, b, c; 
    cout << "Escriba el primer numero: " ;
    cin >> a; 
    cout << "Escriba el segundo numero: " ;
    cin >> b;
    cout << "Escriba el tercer numero: " ;
    cin >> c;    
    /* Para saber si estos numeros pueden formar un triangulo se toma en cuenta que la suma de dos de sus lados debe ser mayor a la longitud del tercer lado*/
    if (a+b > c)
    {
        cout << "Si pueden formar un triangulo" << endl; 
    }
    else 
    {
        cout << "Los lados no pueden formar un triangulo" << endl; 
    }
    return 0;
}
