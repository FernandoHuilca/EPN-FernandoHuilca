// Author Fernando Huilca 
// Ejemplo completo sobre arreglos (con esto se pasa el semestre jeje)
/*Programa que mantenga una lista de los estudiantes de una clase. De cada estudiante: Nombre, apellid , edad, NIF y nota.
Se desconoce el numero total de estudiantes (maximo 100)
La informacion de la lista se amntiene en un archivo clase.txt
Se carga al empezar y se guarda al finalizar
El programa debe ofrecer estas opciones:
Anadir un nuevo elemento
Eliminar un alumno existente
Calificar a los estudiantes
Listado de notas, identificando la mayor y la media*/
#include <iostream> 
using namespace std;
#include <string> 
#include <iomanip> 
#include <fstream>

const int MAX = 100; // numero maximo que nos indica el ejercicio
typedef struct
{
    string nombre;
    string apellido;
    int edad;
    string nif;
    double nota;
}tEstudiante;

//Otra estructura para llevar de la mano el contador y el arreglo
typedef struct
{
    tEstudiante elementos[MAX];
    int contador;
}tLista;

//Prototipos de funciones 
int menu();
void cargar(tLista& lista, bool& ok);
void guardar(const tLista& lista);
void leerEstudiante(tEstudiante& estudiante);
void insertarEstudiante(tLista& lista, tEstudiante estudiante, bool& ok);
void eliminarEstudiante(tLista& lista, int pos, bool& ok);
string nombreCompleto(tEstudiante estudiante);
void calificar(tLista& lista);
double mediClase(const tLista lista);
int mayorNota(const tLista lista);
void mostrarEstudiante(tEstudiante estudiante);
void listado(const tLista lista, double media, int mayor);



/****************************************************************/
int main()
{
    tLista lista;
    tEstudiante estudiante;
    bool exito = true;
    int op, pos;
    cargar(lista, exito);
    if (!exito)
    {
        cout << "ERROR No se puedo cargar la lista " << endl;
    }
    else
    {
        do
        {
            op = menu();
            switch (op)
            {
            case 1:

            {
                leerEstudiante(estudiante);
                insertarEstudiante(lista, estudiante, exito);
                if (!exito)
                {
                    cout << "Lista de estudiantes completa " << endl;
                }
            }
            break;

            case 2:
            {
                cout << "Posicion: ";
                cin >> pos;
                eliminarEstudiante(lista, pos - 1, exito);
                if (!exito)
                {
                    cout << "Elemento inexistente en la lista" << endl;
                }
            }
            break;
            case 3:
            {
                calificar(lista);

            }
            break;
            case 4:
            {
                listado(lista, mediClase(lista), mayorNota(lista));
            }
            break; 
            }
        } while (op != 0);
        guardar(lista);

    }

    return 0;
}
/*********************************************************************/


int menu()
{
    int opcion;
    do
    {
        cout << "__________Menu de opciones__________" << endl << endl;
        cout << "1. Aniadir un nuevo estudiante " << endl;
        cout << "2. Eliminar un estudiante " << endl;
        cout << "3. Calificar a los estudiantes" << endl;
        cout << "4. Listado de estudiantes " << endl;
        cout << "0. Salir" << endl;
        cout << "-------------------------------" << endl;
        cout << "Opcion: ";
        cin >> opcion;
        cout << endl;
    } while (opcion < 0 || opcion > 4);
    return opcion; 

}
void cargar(tLista& lista, bool& ok)
{
    tEstudiante estudiante;
    ifstream leer_archivo;
    char aux;
    lista.contador = 0;
    leer_archivo.open("clase.txt");
    if (!leer_archivo.is_open())
    {
        ok = false;
        //cout << "ERROR. Archivo no se pudo abrir." << endl; 
    }
    else
    {
        ok = true;
        getline(leer_archivo, estudiante.nombre);
        while ((estudiante.nombre != "xxx") && (lista.contador < MAX))
        {
            getline(leer_archivo, estudiante.apellido);
            leer_archivo >> estudiante.edad;
            leer_archivo >> estudiante.nif;
            leer_archivo >> estudiante.nota;
            leer_archivo.get(aux);
            lista.elementos[lista.contador] = estudiante;
            lista.contador++;


            getline(leer_archivo, estudiante.nombre);
        }

        leer_archivo.close();
    }
}

void guardar(const tLista& lista)
{
    ofstream escribir_archivo;
    escribir_archivo.open("clase.txt");
    for (int i = 0; i < lista.contador; i++)
    {
        escribir_archivo << lista.elementos[i].nombre << endl;
        escribir_archivo << lista.elementos[i].apellido << endl;
        escribir_archivo << lista.elementos[i].edad << endl;
        escribir_archivo << lista.elementos[i].nif << endl;
        escribir_archivo << lista.elementos[i].nota << endl;
    }
    escribir_archivo << "xxx" << endl;
    escribir_archivo.close();
}

void leerEstudiante(tEstudiante& estudiante)
{
    cin.sync();
    cout << "Nombres: ";
    getline(cin, estudiante.nombre);
    cin.sync();
    cout << "Apellidos: ";
    getline(cin, estudiante.apellido);
    cin.sync();
    cout << "Edad: ";
    cin >> estudiante.edad;
    cout << "nif: ";
    cin >> estudiante.nif;
    estudiante.nota = -1;
    cin.sync();
}
void insertarEstudiante(tLista& lista, tEstudiante estudiante, bool& ok)
{
    ok = true;
    if (lista.contador == MAX)
    {
        ok = false;
    }
    else
    {
        //INSERTARDO AL FINAL
        lista.elementos[lista.contador] = estudiante;
        lista.contador++;
    }
}
void eliminarEstudiante(tLista& lista, int pos, bool& ok)
{
    if ((pos < 0) || (pos > lista.contador - 1))
    {
        ok = false; // Elemento Inexistente
    }
    else
    {
        ok = true;
        for (int i = pos; i < lista.contador - 1; i++)
        {
            lista.elementos[i] = lista.elementos[i + 1];
        }
        lista.contador--;
    }

}
string nombreCompleto(tEstudiante estudiante)
{
    return estudiante.nombre + " " + estudiante.apellido;
}
void calificar(tLista& lista)
{
    for (int i = 0; i < lista.contador; i++)
    {
        cout << "Nombre del estudiante " << nombreCompleto(lista.elementos[i]) << ": ";
        cin >> lista.elementos[i].nota;
    }

}
double mediClase(const tLista lista)
{
    double total = 0.0;
    for (int i = 0; i < lista.contador; i++)
    {
        total += lista.elementos[i].nota;
    }
    return total / lista.contador;

}
int mayorNota(const tLista lista)
{
    double max = 0;
    int pos = 0;
    for (int i = 0; i < lista.contador; i++)
    {
        if (lista.elementos[i].nota > max)
        {
            max = lista.elementos[i].nota;
            pos = i;
        }
    }
    return pos;
}
void mostrarEstudiante(tEstudiante estudiante)
{
    cout << setw(35) << left << nombreCompleto(estudiante);
    cout << estudiante.nif << " ";
    cout << setw(2) << estudiante.edad << "anios";
    cout << fixed << setprecision(1) << estudiante.nota;
}
void listado(const tLista lista, double media, int mayor)
{
    for (int i = 0; i < lista.contador; i++)
    {
        cout << setw(3) << i + 1 << ": ";
        mostrarEstudiante(lista.elementos[i]);
        if (i == mayor)
        {
            cout << "<--- Mayor nota";
        }
        cout << endl;
    }
    cout << "Media de la clase: " << fixed << setprecision(1) << media << endl << endl;
}

