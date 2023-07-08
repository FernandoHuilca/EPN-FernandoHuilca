//Author Fernando Huilca 
/*2. Escriba un programa que genere un archivo output.txt en el que aparezcan invertidos los números enteros estrictamente positivos (>0) que haya en otro archivo input.txt. Cada línea de input.txt contendrá un número entero y terminará en una línea con un 0 (centinela). El archivo input.txt lo deben generar previamente.*/
#include <iostream> 
using namespace std;
#include <fstream> //Para USAR carpetas 

int main()
{
    int numero1, numero2, numero3, numero4, inverso;
    ifstream archivoL; //Uso esta variable para leer de otra carpeta 
    archivoL.open("input.txt");
    if (!archivoL.is_open())
    {
        cout << "Archivo no abierto" << endl;
    }
    else
    {
        archivoL >> numero1 >> numero2 >> numero3;

        while (numero1 > 0)
        {
            inverso = numero1 % 10;
            numero1 = numero1 / 10;
            cout << inverso;

        }
    }   
}