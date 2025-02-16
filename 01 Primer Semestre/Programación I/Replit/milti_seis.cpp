//Imprimir un arreglo con los 15 primeros multiplos de 6 
#include <iostream>
using namespace std;
void imprima(const int array[]);
const int TAM = 15;

int main() 
{
  int multiplos [TAM] ;
  for (int i = 0; i < TAM; i++)
    {
      multiplos [i] = 6 * (i+1);
    }
  imprima(multiplos);
  return 0;
}


void imprima(const int array[]){
    cout <<"Arreglo los 15 primeros multiplos de 6 " <<endl;
       for (int i = 0; i < TAM; i++) {
        cout << array[i]  << endl;
    }
}