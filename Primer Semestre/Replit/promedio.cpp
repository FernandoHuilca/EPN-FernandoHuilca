//Escribir un programa que solicite 5 numeros al usuario los almacene en un arreglo y calcule su promedio


#include <iostream>
using namespace std;
const int DIM = 5;

//Funcion que me calcula el promedio de un arrelgo numerico
double promedio (int numero[DIM]);

int main() 
{
  int contador = 0, numero; // cambio el contador para usarlo en el array
  int array [DIM];
  cout << "Escriba los 5 numeros para su promedio" << endl;
  while (contador < DIM)
    {
      cout << "Numero " << contador +1 << ": " ; 
      cin >> numero; 
      array [contador] = numero; 
      contador ++; 
    }
  cout << "El promedio de sus " << DIM << " numeros ingresados es de: "
    << promedio (array) << endl; 
}

double promedio (int numero[DIM])
{
  int suma = 0;
  double promedio; 
  for (int i=0; i < DIM; i++)
    {
      suma += numero[i]; // suma= suma + numero[i]
      
    }
  promedio = double(suma)/DIM;
  return promedio; 
}



//Tarea: generar 5 numeros "aleatorios" y calcular su promedio
// Resuelto en mi perfil   


