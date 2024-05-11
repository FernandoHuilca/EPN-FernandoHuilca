// Author : Fernando Huilca
#include <iostream>
#include <iomanip>
using namespace std; 


int main()
{
    string nombre;
    while (true)
    {
        cout << "Escriba su nombre: \n";
        cin >> nombre;

        cout << "Bienvenido " + nombre + " un placer tenerlo de vuelta." << endl;
    }
    
}
