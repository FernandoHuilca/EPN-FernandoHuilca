// Autor: Fernando Huilca 
// Programa para practicar while
/*Preguntar al usuario un número entero y positivo n y sumar los números 
desde 1 hasta n*/
#include <iostream> 
using namespace std;

/*int main()
{
    unsigned int n = 0;
    int m = 0;
    bool boleano = true;
    cout << "Introduzca un numero entero y positivo por favor: " << endl;
    cin >> n;
    while (m <= (n-1))
    {
        m = m + 1;
        cout << m << endl ;
    }


    return 0;
}*/
int main ()
{
    int limite;
    cout << "Hasta que numero desea imprimir en pantalla: " << endl; 
    cin >> limite; 
    for (int i = 1; i <= limite; i++ )
        { 
            cout << i << endl; 
        }
   

}