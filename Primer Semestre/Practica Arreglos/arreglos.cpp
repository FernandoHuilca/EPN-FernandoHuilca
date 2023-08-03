// Author Fernando Huilca 
//  Programa dedicado a resolver 4 diferentes ejercicios usando Arreglos
#include <iostream> 
using namespace std;

// Prototipos de Funciones
int menu();
void saludo_Ejercicio();


int opcion = 1;// Preguntar al profe como arreglar esto

int main() {
    cout << "_______BIENVENIDO A LOS EJERCICIOS DE FUNCIONES______" << endl;
    cout << "                             ~ AUTHOR Fernando Huilca" << endl;
    cout << endl;
    while (opcion != 0) // Para presentar el menu varias veces
    {
        opcion = menu(); // Se muestra el menu con las opciones de cada ejercicio
        cout << endl;    // Salto de linea para mas elegancia jeje
        switch (opcion) {
        case 1:
            saludo_Ejercicio();
        
            break;
        case 2:
            saludo_Ejercicio();
        
            break;
        case 3:
            saludo_Ejercicio();
        
            break;
        case 4:
            saludo_Ejercicio();
        
            break;
        case 5:
            saludo_Ejercicio();
         
            break;
        case 6:
            saludo_Ejercicio();
      
            break;
        }
    }
    cout << "Adios. " << endl;
    return 0;
}

// FUNCIONES DEL PROGRAMA
int menu() {
    int opcion;
    do {
        cout << " ____MENU EJERCICIOS REALIZADOS____" << endl;
        cout << "|                                  |" << endl;
        cout << "|Seleccione el ejercicio que desee:|" << endl;
        cout << "|__________________________________|" << endl;
        cout << "|      Ejercicios        | Numero  |" << endl;
        cout << "|------------------------|---------|" << endl;
        cout << "| 1) Funcion Exponencial |    1    |" << endl;
        cout << "| 2) Funcion Segundo mas |    2    |" << endl;
        cout << "| 3) Tiempo en segundos  |    3    |" << endl;
        cout << "| 4) Mes por dia         |    4    |" << endl;
        cout << "| 5) Minutos en un CD    |    5    |" << endl;
        cout << "| 6) Directorio Telefono |    6    |" << endl;
        cout << "|__________________________________|" << endl;
        cout << "| 0) SALIR                    0    |" << endl;
        cout << "|__________________________________|" << endl;
        cin >> opcion;
        if (opcion < 0 || opcion > 6) {
            cout << "Opcion seleccionada INCORRECTA." << endl;
            cout << "Por favor, digite un numero entero del 0 al 6" << endl;
        }
    } while (opcion < 0 || opcion > 6);
    return (opcion);
}
void saludo_Ejercicio() {
    cout << "Bienvenido al Ejercicio " << opcion << endl;
    cout << "Autor Fernando Huilca. " << endl;
    cout << "Autor Mateo Quisilema. " << endl;
    cout << endl;
}