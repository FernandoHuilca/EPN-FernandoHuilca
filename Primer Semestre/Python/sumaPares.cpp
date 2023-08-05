/*Es la suma de los números pares que hay (1 al 100) y a eso sacar promedio*/
#include <iostream>
using namespace std; 

int main ()
{
    int limite = 100 , suma = 0, contador=0; 
    for (int i = 1; i <= limite; i++)
    {
     if ( i % 2 == 0 )
     {
        suma = suma +i ; 
        contador ++;
     }    
    }

        cout << "La summa de los pares (1 al 100) es: " << suma << endl;  
        cout << "El primedio de dicha suma es: " << suma/contador << endl; 


    return 0; 
}