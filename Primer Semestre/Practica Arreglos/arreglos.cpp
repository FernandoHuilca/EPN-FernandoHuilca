// Author Fernando Huilca 
//  Programa dedicado a resolver 4 diferentes ejercicios usando Arreglos
#include <iostream> 
using namespace std;
#include <string> 
#include <iomanip> 
#include <random> //para ejercicio 4

int const DIM_4 = 11;

// Prototipos de Funciones
int menu();
//Generalmente se va a usar para imprimir en consola:
void imprimir(int array[DIM_4]);


void saludo_Ejercicio(int opcion);
void ejercicio_4();
int aleatorios(); // para ejercicio 4 




int main() {
    cout << "       BIENVENIDO A LOS EJERCICIOS DE FUNCIONES      " << endl;
    cout << setw(54) << right << "~ AUTHOR Fernando Huilca" << endl;
    cout << endl;
    int opcion = 1;
    while (opcion != 0) // Para presentar el menu varias veces
    {
        opcion = menu(); // Se muestra el menu con las opciones de cada ejercicio
        cout << endl;    // Salto de linea para mejor visualizacion
        switch (opcion) {
        case 1:
            saludo_Ejercicio(opcion);

            break;
        case 2:
            saludo_Ejercicio(opcion);

            break;
        case 3:
            saludo_Ejercicio(opcion);

            break;
        case 4:
            saludo_Ejercicio(opcion);
            ejercicio_4();

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
        cout << setw(41) << right << "MENU EJERCICIOS REALIZADOS" << endl;
        cout << setw(40) << right << "-------------------------" << endl;
        cout << endl;
        cout << "1. Funcion Exponencial" << endl;
        cout << "2. Funcion Segundo mas" << endl;
        cout << "3. Tiempo en segundos" << endl;
        cout << "4. Dados" << endl;
        cout << "0. Salir" << endl;
        cout << endl;
        cout << "Ingrese una opcion: ";

        cin >> opcion;
        if (opcion < 0 || opcion > 4) {
            cout << "Opcion seleccionada INCORRECTA." << endl;
            cout << "Por favor, digite un numero entero del 0 al 4" << endl;
        }
    } while (opcion < 0 || opcion > 4);
    return (opcion);
}
void saludo_Ejercicio(int opcion) {
    cout << "Bienvenido al ejericio " << opcion << endl;
    cout << "~ Autor Fernando Huilca. " << endl;
    cout << endl;
}

void ejercicio_4()
{
    /*4.	Dados. Escriba un programa para simular el tiro de dos dados. Después debe calcularse la suma de los dos valores. [Nota: cada dado puede
     mostrar un valor entero del 1 al 6, por lo que la suma de los valores variará del 2 al 12, siendo 7 la suma más frecuente, mientras que 2 y 12
     serán las sumas menos frecuentes]. En la figura 1, se muestran las 36 posibles combinaciones de los dos dados. Su programa debe tirar los dados
     36 000 veces. Utilice un arreglo unidimensional para registrar el número de veces que aparezca cada una de las posibles sumas. Imprima los
     resultados en formato tabular. Determine además si los totales son razonables (es decir, hay seis formas de tirar un 7, por lo que
     aproximadamente una sexta parte de los tiros deben ser 7).*/
    int limite = 36000, suma;
    int frecuencia[DIM_4] = { 0 };

    for (int i = 0; i < limite; i++)
    {
        int dado1 = aleatorios();
        int dado2 = aleatorios();
        int suma = dado1 + dado2;
        frecuencia[suma - 2] += 1; // frecuencia [suma - 2] = frecuencia [suma - 2] + 1, 
    }

    cout << " -----------------------------" << endl; 
    cout << "|    Suma    |  Frecuencia    |" << endl;
    for (int i = 0; i < DIM_4; i++)
    {
        cout << "|      " << setw(6) << left << i + 2 << "|     " << setw(11) << left << frecuencia[i] << "|" <<  endl;
    }
    cout << " -----------------------------" << endl;
    cout << endl; // para mejor visualizacion 
}
int aleatorios() {
    random_device rd;  // Semilla del dispositivo
    mt19937 gen(rd()); // Inicializar semilla aleatoria
    int min = 1;
    int max = 6; // Rangos
    uniform_int_distribution<int> distribution(min, max);
    return distribution(gen);
}
void imprimir(int array[DIM_4])
{
    for (int i = 0; i < DIM_4; i++)
    {
        cout << array[i] << endl;
    }
}