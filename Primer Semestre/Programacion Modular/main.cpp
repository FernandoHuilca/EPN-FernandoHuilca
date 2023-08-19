#include<iostream>
using namespace std; 
#include "basicos.h"
#include <cstdlib> // Para la función system


//Prototipos 
//menu principal presenta los ejercicios
int menu();
int menu_1(); //Para ejercicio uno basicos

int main()
{
    int opcion, opcion_basico;
    double a, b; 
    do
    {
        opcion = menu();

        switch (opcion)
        {
        case 1:
            do {
                opcion_basico = menu_1();
                if (opcion_basico != 0)
                {
                    cout << "Ingrese el primer valor: " << endl;
                    cin >> a;
                    cout << "Ingrese el segundo valor: " << endl;
                    cin >> b;
                    switch (opcion_basico)
                    {
                    case 1:
                        cout << "El resultado de la suma es: " << suma(a, b) << endl;
                        break;
                    case 2:
                        cout << "El resultado de la resta es: " << resta(a, b) << endl;
                        break;
                    case 3:
                        cout << "El resultado de la multiplicacion es: " << multiplicacion(a, b) << endl;
                        break;
                    case 4:
                        cout << "El resultado de la division es: " << division(a, b) << endl;
                        break;
                    }
                }
                
            } while (opcion_basico != 0);
            break;
        case 2:
            system("cls");
            cout << "Codigo " << opcion << endl;
            break;
        case 3:
            system("cls");
            cout << "Codigo " << opcion << endl;
            break;
        case 4:
            system("cls");
            cout << "Codigo " << opcion << endl;
            break;
        }
    
    } while (opcion != 4);

    // Limpia la terminal en Window
    cout << "Adios" << endl;


    return 0;
}



int menu()
{
    int opcion;
    do
    {
        cout << "          Super Calculadora     " << endl;
        cout << "1. Operaciones Básicas " << endl;
        cout << "2. Operaciones avanzadas " << endl;
        cout << "3. Conversion de medidas " << endl;
        cout << "4. Salir " << endl;
        cout << "----------------------------------" << endl;
        cout << "Opcion: ";
        cin >> opcion;
        cout << endl;
        if (opcion < 1 || opcion > 4)
        {
            cout << "Valor ingresado fuera de los limites. " << endl;
            cout << "Ingrese un numero del 1 al 4 por favor. " << endl;
        }
    } while (opcion < 1 || opcion > 4);

    return opcion;
}



int menu_1()
{

    int opcion;
    do
    {
    cout << "Seleccione la operacion que desea realizar: " << endl;
    cout << "1. Suma " << endl;
    cout << "2. Resta" << endl;
    cout << "3. Multiplicacion" << endl;
    cout << "4. Division " << endl;
    cout << "0. Salir " << endl;
    cout << "----------------------------------" << endl;
    cout << "Opcion: ";
    cin >> opcion;
    if (opcion < 0 || opcion > 4)
    {
        cout << "Valor ingresado fuera de los limites. " << endl;
        cout << "Ingrese un numero del 0 al 4 por favor. " << endl;
    }
    } while (opcion < 0 || opcion > 4);

    return opcion;
}