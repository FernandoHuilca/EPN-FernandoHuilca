//Author Fernando Huilca 
// Programa dedicado a resolver 6 diferentes ejercicios 
#include <iostream> 
using namespace std; 
#include <fstream> 
#include <iomanip>
//Prototipos de Funciones  
int menu ();


int main ()
{
    cout << "_______BIENVENIDO A LOS EJERCICIOS DE FUNCIONES______" << endl; 
    cout << "                             ~ AUTHOR FERNANDO HUILCA" << endl;
    cout << endl; 
    menu(); // Se muestra el menu con las opciones de ejercicios




 }

 int menu ()
 {
    int opcion; 
    do 
    {
    cout << " ____MENU EJERCICIOS REALIZADOS____" << endl;
    cout << "|                                  |" << endl;
    cout << "|Seleccione el ejercicio que desee:|" << endl;
    cout << "|__________________________________|" << endl;
    cout << "|      Ejercicios        | Numero  |" << endl;
    cout << "|------------------------|---------|" << endl;
    cout << "| 1) Funcion Exponencial |    1    |" << endl;
    cout << "| 2) Ejercicio           |    2    |" << endl;
    cout << "| 3) Ejercicio           |    3    |" << endl;
    cout << "| 4) Ejercicio           |    4    |" << endl;
    cout << "| 5) Ejercicio           |    5    |" << endl;
    cout << "| 6) Ejercicio           |    6    |" << endl;
    cout << "|__________________________________|" << endl;
    cout << "| 0) SALIR                    0    |" << endl;
    cout << "|__________________________________|" << endl;
    cin >> opcion;
        if (opcion < 0 || opcion > 6)
        {
            cout << "Opcion seleccionada INCORRECTA." << endl; 
            cout << "Por favor, digite un numero entero del 0 al 6" << endl;
        }
    }
    while (opcion < 0 || opcion > 6); 
    return opcion; 
 }