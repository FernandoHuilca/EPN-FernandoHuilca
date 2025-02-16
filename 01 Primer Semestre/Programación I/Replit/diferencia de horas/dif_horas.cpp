// Calcular la diferencia de tiempo entre dos instantes de tiempo específicos,
// usando estructuras.

#include <iostream>
using namespace std;
#include <string> 
#include <iomanip>

typedef struct {
  int horas;
  int minutos;
  int segundos;
} tTiempo;

// Funcion leer tiempo
void leer_tiempo(tTiempo &tiempo);

// Funcion imprimir tiempo
void imprimir_tiempo(tTiempo &tiempo);

// Funcion calcular diferencia de tiempo
void diferencia_tiempo(tTiempo &tiempo, tTiempo &tiempo2, tTiempo &diferencia);

int main() {
  tTiempo t1, t2, diferencia;
  // Preguntar al usuario por los tiempos  t1 y t2
  cout << "---Primer Tiempo--- " << endl;
  leer_tiempo(t1);
  imprimir_tiempo(t1);
  cout << "---Segundo Tiempo--- " << endl;
  leer_tiempo(t2);
  imprimir_tiempo(t2);

  // Calcular la diferencia
  cout << "La diferencia entre los timpos ingresados es: " << endl;
  diferencia_tiempo(t1, t2, diferencia);
  imprimir_tiempo(diferencia);
}

void leer_tiempo(tTiempo &tiempo) {
  cout << "Escriba las horas: ";
  cin >> tiempo.horas;
  cout << "Escriba los minutos: ";
  cin >> tiempo.minutos;
  cout << "Escriba los segundos: ";
  cin >> tiempo.segundos;
}
void imprimir_tiempo(tTiempo &tiempo) {
  cout << "Modelo hh:mm:ss  " << endl;
  cout << tiempo.horas << ":" << tiempo.minutos << ":" << tiempo.segundos
       << endl;
}
void diferencia_tiempo(tTiempo &tiempo, tTiempo &tiempo2, tTiempo &diferencia) {
    int suma1 = 0, suma2 = 0, total, restante;
    
    suma1 += (tiempo.horas * 3600);
    suma1 += (tiempo.minutos * 60);
    suma1 += (tiempo.segundos);
    
    suma2 += (tiempo2.horas * 3600); 
    suma2 += (tiempo2.minutos * 60); 
    suma2 += (tiempo2.segundos);     

    total = suma1 - suma2; 
    if (total < 0)
    {
        total = total * -1;
    }
    diferencia.horas = total / 3600; 
    restante = total % 3600 ;
    diferencia.minutos = restante / 60; 
    diferencia.segundos = restante % 60; 
}
