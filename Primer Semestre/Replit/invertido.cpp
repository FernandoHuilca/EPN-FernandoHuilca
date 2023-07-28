//Solicitar al usuario que ingrese 5 números para un arreglo, guardar estos datos en un arreglo, imprimirlo y luego invertir el arreglo e imprimirlo nuevamente.
// Utilizar tres funciones, leer_datos, imprimir, invertir.
#include <iostream>
using namespace std;
const int DIM = 5;
// Funcion que lee los datos 
void leer_datos (int array [DIM]);
// Funcion que imprime los datos 
void imprimir (int array [DIM]);
// Funcion que invierte los datos 
void invertir (int array [DIM]);


int main() 
{
    int array[DIM];
    leer_datos(array);
    cout << "Arreglo ingresado:" << endl;
    imprimir(array);
    cout << "Arreglo invertido:" << endl;
    invertir(array);
    imprimir(array);

    return 0;
  
}

// Funciones 
void leer_datos(int array[DIM])
{
    cout << "Escriba " << DIM << " números que desee." << endl;
    for (int i = 0; i < DIM; i++)
    {
        cout << "Número " << i + 1 << ": ";
        cin >> array[i];
    }
}
void imprimir(int array[DIM])
{
    for (int i = 0; i < DIM; i++)
    {
        cout << array[i] << endl;
    }
}
void invertir(int array[DIM])
{
  //Ejemplo 1 2 3 4 5
    int aux, contador = DIM -1;; //Declaro variable auxiliar y contador 
    for (int i = 0; i < DIM / 2; i++) // DIM/2=2 solo se repite dos veces
    { 
        aux = array[i]; // Aux toma los valores iniciales (1 y 2)
        array[i] = array[contador]; // (5 2 3 4 5)....(5 4 3 4 1)
        array[contador] = aux;  //(5 2 3 4 1)....(5 4 3 2 1)
      contador --;
    }
}

