// Author Fernando Huica
/*3.	Escribe un programa que lea un operando (real), un operador (carácter) y otro operando (real), todo en una misma línea, y muestre el resultado de la operación correspondiente (operadores contemplados: +, ‐, * y /). Utilice una instrucción switch para resolver este problema. */
#include <iostream>
using namespace std; 

int main() {
    double a, b; 
    char operador; 
    cout << "Introduzca la operacion que desea hacer de modo operando operador operando: ";
    cin >> a >> operador >> b ; 
    switch (operador)
    {
    case '+':
        cout << " El resultado de la suma es: " << a << " " << operador << " " << b << " = " << a+b;   
        break;
    case '-':
        cout << " El resultado de la resta es: " << a << " " << operador << " " << b << " = " << a-b;   
        break;
    case '*':
        cout << " El resultado de la multiplicacion es: " << a << " " << operador << " " << b << " = " << a*b;   
        break;
    case '/':
        cout << " El resultado de la division es: " << a << " " << operador << " " << b << " = " << a/b;   
        break;
    default:
        cout << "Operacion ingresada incorrecta" << endl ; 
        break;
    }

    return 0;
}
