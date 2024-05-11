//Author Fernando Huilca
//Programa dedicado al estudio de aplicacion de colores en el codigo de C++
#include <iostream>
using namespace std;
#include <Windows.h> //inluyo la biblioteca windows que me facilita el uso de colores
#define color SetConsoleTextAttribute


int main()
{
    HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);

    cout << "PROGRAMA QUE IMPRIME COLORES:" << endl;

    //Para ver todos los colores que puede imprimir hare un for 
    for (int i = 0; i < 80; i++)
    {
        color(hConsole, i);

        cout << "Color del numero: " << i << endl;
        cout << "Como culpar al viento por el desorden" << endl;
        cout << "Si fui yo quien dejo la ventana abierta" << endl << endl;
    }
    /*
    1. Azul
    2. Verde
    3. Celeste
    4. Rojo
    5. Violeta
    6. Amarrillo
    7. Blanco
    8. Gris
    9. Azul intermedio
    10. Verde
    11. Verde opacio
    12. Naranja
    13. Violeta
    14. Amarrillo
    15. Crema
    */

    return 0;
}

/*PASOS PARA PONER COLORES:
1. Agregar la libreria windows.h
2. agregar bajo la libreria del paso 1 lo siguiente --> #define color SetConsoleTextAttribute
3. dentro del main escribir -->        HANDLE hConsole = GetStdHandle( STD_OUTPUT_HANDLE );
4. si se desea uar algun color escribir --> color(hConsole, k); (donde k es el numero del color deseado)
*/