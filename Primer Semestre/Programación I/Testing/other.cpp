#include <iostream>
using namespace std;

// Función para dibujar el diagrama de barras
void dibujar_diagrama_barras(const int datos[], int tamano) {
    // Encontrar el máximo valor en el arreglo para escalar el gráfico
    int max_valor = datos[0];
    for (int i = 1; i < tamano; i++) {
        if (datos[i] > max_valor) {
            max_valor = datos[i];
        }
    }

    // Dibujar el diagrama de barras
    for (int i = max_valor; i > 0; i--) {
        for (int j = 0; j < tamano; j++) {
            if (datos[j] >= i) {
                cout << "### "; // Carácter para representar la barra
            } else {
                cout << "    ";
            }
        }
        cout << endl;
    }

    // Etiquetas del eje x (números del 1 al tamano)
    for (int i = 0; i < tamano; i++) {
        cout << " " << i + 1 << "  ";
    }
    cout << endl;
}

int main() {
    const int tamano = 5;
    int datos[tamano];

    // Pedir al usuario los datos para el arreglo
    cout << "Ingrese " << tamano << " datos separados por espacios: ";
    for (int i = 0; i < tamano; i++) {
        cin >> datos[i];
    }

    // Dibujar el diagrama de barras
    cout << "Diagrama de Barras:" << endl;
    dibujar_diagrama_barras(datos, tamano);

    return 0;
}
