//Author Fernando Huilca
/*5.	Se requiere tener un programa que nos permita realizar la conversión de euros a dólares las veces que el usuario necesite. Es decir, el programa debería preguntarle al usuario cuando debe dejar de realizar los cálculos, también deberá preguntarle si quiere cambiar de euro a dólar o de dólar a euro, e imprimir el resultado.
*/
#include <iostream>
using namespace std;
int main()
{
    int ocupar = 1;
    double euros, dolares;

    while (ocupar == 1)
    {
        cout << "          CONVERSION DE DINERO " << endl; 
        cout << "1. Ocupara la calculadora de conversiones" << endl;
        cout << "0. Salir " << endl;
        cout << "Ingrese una opcion: "; 
        cin >> ocupar;
        

        switch (ocupar)
        {
        case 1:
            int direccion;
            cout << "__________Menu de opciones___________" << endl;
            cout << "1. Convertir de Euros a Dolares " << endl;
            cout << "0. Convertir de Dolares a Euros " << endl;
            cout << "Ingrese una opcion: ";
            cin >> direccion;
         

            switch (direccion)
            {
            case 1:
                cout << "Ingrese la cantidad de Euros: ";
                cin >> euros;
                dolares = euros * 1.07;
                cout << "Usted tiene " << dolares << " dolares americanos" << endl;
                cout << endl;
                break;

            case 0:
                cout << "Ingrese la cantidad de Dolares: ";
                cin >> dolares;
                euros = dolares * 0.93;
                cout << "Usted tiene " << euros << " euros. " << endl;
                cout << endl;
                break;
            default:
                cout << "Valor ingresado incorrecto" << endl;
                break;
            }
            break;

        case 0:
            break;

        default:
            cout << "Valor ingresado incorrecto" << endl;
            break;
        }



    }
    cout << endl;
    cout << "Vuelva pronto." << endl;

    return 0;
}