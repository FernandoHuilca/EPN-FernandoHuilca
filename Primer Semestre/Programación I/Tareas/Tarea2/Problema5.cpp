//Author Fernando Huilca 
/*5.	Escribir un programa que calcule el costo de una llamada telefónica, el costo de la llamada es de 60 centavos el minuto. Utilice la biblioteca time. El tiempo de la llamada se tomará del tiempo de ejecución desde que inicia la llamada, el usuario verá el siguiente texto:
Iniciar llamada: S
Finalizar llamada: S
El costo de la llamada es: 0.05 centavos
*/
#include <iostream> 
#include <ctime> 
using namespace std; 

int main ()
{
    char inicio;
    char fin;
    cout << "Iniciar llamada: ";
    cin >> inicio;

    if (inicio == 'S' || inicio == 's') {
        time_t startTime = time(nullptr); // Capturar el tiempo de la pc

        cout << "Finalizar llamada: ";
        cin >> fin;

        if (fin == 'S' || fin == 's') {
            time_t endTime = time(nullptr); 

            double duracion = difftime(endTime, startTime);
            double costo = duracion * 0.6; 

            cout << "El costo de la llamada es: " << costo / 100.0 << " centavos" << endl;
        }
        else {
            cout << "La llamada no finalizo." << endl;
        }
    }
    else {
        cout << "La llamada no inicio." << endl;
    }


    return 0;
}