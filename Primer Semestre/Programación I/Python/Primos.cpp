/*Preguntar al usuario un numero y decirle si es primo o no */
#include <iostream>
using namespace std; 

int main ()
{
    int numero; 
   cout << "Ingrese el numero que desea saber si es primo: " ; 
   cin >> numero ; 
   if (numero <= 1)
   {
    cout << "El numero ingresado no es primo "  << endl; 
    return 0; //Para escaparnos 
   }
   for (int i = 2; i * i <= numero; i++) 
   {
        if (numero % i == 0)
        {
            cout << "El numero ingresado no es primo" << endl;
            
        }
        else 
        {
            cout << "El numero ingresado SI es primo " << endl; 
        }
    }

    return 0; 
}