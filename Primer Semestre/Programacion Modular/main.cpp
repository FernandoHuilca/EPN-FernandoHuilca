
#include "basicos.h"
#include <cstdlib> // Para la función system


//Prototipos 
//menu principal presenta los ejercicios
int menu();

int main()
{
    int opcion; 
    do
    {
        opcion = menu();

        switch (opcion)
        {
        case 1:
            system("cls");
            cout << "Codigo " << opcion << endl;
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