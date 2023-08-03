// Author Fernando Huilca
/*Programa que imprime 1 al 100 donde multiplos de 3 = Fizz, multiplos de 5 = Buzz
  y finalmente multiplos de 3 y 5 Fizz Buzz */
  // SIN USAR EL OPERADOR MODULO NIVEL DE DIFICULTAL MEDIO
#include <iostream> 
using namespace std; 

int main ()
{
    int contador = 1;
    int contador2 = 1;
    for (int i=1; i <= 100; i++)
    {
        
        if (contador == 3 && contador2 == 5)
        {
            cout << "Fizz Buzz" << endl; 
            contador = 0;
            contador2 = 0;
        }
        else if (contador == 3 ) 
        {
            cout << "Fizz" << endl; 
            contador = 0;
        }
        else if (contador2 == 5 ) 
        {
            cout << "Buzz" << endl; 
            contador2 = 0;
        }
        else 
        cout << i << endl; 

        contador ++;
        contador2 ++;
         

    }
}
