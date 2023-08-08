/*Escribir un programa en C++ para determinar la fecha del siguiente día. El programa leerá un listado de fechas del archivo fechas.txt las almacenará en una estructura del tipo tListadoFecha. Se creará otra estructura del mismo tipo donde en el arreglo se almacenará la fecha del siguiente día de cada fecha del primer listado.

Se imprimirá en pantalla cada una de las fechas junto a la fecha del día siguiente.

Se presenta una parte inicial del código, se espera que complete las funciones que faltan.

Un ejemplo de la ejecución esperada

Autor: Su nombre
***Fechas***
_______________________________
|Fecha listado | siguiente día|
_______________________________
|Dia |Mes |Año |Dia |Mes |Año |
|30  |7   |1992|31  |7   |1992|
|31  |12  |1989|1   |1   |1990|
|28  |2   |1992|2   |29  |1992|
...

El programa no interactua con el usuario.*/
//Author Fernando Huilca
#include <iostream>
using namespace std;
#include <iomanip>
#include <fstream>

//Numero máximo de fechas 10 -> centinela día = 0
const int MAX = 10;
typedef struct 
{
    int dia, mes, anio;
}tFecha;

typedef struct {
    tFecha fechas[MAX];
    int contador;
}tListadoFechas;
//Prototipos
//Funcion para leer el listado de fechas del archivo
void leerFechasDeArchivo(tListadoFechas& listadoFechas, bool& ok);
//Función que recibe una fecha y nos entrega la del siguiente día
tFecha siguienteDia(tFecha fecha);
//Función para saber si un año es bisiesto
bool bisiesto(int anio);

int main() {
    tListadoFechas fechaLista, fechaSiguiente;
    bool exito = true;
    leerFechasDeArchivo(fechaLista, exito);

    if (!exito) {
        cout << "Error al abrir el archivo." << endl;
        return 1;
    }

    cout << "Autor: Fernando Huilca" << endl;
    cout << "***Fechas***" << endl;
    cout << "_______________________________" << endl;
    cout << "|Fecha listado | siguiente día|" << endl;
    cout << "_______________________________" << endl;
    cout << left << "|" << setw(4) << "Dia" << "|" << setw(4) << "Mes" << "|" << setw(5) << "Año |"
         << setw(4) << "Dia" << "|" << setw(4) << "Mes" << "|" << setw(6) << "Año |" << endl;

    for (int i = 0; i < fechaLista.contador; i++) {
        tFecha siguiente = siguienteDia(fechaLista.fechas[i]);
        cout << setw(4) << fechaLista.fechas[i].dia << "|" << setw(4) << fechaLista.fechas[i].mes << "|"
             << setw(5) << fechaLista.fechas[i].anio << "|" << setw(4) << siguiente.dia << "|"
             << setw(4) << siguiente.mes << "|" << setw(6) << siguiente.anio << "|" << endl;
    }
    cout << "_______________________________" << endl;

    return 0;
}




void leerFechasDeArchivo(tListadoFechas& listadoFechas, bool& ok)
{
    tFecha fecha; 
    ifstream leer_archivo;
    listadoFechas.contador = 0; 
    leer_archivo.open("fechas.txt");
    if (!leer_archivo.is_open())
    {
        ok = false;
    } 
    else
    {
        ok = true;
        leer_archivo >> fecha.dia;  
        while (fecha.dia != 0 && listadoFechas.contador < MAX)
        {
            leer_archivo >> fecha.mes;
            leer_archivo >> fecha.anio; 

            listadoFechas.fechas[listadoFechas.contador] = fecha;
            listadoFechas.contador++; 

            leer_archivo >> fecha.dia; 
        }
        leer_archivo.close(); 
    }
    

}
tFecha siguienteDia(tFecha fecha) {
    tFecha siguiente = fecha;

    int diasPorMes[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    if (bisiesto(fecha.anio)) {
        diasPorMes[2] = 29;
    }

    if (fecha.dia < diasPorMes[fecha.mes]) {
        siguiente.dia++;
    } else {
        siguiente.dia = 1;
        if (fecha.mes < 12) {
            siguiente.mes++;
        } else {
            siguiente.mes = 1;
            siguiente.anio++;
        }
    }

    return siguiente;
}

bool bisiesto(int anio) {
    return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
}
