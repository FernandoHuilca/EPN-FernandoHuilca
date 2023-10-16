#include <iostream>
#include <chrono>
#include <thread>
#include <Windows.h>
#define color SetConsoleTextAttribute
HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);

using namespace std;

int main() {
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

    return 0;
}