#include <iostream>
#include <chrono>
#include <thread>

using namespace std;

int main() {
    cout << "Realizando carga en pantalla..." << endl;

    const int numFrames = 30;
    const int frameDelayMs = 100;

    const char frames[] = {'-', '\\', '|', '/'};

    for (int i = 0; i < numFrames; ++i) {
        cout << "Cargando " << frames[i % 4] << "\r";
        cout.flush();

        this_thread::sleep_for(chrono::milliseconds(frameDelayMs));
    }

    cout << endl << "Carga completada." << endl;

    return 0;
}