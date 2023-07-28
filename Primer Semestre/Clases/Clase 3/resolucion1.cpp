// Autor: Fernando Huilca 
// Programa para practicar while
/*Preguntar al usuario un número entero y positivo n y sumar los números 
desde 1 hasta n*/
#include <iostream> 
using namespace std; 

/* int main ()
{
    unsigned int n, suma=0, contador=1;
    cout << "Hasta que número sumar " << endl; 
    cin >> n; 
    while (contador <= n)
    {
        cout << contador << endl;
        suma = suma+contador; // suma+=contador  
        contador++;
    }
    cout << "La suma es: " << suma << endl;

    return 0;
}*/
 int main ()
 {
    int limite, suma = 0; 
    cout << "Hasta que numero desea que se sume? " << endl; 
    cin >> limite;
    for (int i=1; i <= limite; i++)
    {
        cout << i << endl;
        suma = i + suma;
    } 
    cout << "El resultado de la sumas es: " << suma; 
 }
