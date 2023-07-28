//Author Fernando Huilca 

#include <iostream>
#include <string> 
using namespace std;
//Prototipos despues de la llamada de funciones
void saludar();
int menu();
double suma(double op1, double op2);
double resta(double op1, double op2);
double multiplicacion(double op1, double op2);
double division(double op1, double op2);

int main()
{
    saludar();
    cout << " *****Calculadora*****" << endl;
    double op1, op2; 
    int opcion;
    cout << "Ingrese operando1: ";
    cin >> op1;
    cout << "Ingrese operando2: ";
    cin >> op2;
    opcion = menu();
    switch (opcion)
    {
    case 1: 
    {
    cout << "La suma es: " << suma(op1, op2) << endl;
    }
    break;
    case 2:
    {
        cout << "La resta es: " << resta(op1, op2) << endl;
    }
    break;
    case 3:
    {
        cout << "La multiplicacion es: " << multiplicacion(op1, op2) << endl;
    }
    break;
    case 4:
    {
        if (op2 == 0)
        {
            cout << "No se puede realizar la division" << endl;
        }
        else
        {
            cout << "La division es: " << division(op1, op2) << endl;
        }
       
    }
    break;
    case 0:
    {
        cout << "Vuelva pronto " << endl;
    }
    break;
    default:
        cout << "Error datos ingresados" << endl;
        break;
    }

    


    return 0;
}
void saludar()// Indica que no devuelve nada la trafduccion es vacio 
{
    cout << " *****Saludos*****" << endl;
    string nombre = "", apellido;
    while (nombre != "0")
    {
        cout << "Ingrese su nombre: (0 para finalizar )" << endl; // cero funciona como un sentinela 
        cin >> nombre;
        if (nombre == "0")
        {
            break;
        }
        else
        {
        cout << "Ingrese su apellido: " << endl;
        cin >> apellido;
        cout << "Hola " << nombre << " " << apellido << endl;
        }

    }






}
//Aquí entra las funciones que se operan
double suma(double op1, double op2) {
    double total; 
    total = op1 + op2;
    return total;
}
double resta(double op1, double op2) {
    double total;
    total = op1 - op2;
    return total;
}
double multiplicacion(double op1, double op2) {
    return op1 * op2;
}
double division(double op1, double op2) {
    return op1 / op2;
}
// Funcion del menu 
int menu() {
    cout << "                   MI SUPER CALCULADORA :) " << endl;
    int opcion = -1;
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
        return opcion;
    }
}