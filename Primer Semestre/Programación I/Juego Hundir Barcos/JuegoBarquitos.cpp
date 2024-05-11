#include <iostream>
using namespace std;
#include <chrono>
#include <thread>
#include <random>
#include <cstdlib> // Para la función system
#include <Windows.h>
#define color SetConsoleTextAttribute
HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);

//Constantes
const int DIM = 6;

//Prototipos 
// Funcion que realiza una carga en pantalla
void carga_pantalla();
//Funcion que devuelve un num aleatorio
int aleatorios();
//Funcion que imprime una matriz
void imprimir_Matriz(const bool array[DIM][DIM]);
//Funcion que me dice cuantas naves hay en el juego
int num_naves(const bool array[DIM][DIM]);
//Funcion que imprime el tablero de aciertos y fallos
void imprimir_tablero(const int array[DIM][DIM]);
//Imprime matriz de enteros 
void imprimir_Matriz(const int array[DIM][DIM]);



int main()
{
    bool naves[DIM][DIM];
    int figuras[DIM][DIM] = {};
    //imprimir_Matriz(figuras);
    for (int i = 0; i < DIM; i++)
    {
        for (int j = 0; j < DIM; j++)
        {
            naves[i][j] = aleatorios();
        }

    }

    /***********************Para saber donde estan las naves*******************************/
    //imprimir_Matriz(naves);
    //cout << "Numero de naves validas " << num_naves(naves) << endl;
    /*****************************************************************************************/

    //Seguimiento de cuantos aciertos tiene el jugador y cuantos turnos ha jugado
    int aciertos = 0;
    int NumeroDeTurnos = 0;
    int parar = num_naves(naves);
    carga_pantalla(); //Muestra la carga en pantalla (imnecesario pero queda bonito)
    system("cls");

    //Permitir al jugador seguir jugando hasta que destruya n naves
    while (aciertos < parar)
    {
        int fila, columna;
        cout << "____ Hundir la Flota ____" << endl << endl;
        //Preguntar al usuario por una fila
        cout << "Numero de fila entre 1 y " << DIM << ":  ";
        cin >> fila;
        fila--;
        //Preguntar al usuario por una columna
        cout << "Numero de columna entre 1 y " << DIM << ":  ";
        cin >> columna;
        columna--;
        system("cls");

        //Verificar si existe una nave en esas coordenadas
        if (naves[fila][columna]) {
            /* Si el jufgador acierta una nave,
            quitarla poniendo 0 en su posicion*/
            naves[fila][columna] = 0;
            //Incrementar el contador de aciertos
            aciertos++;
            //Avisar al usuario que acerto
            cout << "Le diste ..., " << (num_naves(naves))
                << " naves restantes" << endl << endl;
            figuras[fila][columna] = 1;
            imprimir_tablero(figuras);
            cout << endl;
            //imprimir_Matriz(naves); --> Para ver como va quedando la matriz


        }
        else {
            cout << "Fallaste!! :(" << endl << endl;
            figuras[fila][columna] = 2;
            imprimir_tablero(figuras);
            cout << endl;
        }
        //Contar cuantos turnos ha utilizado
        NumeroDeTurnos++;
    }
    system("cls");
    color(hConsole, 13);
    cout << endl;
    cout << "¡Victoria, has ganado! en "
        << NumeroDeTurnos << " turnos :)";
    color(hConsole, 7);

    return 0;
}


int aleatorios() {
    random_device rd;  // Semilla del dispositivo
    mt19937 gen(rd()); // Inicializar semilla aleatoria
    int min = 0;
    int max = 1; // Rangos
    uniform_int_distribution<int> distribution(min, max);
    return distribution(gen);
}


void imprimir_Matriz(const bool array[DIM][DIM])
{
    for (int i = 0; i < DIM; i++)
    {
        for (int j = 0; j < DIM; j++)
        {
            cout << array[i][j];
        }
        cout << endl;
    }
}
void imprimir_Matriz(const int array[DIM][DIM])
{
    for (int i = 0; i < DIM; i++)
    {
        for (int j = 0; j < DIM; j++)
        {
            cout << array[i][j];
        }
        cout << endl;
    }
}

int num_naves(const bool array[DIM][DIM])
{
    int naves_existentes = 0;
    for (int i = 0; i < DIM; i++)
    {
        for (int j = 0; j < DIM; j++)
        {
            if (array[i][j])
            {
                naves_existentes++;
            }
        }
    }
    return naves_existentes;
}


void imprimir_tablero(const int array[DIM][DIM])
{
    for (int i = 0; i < DIM; i++)
    {
        for (int j = 0; j < DIM; j++)
        {
            if (array[i][j] == 0)
            {
                color(hConsole, 11);
                cout << "[ ? ]";
                color(hConsole, 7);
            }
            else if (array[i][j] == 1)
            {
                color(hConsole, 2);
                cout << "[ Y ]";
                color(hConsole, 7);
            }
            else
            {
                color(hConsole, 4);
                cout << "[ X ]";
                color(hConsole, 7);
            }

        }
        cout << endl;
    }
}
void carga_pantalla()
{
    cout << "Realizando carga en pantalla..." << endl;
    int aux = 0; //para usar los colores sin pasarme del 15 (porque si no se pinta el contorno de las letras y no quiero xd)
    const int numFrames = 30;
    const int frameDelayMs = 100;

    const char frames[] = { '-', '\\', '|', '/' };

    for (int i = 0; i < numFrames; ++i)
    {
        aux++;
        color(hConsole, aux);
        if (aux == 15)
        {
            aux = 0;
        }
        cout << "Cargando " << frames[i % 4] << "\r";
        cout.flush();

        this_thread::sleep_for(chrono::milliseconds(frameDelayMs));
    }

    cout << endl << "Carga completada." << endl;
}