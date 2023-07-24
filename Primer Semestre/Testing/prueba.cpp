#include <iostream>

double factorial(int n) {
    if (n == 0)
        return 1;
    else
        return n * factorial(n - 1);
}

double potencia(double base, int exponente) {
    double resultado = 1;
    for (int i = 0; i < exponente; i++) {
        resultado *= base;
    }
    return resultado;
}

double exponencial(double x) {
    double suma = 0;
    for (int n = 0; n < 10; n++) {
        double term = potencia(x, n) / factorial(n);
        suma += term;
    }
    return suma;
}

int main() {
    try {
        double x;
        std::cout << "Ingrese el número 'x' para calcular la función exponencial: ";
        std::cin >> x;

        double resultado = exponencial(x);
        std::cout << "La función exponencial de " << x << " es: " << resultado << std::endl;
    } catch (...) {
        std::cout << "Error: Ingrese un número válido." << std::endl;
    }

    return 0;
}
