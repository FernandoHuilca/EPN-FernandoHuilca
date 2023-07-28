#include <iostream> 
using namespace std;
int menu();
void ejercicio1();
void ejercicio2();
void ejercicio3();
void ejercicio4();
//Prototipo ej1 
int func_ej1_1();

int main()
{

    int op = -1;
    while (op != 0)
    {
        op = menu();
        switch (op)
        {
        case 1:
            ejercicio1();
            break;
        case 2:
            ejercicio2();
            break;
        case 3:
            ejercicio3();
            break;
        case 4:
            ejercicio4();
            break;
        case 0:
            cout << "SALISTE DEL PRORGAMA" << endl;
            break;

        }
    }



    return 0;
}

int menu()
{
    int opcion=-1;
    while (opcion < 0 || opcion > 4)
    {
        cout << "1. Ejercicio1" << endl;
        cout << "2. Ejercicio2" << endl;
        cout << "3. Ejercicio3" << endl;
        cout << "4. Ejercicio4" << endl;
        cout << "0. SALIR" << endl;
        cout << "Seleccione la opcion que desea" << endl; 
        cin >> opcion;
        if (opcion < 0 || opcion > 4)
        {
            cout << "Opcion no valida" << endl;
        }

    }
    return opcion;

}
void ejercicio1()
{
    cout << "INICIO DEL EJERCICIO1 " << endl;
    // Codigo que resuelva el ejercicio1 
}
int func_ej1_1()
{
    return 0;
}
void ejercicio2()
{
    cout << "INICIO DEL EJERCICIO2 " << endl;
    // Codigo que resuelva el ejercicio2 
}
void ejercicio3()
{
    cout << "INICIO DEL EJERCICIO3 " << endl;
    // Codigo que resuelva el ejercicio3 
}
void ejercicio4()
{
    cout << "INICIO DEL EJERCICIO4 " << endl;
    // Codigo que resuelva el ejercicio4 
}