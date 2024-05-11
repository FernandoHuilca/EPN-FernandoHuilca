//Author Fernando Huilca
//Programa que funciona como calculadora

#include <iostream>
using namespace std;
int main()
{
    int opcion = -1;
    double a, b;
    cout << "                   MI SUPER CALCULADORA :) " << endl;
    while (opcion < 0 || opcion >4)
    {

        cout << "Seleccione la operacion que desea realizar: " << endl;
        cout << "1. Suma" << endl;
        cout << "2. Resta" << endl;
        cout << "3. Multiplicacion" << endl;
        cout << "4. Division" << endl;
        cout << "0. Salir." << endl;

        cout << "Seleccione una operacion: " << endl;
        cin >> opcion;
    }
    if (opcion == 0)
    {
        cout << "FIN DEL PROGRAMA";
    }
    else 
    {
        if (opcion < 0 || opcion >4)
        {
            cout << "Opcion no valida, intente con otro valor " << endl;
        }

        cout << "Ingrese el primer operando: " << endl;
        cin >> a;
        cout << "Ingrese el segundo operando: " << endl;
        cin >> b;
        switch (opcion)
        {
        case 1:
        {
            cout << "La suma es: " << a + b << endl;
        }
        break;
        case 2:
        {
            cout << "La resta es: " << a - b << endl;
        }
        break;
        case 3:
        {
            cout << "La multiplicacion es: " << a * b << endl;
        }
        break;
        case 4:
        {
            if (b == 0)
            {
                cout << "La division para cero no esta definida" << endl;
            }
            else
            {
                cout << "La division es: " << a / b << endl;
            }

        }
        break;
       
        //No es necesario en defaul porque está el while
    }
   

    }





    return 0;
}