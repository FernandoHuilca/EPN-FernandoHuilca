/*20 puntos) Adivinar. Escriba un programa que desarrolle un juego de adivinar un número en el que la computadora selecciona un número aleatorio en el intervalo de 0 a 10 y el usuario tiene hasta 3 intentos para adivinar. Al final de cada juego, se debe decir al usuario si gana o pierde y luego preguntarle si quiere jugar otra vez. Cuando el usuario termina, el programa debe producir el número total de juegos ganados y perdidos. Para generar los números aleatorios puede usar la función definida abajo. Antes de codificar el programa, ejecute varias veces el código inicial de abajo para que comprenda la función mencionada.*/
// Author Fernando Huilca
#include <iostream>
using namespace std;
#include <cstdlib> // srand() y rand()
#include <ctime> // time()
int genera_aleatorios();
int main()
{
    cout << "______JUEGO DE ADIVINAR :D______" << endl;

    char opcion;
    int juegos_ganados = 0;
    int juegos_perdidos = 0;

    do
    {
        int correcto = genera_aleatorios(); // utilizo el numero aleatorio "invoco la funcio"

        for (int i = 1; i <= 3; i++)
        {
            int numusuario;
            cout << "Escriba el numero que cree correcto del 1 al 10: ";
            cin >> numusuario;

            if (numusuario == correcto)
            {
                cout << "Felicidades GANASTE!" << endl;
                juegos_ganados++;
                break;
            }
            else
            {
                cout << "Lo siento, el numero ingresado no es el correcto." << endl;
                if (i == 3)
                {
                    cout << "Se te acabaron los intentos. El numero correcto era: " << correcto << endl;
                    juegos_perdidos++;
                }
            }
        }

        cout << "Desea seguir jugando? (Y/N): " << endl;
        cin >> opcion;
    } while (opcion == 'Y' || opcion == 'y');

    cout << "El juego ha terminado." << endl;
    cout << "Total de juegos ganados: " << juegos_ganados << endl;
    cout << "Total de juegos perdidos: " << juegos_perdidos << endl;

    return 0;
}

// Declaro la funcion para el numero aleatorio
int genera_aleatorios()
{
    int num_aleatorio;
    srand(time(NULL));
    num_aleatorio = 1 + rand() % 10;
    return num_aleatorio;
}





