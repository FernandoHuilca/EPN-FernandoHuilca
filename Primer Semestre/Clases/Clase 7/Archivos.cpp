// Author Fernando Huilca 

#include <iostream> 
using namespace std;
#include <fstream> // Para usar leer files (carpetas)
#include <string> // Usar para lectura de cadenas de texto
#include <iomanip> // Para ajustar el texto a la derecho o izquierda y en cuantos espacios se guardan

int main()
{

    const int IVA = 12;
    string producto, cedula;
    int cantidad;
    int contador = 0;
    char aux;
    double precio, neto, total, iva;
    // Leer datos del archivo   
    ifstream archivo; //ifstream para ingresar datos
    archivo.open("compras.txt"); //para abrir el archivo de nombre compras.txt
    if (!archivo.is_open()) //con esto verificamos si se abrio o no el archivo
    {
        cout << "No se pudo abrir el arcivo" << endl; //en caso de que no se habra 
    }
    else // en caso de que el archivo si lo hallamos abierto 
    {
        // codigo para leer el archivo 

        archivo >> cedula; // leemos y asignamos loa valores dentro de "archivo" lo que se acomode a cedula que es un tipo string 
        while (cedula != "x")
        {
            archivo >> cantidad;
            archivo >> precio;
            //archivo >> producto;
            archivo.get(aux); // MUY UTIL!! Saltar espacio
            getline(archivo, producto); // PARA LEER CON ESPACIOS 
            contador++; //---> ++contador --> contador = contador +1 ---> contador +=1
            neto = cantidad * precio; // Calculamos el valor sin mas 
            iva = neto * IVA / 100; // Muestra cuanto es el 12% de la cantidad de compra
            total = neto + iva; // Calcula el valor a pagar 
            cout << " Compra " << contador << ". ";
            cout << "\t Cedula " << cedula << " "
                << left << setw(20) << producto << ": " // Usamos el left << setw (20) para alinear todo a la izquierda y que ocupe 20 espacios 
                << left << setw(3) << cantidad << " x "
                << left << setw(7) << fixed << setprecision(2) << precio << " = " // Usamos el fixed << setpreciosion(2) Para designar el numero
                << left << setw(7) << neto << " - IVA:"                           // de decimales que queremos que se muestren 
                << left << setw(7) << iva
                << left << setw(7) << " -Total: " << total << endl;
            archivo >> cedula; // Para salir del bucle 


        }

    }
}
// << left << setw(7) para alineacion a la izquierda
// rigth  para alinecion a la derecha 

//TAREA HACER EN UNA TABLITA TODOS LOS DATOS 