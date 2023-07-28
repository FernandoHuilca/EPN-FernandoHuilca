/* Para evitarnos tanta anidacion con el if y el else se puede hacer el else if */

#include <iostream> 
using namespace std;
int main ()
{
    int nota = 0;
    cout << "Ingrese su nota: " << endl;
    cin >> nota;
    if (nota >= 9)
    {
        cout << "SOBRESALIENTE" << endl;

    } 
    else if (nota >= 7) 
        {
            cout << "NOTABLE " << endl;

        }
        else if (nota >= 5)
            {
                cout << "APROVADO" << endl;

            }
            else 
            cout << "SUSPENDIDO" << endl;
        


    return 0;
}