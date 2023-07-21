//Escriba un programa que pregunte al usuario un numero entero y positivo n y sumar los numeros desde 1 hasta n (use while y for )
#include <iostream>
using namespace std; 
#include <fstream> 
// Funcion que suma los numeros del archivo 
void sumatorio (ifstream &archivo, double &suma); 

int main ()
{
    double resultado ; 
    ifstream archivo; 
    archivo.open("datos.txt"); 
    if (!archivo.is_open())
    {
        cout << "Archivo no abierto. " << endl; 
    } 
    else 
    {
        sumatorio(archivo, resultado);
        cout << " El resultado de la suma de los valores es de: " << resultado << endl; 
        archivo.close(); 
    }

    return 0; 

}

void sumatorio (ifstream &archivo, double &suma)
{
    double dato; 
    archivo >> dato; 
    suma = 0 ; 
    while (dato !=-1)
    {
        suma = suma + dato; 
        archivo >> dato; 
    }
}