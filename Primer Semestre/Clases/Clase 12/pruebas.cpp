#include <iostream>
using namespace std;

const int TAM = 15;

void imprima(int array[]) {
    cout << "Arreglo de los 15 primeros múltiplos de 6:" << endl;
    for (int i = 0; i < TAM; i++) {
        cout << array[i] << endl;
    }
}

int main() {
    int multiplos[TAM];

    // Calcular los múltiplos de 6 y almacenarlos en el arreglo
    for (int i = 0; i < TAM; i++) {
        multiplos[i] = 6 * (i + 1);
    }

    // Llamar a la función para imprimir el arreglo
    imprima(multiplos);

    return 0;
}
