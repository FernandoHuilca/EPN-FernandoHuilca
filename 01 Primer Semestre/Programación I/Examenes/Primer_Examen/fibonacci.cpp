#include <iostream>
using namespace std;

int main() {
    int numTerminos;

    cout << "Ingresa el numero de términos de la serie de Fibonacci que deseas ver: ";
    cin >> numTerminos;

    int primero = 0, segundo = 1;

    cout << "Serie de Fibonacci de " << numTerminos << " términos:" << endl;

    for (int i = 0; i < numTerminos; i++) {
        cout << primero << " ";

        int siguiente = primero + segundo;
        primero = segundo;
        segundo = siguiente;
    }

    cout << endl;

    return 0;
}
