#include<iostream>
using namespace std; 
#include "basicos.h"
#include "avanzados.h"
#include "conversiones.h"
#include <cstdlib> // Para la función system
#include <Windows.h>
#define color SetConsoleTextAttribute
HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);





//Prototipos 
//menu principal presenta los ejercicios
int menu();
//Para ejercicio uno basicos
int sub_menu_1(); 
//Para ejercicio Avanzados
int sub_menu_2(); 
//Submenu para ejercicio de conversiones
int sub_menu_3();


/*********************************************** INICIO DEL MAIN *******************************************************************/
int main()
{
    
    
    int opcion, opcion_submenu;
    double a, b; 
    do
    {
        opcion = menu();

        switch (opcion)
        {
        /******************************************************************************************************************/
        case 1:
            system("cls");
            do {
                opcion_submenu = sub_menu_1();

                if (opcion_submenu != 0)
                {
                    cout << "Ingrese el primer valor: ";
                    cin >> a;
                    cout << "Ingrese el segundo valor: ";
                    cin >> b;
                    system("cls");
                    switch (opcion_submenu)
                    {
                    case 1:
                        color(hConsole, 11);
                        cout << "El resultado de la suma es: " << suma(a, b) << endl;
                        color(hConsole, 7);
                        cout << endl;
                        break;
                    case 2:
                        color(hConsole, 11);
                        cout << "El resultado de la resta es: " << resta(a, b) << endl;
                        color(hConsole, 7);
                        cout << endl;
                        break;
                    case 3:
                        color(hConsole, 11);
                        cout << "El resultado de la multiplicacion es: " << multiplicacion(a, b) << endl;
                        color(hConsole, 7);
                        cout << endl;
                        break;
                    case 4:
                        if (division(a, b) == 0)
                        {
                            color(hConsole, 4);
                            cout << "No existe division para cero" << endl;
                            cout << endl;
                            color(hConsole, 7);
                        }
                        else
                        {
                            color(hConsole, 11);
                            cout << "El resultado de la division es: " << division(a, b) << endl;
                            color(hConsole, 7);
                            cout << endl;
                        }

                        break;
                    }
                }

            } while (opcion_submenu != 0);
            system("cls");
            break;
            /******************************************************************************************************************/
        case 2:
            system("cls");
            do {
                opcion_submenu = sub_menu_2();

                if (opcion_submenu != 0)
                    system("cls");
                {
                    switch (opcion_submenu)
                    {
                    case 1:
                        color(hConsole, 11);
                        potencia();
                        color(hConsole, 7);
                        cout << endl;
                        break;
                    case 2:
                        color(hConsole, 11);
                        raiz_cuadrada();
                        color(hConsole, 7);
                        cout << endl;
                        break;
                    case 3:
                        color(hConsole, 11);
                        factorial();
                        color(hConsole, 7);
                        cout << endl;
                        break;
                    case 4:
                        color(hConsole, 11);
                        fibonacci();
                        color(hConsole, 7);
                        cout << endl;

                        break;
                    }
                }

            } while (opcion_submenu != 0);
            system("cls");
            break;
            /******************************************************************************************************************/
        case 3:
            system("cls");
            opcion_submenu = sub_menu_3();
            switch (opcion_submenu)
            {
            case 1: 
                centigrados_Kelvin();
                break;
            case 2:
                libras_gramos();
                break;
            case 3:
                pulgadas_centimetros();

                break;
            case 4:
                kilometros_millas();
                break;
            case 5:

                litros_galones();
                break;
            }
            
            break;
            
        }
    
    } while (opcion != 0);
    cout << "Adios" << endl;


    return 0;
}
/***************************************************** FINAL DEL MAIN *************************************************************/



int menu()
{
    int opcion;
    do
    {
        cout << "          Super Calculadora     " << endl;
        cout << "1. Operaciones Basicas " << endl;
        cout << "2. Operaciones avanzadas " << endl;
        cout << "3. Conversion de medidas " << endl;
        cout << "0. Salir " << endl;
        cout << "----------------------------------" << endl;
        cout << "Opcion: ";
        cin >> opcion;
        cout << endl;
        if (opcion < 0 || opcion > 3)
        {
            system("cls");
            color(hConsole, 4);
            cout << "Valor ingresado fuera de los limites. " << endl;
            cout << "Ingrese un numero del 0 al 3 por favor. " << endl;
            color(hConsole, 7);
        }
    } while (opcion < 0 || opcion > 3);

    return opcion;
}



int sub_menu_1()
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
        system("cls");
        color(hConsole, 4);
        cout << "Valor ingresado fuera de los limites. " << endl;
        cout << "Ingrese un numero del 0 al 4 por favor. " << endl;
        color(hConsole, 7);
        cout << endl;
    }
    } while (opcion < 0 || opcion > 4);

    return opcion;
}


int sub_menu_2()
{

    int opcion;
    do
    {
        cout << "Seleccione la operacion que desea realizar: " << endl;
        cout << "1. Potencia " << endl;
        cout << "2. Raiz Cuadrada" << endl;
        cout << "3. Factorial" << endl;
        cout << "4. Fibonacci" << endl;
        cout << "0. Salir " << endl;
        cout << "----------------------------------" << endl;
        cout << "Opcion: ";
        cin >> opcion;
        if (opcion < 0 || opcion > 4)
        {
            system("cls");
            color(hConsole, 4);
            cout << "Valor ingresado fuera de los limites. " << endl;
            cout << "Ingrese un numero del 0 al 4 por favor. " << endl;
            color(hConsole, 7);
            cout << endl;
        }
    } while (opcion < 0 || opcion > 4);

    return opcion;
}


int sub_menu_3()
{
    int opcion;
    do
    {
        cout << "Elije una conversion de unidades:" << endl;
        cout << "1. Centigrados a Kelvin" << endl;
        cout << "2. Libras a Gramos" << endl;
        cout << "3. Pulgadas a Centimetros" << endl;
        cout << "4. Kilometros a Millas" << endl;
        cout << "5. Litros a Galones" << endl;
        cout << "----------------------------------" << endl;
        cout << "Ingresa el numero de la opcion: ";
        cin >> opcion;
        if (opcion < 1 || opcion > 5)
        {
            system("cls");
            color(hConsole, 4);
            cout << "Valor ingresado fuera de los limites. " << endl;
            color(hConsole, 7);
            cout << endl;
        }
    } while (opcion < 1 || opcion > 5);

    return opcion;
}