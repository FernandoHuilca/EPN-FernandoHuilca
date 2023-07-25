#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>
using namespace std;

int menu();

int main()
{
    ofstream escribir_archivo("sueldos.txt");
    if (!escribir_archivo)
    {
        cout << "No se pudo abrir el archivo sueldos.txt" << endl;
    }

    int opcion;
    double total_pagar = 0;

    do
    {
        string nombre;
        int horas_trabajadas;
        double precio_hora, sueldo_pagar;

        cin.ignore();

        cout << "Ingrese el nombre del trabajador: " << endl;
        getline(cin, nombre);

        cout << "Ingrese las horas trabajadas por " << nombre << ": " << endl;
        cin >> horas_trabajadas;

        cout << "Ingrese el precio cobrado por hora de " << nombre << ": " << endl;
        cin >> precio_hora;

        if (horas_trabajadas >= 0 && horas_trabajadas <= 40)
        {
            sueldo_pagar = horas_trabajadas * precio_hora;
            total_pagar += sueldo_pagar;
            cout << "El salario que se debe pagar a " << nombre << " es de " << sueldo_pagar << " dolares." << endl;
        }
        else if (horas_trabajadas > 40 && horas_trabajadas <= 50)
        {
            double extra = 1.50;
            sueldo_pagar = (horas_trabajadas * precio_hora) * extra;
            total_pagar += sueldo_pagar;
            cout << "El salario que se debe pagar a " << nombre << " es de " << sueldo_pagar << " dolares." << endl;
        }
        else
        {
            double extra = 2.0;
            sueldo_pagar = (horas_trabajadas * precio_hora) * extra;
            total_pagar += sueldo_pagar;
            cout << "El salario que se debe pagar a " << nombre << " es de " << sueldo_pagar << " dolares." << endl;
        }

        escribir_archivo << nombre << ", " << sueldo_pagar << endl;

        opcion = menu();

        switch (opcion)
        {
            case 1:
                break;
            case 2:
                cout << "El total a pagar es: " << total_pagar << " dolares." << endl;
                break;
            case 0:
                cout << "FIN DEL PROGRAMA." << endl;
                break;
            default:
                cout << "Fuera de los limites intente nuevamente." << endl;
                break;
        }

    } while (opcion != 0);

    escribir_archivo.close();

    return 0;
}

int menu()
{
    int opcion;
    cout << " _______________MENU_______________" << endl;
    cout << "| Seleccione la opcion que desee:  |" << endl;
    cout << "|__________________________________|" << endl;
    cout << "| 1) Calcular un nuevo sueldo      |" << endl;
    cout << "|----------------------------------|" << endl;
    cout << "| 2) Ver el total a pagar          |" << endl;
    cout << "|----------------------------------|" << endl;
    cout << "| 0) SALIR                         |" << endl;
    cout << "|__________________________________|" << endl;
    cin >> opcion;

    return opcion;
}





