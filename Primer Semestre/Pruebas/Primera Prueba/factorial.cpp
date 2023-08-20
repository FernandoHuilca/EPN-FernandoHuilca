#include <iostream>
using namespace std; 

int main ()
{
    double numero, factorial; 
    do
    {
      cout << "Escriba el numero que desea calcular el factorial: ";
      cin >> numero; 
      factorial = numero; 
      if (numero != static_cast<int>(numero))
      {
          cout << " ERROR: El numero ingresado es decimal \n intente con otro numero" << endl;
      }
      else if (numero < 0)
      {
          cout << "ERROR: El numero ingresado es negativo \n intente con otro numero" << endl;
      }
      else if (numero == 0)
      {
          cout << "El factorial del Cero es igual a: 1" << endl;
      }
      else 
      {
          for ( int i = numero; i > 0 ; i--)
          {
          factorial *= i;
          }
          
          cout << "El factorial del " << numero << " es: " << factorial << endl;   
      }
    } while ((numero != static_cast<int>(numero)) || (numero < 0));
    

}