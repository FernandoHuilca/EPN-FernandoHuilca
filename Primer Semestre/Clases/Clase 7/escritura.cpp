// Author Fernando Huilca 

#include <iostream> 
#include <string>
using namespace std;
#include <fstream> 

int main()
{
    string nombre, cedula; 
    int edad, semestre; 
    ofstream archivo; 

    archivo.open("estudiante.txt"); // creacion del archivo o apertura  
    cout << "Ingrese los datos del estudiante: " << endl;
    cout << "Nombre: " << endl; 
    cin >> nombre; 
    cout << "Cedula: "; 
    cin >> cedula; 
    cout <<"edad: " << endl;
    cin >> edad ; 
    cout << "Semestre: " << endl;
    cin >> semestre; 
    // Escribimos los datos en el archivo uno por linea 
    archivo << cedula << endl;
    archivo << nombre << endl; 
    archivo << edad << endl;
    archivo << semestre << endl; 
    // Se puede escribir en una sola linea como en el cout 
    // archivo << cedula << endl << nombre << endl << edad

  return 0;
}
// HACER QUE PUEDA PONER EL NOMBRE COMPLETO Y NO SE PRESENTE ERRORES 