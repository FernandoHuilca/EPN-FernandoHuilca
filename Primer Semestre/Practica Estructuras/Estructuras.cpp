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
// Prototipos de Funciones del main
int menu();
void saludo_Ejercicio();
//Prototipos y todo lo necesario para resolver el primer ejercicio
const int DIM = 50;
const int DIM3 = 4; 
typedef struct
{
    string nombre_equipo;
    int partidos_ganados;
    int partidos_empatados;
    int puntos;
}tEquipo;
typedef struct
{
    tEquipo equipo[DIM];
    int contadorEquipos;
}tLista_Equipos;
void ejercicio_1();
int sub_menu_ejer1();
void agregarE(tLista_Equipos& lista, tEquipo equipo, bool& ok);
void LeerEquipo(tEquipo& equipo);
void OrdenarEquipos(tLista_Equipos& lista);
void mostrarEquipos(const tLista_Equipos& lista);

//Prototipos y todo lo necesario para resolver el ejercicio 3 
void ejercicio_3();
typedef struct
{
    string nombre; 
    int edad; 
    string estudios; 
    string contratacion;
}tBecarios;
typedef struct
{
    tBecarios elementos[DIM3];
    int contadorBecarios;
}tlistaBecarios;

void cargar(tlistaBecarios& lista, bool& ok);
void MostrarBecarios(const tlistaBecarios& lista);


int opcion = 1;


/***************************************************INICIO DEL MAIN***********************************************************/
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
            ejercicio_3();
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
/*************************************************FIN DEL MAIN*************************************************/

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
        system("cls");
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
    lista.contadorEquipos = 0;
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
                system("cls");
                OrdenarEquipos(lista); 
                mostrarEquipos(lista);
            }


            }
        } while (opcion != 0);



}

int sub_menu_ejer1()
{
    int opcion;
    do {
        cout << " __________Equipos__________" << endl;
        cout << "|     1. Agregar Equipo     |" << endl;
        cout << "|     2. Mostrar lista      |" << endl;
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
void LeerEquipo(tEquipo& equipo)
{
    cin.ignore(); 
    cout << "Nombre del Equipo: "; 
    getline(cin, equipo.nombre_equipo);
    //cin.ignore(); 
    cout << "Numero de partidos ganados: ";
    cin >> equipo.partidos_ganados; 
    cout << "Numero de partidos empatados: ";
    cin >> equipo.partidos_empatados;
    equipo.puntos = (equipo.partidos_ganados * 3) + (equipo.partidos_empatados);
    system("cls");
}

void OrdenarEquipos(tLista_Equipos& lista)
{
    for (int i = 1; i < lista.contadorEquipos; i++)
    {
        tEquipo actual = lista.equipo[i];
        int j = i - 1; 
        while (j >= 0 && lista.equipo[j].puntos > actual.puntos)
        {
            lista.equipo[j + 1] = lista.equipo[j];
            j--;
        }
        lista.equipo[j + 1] = actual; 
    }
}


void mostrarEquipos(const tLista_Equipos& lista)
{
    color(hConsole,11);
    cout << " ___Tabla Ordenada por Puntos___" << endl;
    cout << "  Nombre              Puntos    " << endl;
    for (int i = 0; i < lista.contadorEquipos; i++)
    {
        cout << lista.equipo[i].nombre_equipo << "\t\t" << lista.equipo[i].puntos << endl;
    }
    color(hConsole, 7);
}

//Funciones para el ejercicio 3 
void ejercicio_3()
{
    tlistaBecarios lista; 
    bool exito = true; 
    /*3.	Becarios. Una empresa guarda información acerca de sus N empleados (ni uno más ni uno menos). La información almacenada sobre cada empleado 
    consiste en su nombre, su edad, su grado de estudios (Escuela, Bachillerato, título técnico, tercer nivel, Máster, Doctorado) y el tipo de contratación
    (Fijo, En prácticas, Eventual o Becario). Realiza las declaraciones de tipos apropiadas para representar la citada información y escribe un subprograma 
    que muestre por pantalla el nombre y la titulación de todos los becarios.*/
    cargar(lista, exito);
    if (!exito)
    {
        cout << "ERROR: no se pudo cargar los datos " << endl;
    }
    else
    {
    MostrarBecarios(lista);
    cout << endl << endl; 
    }
   


}

void cargar(tlistaBecarios& lista, bool& ok)
{
    tBecarios becario;
    ifstream leer_archivo;
    char aux;
    lista.contadorBecarios = 0;
    leer_archivo.open("Becarios.txt");
    if (!leer_archivo.is_open())
    {
        ok = false;
    }
    else
    {
        ok = true;
        getline(leer_archivo, becario.nombre);
        //cout << equipo.nombre_equipo << endl;
        while ((!leer_archivo.eof()) && (lista.contadorBecarios < DIM3)) //(!leer_archivo.eof() para que vaya hasta el final del archivo
        {
            leer_archivo >> becario.edad;
            leer_archivo.get(aux);
            getline(leer_archivo, becario.estudios);
            getline(leer_archivo, becario.contratacion);
            lista.elementos[lista.contadorBecarios] = becario;
            lista.contadorBecarios++;

            getline(leer_archivo, becario.nombre);

        }
        leer_archivo.close();
    }
}


void MostrarBecarios(const tlistaBecarios& lista)
{
    cout << "         _________BECARIOS LISTA_________" << endl; 
    cout << "    Nombre                             Titulacion     " << endl << endl;
    for (int i = 0; i < DIM3; i++)
    {
        cout << lista.elementos[i].nombre << "\t\t" << lista.elementos[i].estudios << endl;
    }
}




