// Authores: Fernando Huilca y Mateo Quisilema
//  Programa dedicado a resolver 4 diferentes ejercicios usando Funciones
#include <iostream> 
using namespace std;
#include <fstream>
#include <string>
#include <iomanip>
#include <Windows.h>
#define color SetConsoleTextAttribute
HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
// Prototipos de Funciones
int menu();
void saludo_Ejercicio();
//Funcion y todo lo necesario para resolver el primer ejercicio
const int DIM = 50;
typedef struct
{
    string nombre_equipo;
    int partidos_ganados;
    int partidos_empatados;
}tEquipo;
typedef struct
{
    tEquipo equipo[DIM];
    int contadorEquipos;
}tLista_Equipos;
void cargar(tLista_Equipos& lista, bool& ok);
void guardar(const tLista_Equipos& lista);
void ejercicio_1();
int sub_menu_ejer1();
void agregarE(tLista_Equipos& lista, tEquipo equipo, bool& ok);
void LeerEquipo(tEquipo& equipo);



int opcion = 1;

int main() {
    cout << "_______BIENVENIDO A LOS EJERCICIOS DE ESTRUCTURAS______" << endl;
    cout << "                             ~ AUTHOR Fernando Huilca" << endl;
    cout << "                             ~ AUTHOR Mateo Quisilema" << endl;
    cout << endl;
    while (opcion != 0) // Para presentar el menu varias veces
    {
        opcion = menu(); // Se muestra el menu con las opciones de cada ejercicio
        cout << endl;    // Salto de linea para mas elegancia jeje
        switch (opcion) {
        case 1:
            saludo_Ejercicio();
            ejercicio_1();
            break;
        case 2:
            saludo_Ejercicio();
            //ejercicio_2();
            break;
        case 3:
            saludo_Ejercicio();
            //ejercicio_3();
            break;
        case 4:
            saludo_Ejercicio();
            //ejercicio_4();
            break;
        }
    }
    cout << "Adios. " << endl;
    return 0;
}

// FUNCIONES DEL PROGRAMA
int menu() {
    int opcion;
    do {
        cout << " ____MENU EJERCICIOS REALIZADOS____" << endl;
        cout << "|                                  |" << endl;
        cout << "|Seleccione el ejercicio que desee:|" << endl;
        cout << "|__________________________________|" << endl;
        cout << "|      Ejercicios        | Numero  |" << endl;
        cout << "|------------------------|---------|" << endl;
        cout << "| 1) Ejercicio Equipos   |    1    |" << endl;
        cout << "| 2) Ejercicio Animales  |    2    |" << endl;
        cout << "| 3) Ejercicio Becarios  |    3    |" << endl;
        cout << "| 4) Ejercicio de Fechas |    4    |" << endl;
        cout << "|__________________________________|" << endl;
        cout << "| 0) SALIR                    0    |" << endl;
        cout << "|__________________________________|" << endl;
        cin >> opcion;
        if (opcion < 0 || opcion > 4) {
            color(hConsole, 4);
            cout << "Opcion seleccionada INCORRECTA." << endl;
            cout << "Por favor, digite un numero entero del 0 al 6" << endl;
            color(hConsole, 7);
        }
    } while (opcion < 0 || opcion > 4);
    return (opcion);
}
void saludo_Ejercicio() {
    cout << "Bienvenido al Ejercicio " << opcion << endl;
    cout << "Autor Fernando Huilca. " << endl;
    cout << "Autor Mateo Quisilema. " << endl;
    cout << endl;
}

//Funciones para ejercicio 1 
void ejercicio_1()
{
    /*1.	Equipos.  Realizar un programa de información de equipos de futbol donde el usuario ingrese nombre del equipo,
    partidos ganados y empatados y se calcule los puntos sabiendo que un partido ganado proporciona 3 puntos y un empatado 1 puntos.
    El programa debe permitir agregar elementos a un arreglo contenido en una estructura y ordenar los puntos de los equipos de menor a mayor.*/
    tLista_Equipos lista;
    tEquipo equipo;
    bool exito = true;
    int opcion;
    cargar(lista, exito);
    if (!exito)
    {
        color(hConsole, 4);
        cout << "ERROR: No se puedo cargar la lista " << endl;
        color(hConsole, 7);
    }
    else
    {

        do
        {
            opcion = sub_menu_ejer1();
            switch (opcion)
            {
            case 1:
            {

                LeerEquipo(equipo);
                agregarE(lista, equipo, exito);
                if (!exito)
                {
                    cout << "Lista de equipos completos" << endl;
                }
                break;
            }
            case 2: 
            {

            }


            }
            guardar(lista);
        } while (opcion != 0);



    }


}
void cargar(tLista_Equipos& lista, bool& ok)
{
    tEquipo equipo;
    ifstream leer_archivo;
    char aux;
    lista.contadorEquipos = 0;
    leer_archivo.open("Equipos.txt");
    if (!leer_archivo.is_open())
    {
        ok = false;
    }
    else
    {
        ok = true;
        getline(leer_archivo, equipo.nombre_equipo);
        //cout << equipo.nombre_equipo << endl;
        while ((!leer_archivo.eof()) && (lista.contadorEquipos < DIM)) //(!leer_archivo.eof() para que vaya hasta el final del archivo
        {
            leer_archivo >> equipo.partidos_ganados;
            leer_archivo >> equipo.partidos_empatados;
            leer_archivo.get(aux);
            lista.equipo[lista.contadorEquipos] = equipo;
            lista.contadorEquipos++;


            getline(leer_archivo, equipo.nombre_equipo);

        }
        leer_archivo.close();
    }
}

void guardar(const tLista_Equipos& lista)
{
    ofstream escribir_archivo;
    escribir_archivo.open("Equipos.txt");
    for (int i = 0; i < lista.contadorEquipos; i++)
    {
        escribir_archivo << lista.equipo[i].nombre_equipo << endl;
        escribir_archivo << lista.equipo[i].partidos_ganados << endl;
        escribir_archivo << lista.equipo[i].partidos_empatados << endl;
    }
    escribir_archivo.close();
}

int sub_menu_ejer1()
{
    int opcion;
    do {
        cout << " __________Equipos__________" << endl;
        cout << "|     1. Agregar Equipo     |" << endl;
        cout << "|     2. Calcular           |" << endl;
        cout << "|     0. Salir              |" << endl;
        cout << " ---------------------------" << endl;
        cout << "Opcion: ";
        cin >> opcion;
        if (opcion < 0 || opcion > 2) {
            color(hConsole, 4);
            cout << "Opcion seleccionada INCORRECTA." << endl;
            cout << "Por favor, digite un numero entero del 0 al 2" << endl;
            color(hConsole, 7);
        }
    } while (opcion < 0 || opcion > 2);
    return (opcion);
}


void agregarE(tLista_Equipos& lista, tEquipo equipo, bool& ok)
{
    ok = true; 
    if (lista.contadorEquipos == DIM)
    {
        ok = false; 
    }
    else
    {
        //Insertar al final 
        lista.equipo[lista.contadorEquipos] = equipo;
        lista.contadorEquipos++;
    }

}
void LeerEquipo(tEquipo & equipo)
{
    cin.ignore(); 
    cout << "Nombre del Equipo: "; 
    getline(cin, equipo.nombre_equipo);
    //cin.ignore(); 
    cout << "Numero de partidos ganados: ";
    cin >> equipo.partidos_ganados; 
    cout << "Numero de partidos empatados: ";
    cin >> equipo.partidos_empatados;
}