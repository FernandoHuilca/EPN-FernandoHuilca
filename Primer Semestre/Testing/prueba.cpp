//Escriba un programa que pregunte al usuario un numero entero y positivo n y sumar los numeros desde 1 hasta n (use while y for )
#include <iostream>
using namespace std; 
#include <fstream> 
void promedio (ifstream &archivo, double &promedio);

int main ()
{
ifstream archivo; 
double promedioF; 
archivo.open("datos.txt"); 
if (!archivo.is_open())
{
    cout << "El archivo no se pudo abrir " << endl ;
}
else 
{
    promedio (archivo, promedioF); 
    cout << "El promedio de los datos del archivo es de: " << promedioF << endl;
    archivo.close(); 

}

}
void promedio (ifstream &archivo, double &promedio)
{
    double dato, suma = 0; 
    int contador=0; 
    archivo >> dato;  
    while (dato != -1 )
    {
        contador = contador + 1; 
        cout << "El contador es: " << contador; 
        suma =  suma + dato; 
        archivo >> dato; 
    }
    promedio = suma / contador; 

}

