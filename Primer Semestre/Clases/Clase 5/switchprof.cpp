//Author Fernando Huilca 
// seleccion .cpp : Este archivo contiene la funcion main la ejecución del programa 

// nota== 10 Matricula de honor MH
// si la nota es mayor a 9 es sobresaliente SS
// si la nota es mayor a 7 es notable NT
// si la nota es mayor a 5 es aprovado AP
// si la nota es menor a 5 es suspenso SS

#include <iostream> 
using namespace std;
int main ()
{
    int nota = 0;
    cout << "Ingrese su nota: " << endl;
    cin >> nota;
    switch (nota)
    {
    case 10:
        {
            cout << "MH" << endl;
        }
        case 9:
        {
            cout << "SS" << endl;
        }
        case 8:
        case 7:
        {
            cout << "NT" << endl;
        }
         break;
        case 6:
        case 5:
        {
            cout << "AP" << endl;
        }
         break;
        case 4:
        case 3:
        case 2:
        case 1:
        case 0:
        {
            cout << "SS" << endl;
        }
         break;
    default: 
    {
        cout << "Valor fuera del rango" << endl; 
    }
        break;
    }

return 0;
}