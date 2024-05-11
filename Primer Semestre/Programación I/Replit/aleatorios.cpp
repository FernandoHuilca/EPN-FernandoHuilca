// Tarea: generar 5 numeros "aleatorios" y calcular su promedio

#include <iostream>
using namespace std;
#include <random>
const int DIM = 5;

// Funcion que me calcula el promedio de un arrelgo numerico
double promedio(int numero[DIM]);
// Funcion que me genera numeros aleatorios
int aleatorios();

int main() {
  int array[DIM];
  for (int i = 0; i < DIM; i++) // Pa' guardar los numeros en el arreglo
  {
    array[i] = aleatorios();
    cout << array[i] << endl; // Ver los valores que se guardan :D
  }

  cout << "El promedio de los " << DIM
       << " numeros aleatorios es de: " << promedio(array) << endl;
}

double promedio(int numero[DIM]) {
  double promedio, suma = 0;
  for (int i = 0; i < DIM; i++) {
    suma += numero[i]; // suma= suma + numero[i]
  }
  promedio = suma / DIM;
  return promedio;
}

int aleatorios() {
  random_device rd;  // Semilla del dispositivo
  mt19937 gen(rd()); // Inicializar semilla aleatoria
  int min = 1;
  int max = 100; // Rangos
  uniform_int_distribution<int> distribution(min, max);
  return distribution(gen);
}
