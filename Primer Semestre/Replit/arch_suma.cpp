// Leer los 30 valores del archivo datos.txt guardarlos en un arreglo y calcular
// la suma;

#include <iostream>
using namespace std;
#include <fstream>
const int TAM = 30;
void leer(int arreglo[TAM]);
int suma(int arreglo[TAM]);

int main() {
  int datos[TAM];
  leer(datos);
  cout << "La suma de los valores es: " << suma(datos);
  // su código. ¿Qué  código?
}

// inicializa el arreglo
void leer(int arreglo[TAM]) {
  ifstream archivo;
  archivo.open("datos.txt");
  if (!archivo.is_open()) {
    cout << "No se pudo abrir el archivo" << endl;
  } else {
    for (int i = 0; i < TAM; i++) {
      int numero;
      archivo >> numero;
      arreglo[i] = numero;
    }
    archivo.close(); // Siempre es bueno cerrar lo abierto
  }
}

// calcular la suma
int suma(int arreglo[TAM]) {
  int suma = 0;
  for (int i = 0; i < TAM; i++) {
    suma = suma + arreglo[i]; // suma += arreglo [i]
  }
  return suma;
}