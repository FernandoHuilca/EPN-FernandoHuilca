#include <iostream>
using namespace std;

typedef struct {
    int horas;
    int minutos;
    int segundos;
} tTiempo;

// Funcion leer tiempo
void leer_tiempo(tTiempo& tiempo);

// Funcion imprimir tiempo 
void imprimir_tiempo(tTiempo& tiempo);

// Funcion calcular diferencia de tiempo
void diferencia_tiempo(const tTiempo& tiempo1, const tTiempo& tiempo2, tTiempo& diferencia);

int main() {
    tTiempo t1, t2, diferencia;
    // Preguntar al usuario por los tiempos t1 y t2
    cout << "Primer Tiempo: " << endl;
    leer_tiempo(t1);
    imprimir_tiempo(t1);
    cout << "Segundo Tiempo: " << endl;
    leer_tiempo(t2);
    imprimir_tiempo(t2);

    // Calcular la diferencia
    cout << "La diferencia entre los tiempos ingresados es: " << endl;
    diferencia_tiempo(t1, t2, diferencia);
    imprimir_tiempo(diferencia);

    return 0;
}

void leer_tiempo(tTiempo& tiempo)
{
    cout << "Escriba las horas: ";
    cin >> tiempo.horas;
    cout << "Escriba los minutos: ";
    cin >> tiempo.minutos;
    cout << "Escriba los segundos: ";
    cin >> tiempo.segundos;
}

void imprimir_tiempo(tTiempo& tiempo)
{
    cout << "Modelo hh:mm:ss  " << endl;
    cout << tiempo.horas << ":" << tiempo.minutos << ":" << tiempo.segundos << endl;
}

void diferencia_tiempo(const tTiempo& tiempo1, const tTiempo& tiempo2, tTiempo& diferencia)
{
    // Convertir todo a segundos para facilitar el cálculo
    int total_segundos_t1 = tiempo1.horas * 3600 + tiempo1.minutos * 60 + tiempo1.segundos;
    int total_segundos_t2 = tiempo2.horas * 3600 + tiempo2.minutos * 60 + tiempo2.segundos;

    int diferencia_segundos = total_segundos_t2 - total_segundos_t1;

    // Ajustar los valores para que sean positivos
    while (diferencia_segundos < 0) {
        diferencia_segundos += 86400; // 86400 segundos en un día (24 horas * 60 minutos * 60 segundos)
    }

    // Convertir nuevamente a formato hh:mm:ss
    diferencia.horas = diferencia_segundos / 3600;
    diferencia_segundos %= 3600;
    diferencia.minutos = diferencia_segundos / 60;
    diferencia.segundos = diferencia_segundos % 60;
}
