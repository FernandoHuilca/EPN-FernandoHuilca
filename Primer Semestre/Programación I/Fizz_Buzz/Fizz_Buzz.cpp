// Author Fernando Huilca
/*Programa que imprime 1 al 100 donde multiplos de 3 = Fizz, multiplos de 5 = Buzz
  y finalmente multiplos de 3 y 5 Fizz Buzz */
#include <iostream> 
using namespace std; 

int main ()
{
    int TAM = 100;
    for (int i = 1; i <= TAM; i++)
    {   
        if (i % 3 == 0 && i % 5 == 0 )
        {
            cout << "Fizz Buzz " << endl; 
        }
        else if (i % 3 == 0)
        {
            cout << "Fizz " << endl; 
        }
        else if (i % 5 == 0)
        {
            cout << "Buzz " << endl; 
        }
        else
        cout << i << endl; 
    }


    return 0; 
}
