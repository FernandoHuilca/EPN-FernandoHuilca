//Author Fernando Huilca 
// seleccion .cpp : Este archivo contiene la funcion main la ejecución del programa 

// nota== 10 Matricula de honor MH
// si la nota es mayor a 9 es sobresaliente SS
// si la nota es mayor a 7 es notable NT
// si la nota es mayor a 5 es aprovado AP
// si la nota es menor a 5 es suspenso SS

#include <iostream> 
using namespace std;
main ()
{
    int nota = 0;
    cout << "Ingrese su nota: " << endl;
    cin >> nota;
    if (nota > 9)
    {
        cout << "SOBRESALIENTE" << endl;

    } 
    else 
        if (nota > 7) 
        {
            cout << "NOTABLE " << endl;

        }
        else 
        {
            if (nota > 5)
            {
                cout << "APROVADO" << endl;

            }
            else 
            cout << "SUSPENDIDO" << endl;
        }


    return 0;
}