/* switch.cpp : Este archivo contiene la funcion main
Muy bueno 5
Bueno 4
Normal 3
Malo 2
Muy malo 1
 */


#include <iostream> 
using namespace std;
int main()
{
    int nota = 0;
    cout << "Ingrese la calificacion del producto: " << endl;
    cin >> nota;
    // AQUI APARECE LA OPCION DEL SWITCH
    switch (nota)
    {
    case 5:
    {
        cout << "Muy bueno. " << endl;
    }
    break; // PARA ESCAPARNOS DE LOS BUCLES 

    case 4:
    {
        cout << "Bueno. " << endl;
    }
    // break;  

    case 3:
    {
        cout << "Regular. " << endl;
    }
    //break;

    case 2:
    {
        cout << "Malo. " << endl;
    }
    //break; 

    case 1:
    {
        cout << "Muy malo. " << endl;
    }
    //break;

    default:
    {
        cout << "Valor fuera del rango " << endl;
    }

    }


    return 0;
}