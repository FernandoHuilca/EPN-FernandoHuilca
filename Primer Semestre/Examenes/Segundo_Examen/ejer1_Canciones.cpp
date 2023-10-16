//Author Fernando Huilca
/*CANCIONES. Se quiere implementar una aplicaci�n para gestionar canciones. El n�mero total de canciones
no puede superar un cierto valor m�ximo N=50, siendo el n�mero de temas existentes en cada momento variable.
La informaci�n que se quiere almacenar para cada canci�n se encuentra en el archivo canciones.txt que para cada
canci�n tiene una l�nea con la siguiente informaci�n: N�mero de canci�n, T�tulo de la canci�n, Nombre del autor,
Genero de la canci�n (Salsa, Merengue, Baladas, Boleros, Electr�nica o Pop).
Se pide realizar un men� que permita:
�	Ingresar nuevas canciones
�	Eliminar canciones por el n�mero.
�	Listar todas las canciones.
�	Listar canciones por g�nero. Se presentar� un submen� para que el usuario seleccione el g�nero de canciones
que quiere listar.
�	Buscar canciones por autor, donde si el autor existe se listar�n todas sus canciones.
�	Salir.
*/


#include <iostream>
#include <string>
#include <fstream>
using namespace std;

const int DIM = 50;

typedef struct {
    int numero;
    string titulo;
    string autor;
    string genero;
} TCanciones;

typedef struct {
    TCanciones elementos[DIM];
    int contador;
} tlista_canciones;

// Funciones
int menuPrincipal();
void ingresar(tlista_canciones& lista);
void eliminar(tlista_canciones& lista);
void listarCanciones(tlista_canciones& lista);
void listarGenero(tlista_canciones& lista);
void buscarAutor(tlista_canciones& lista);
void cargar(tlista_canciones& lista);
void guardar(const tlista_canciones& lista);

int main() {
    tlista_canciones lista;
    lista.contador = 0;

    int opcion = 1;
    while (opcion != 6) {
        opcion = menuPrincipal();
        cout << endl;
        switch (opcion) {
        case 1:
            ingresar(lista);
            break;
        case 2:
            eliminar(lista);
            break;
        case 3:
            listarCanciones(lista);
            break;
        case 4:
            listarGenero(lista);
            break;
        case 5:
            buscarAutor(lista);
            break;
        case 6:
            guardar(lista);
            cout << "Adios." << endl;
            break;
        default:
            cout << "Opcion no valida." << endl;
            break;
        }
    }

    return 0;
}

int menuPrincipal() {
    int opcion;
    cout << "Menu Principal_____________" << endl;
    cout << "1. Ingresar nuevas canciones" << endl;
    cout << "2. Eliminar canciones por n�mero" << endl;
    cout << "3. Listar todas las canciones" << endl;
    cout << "4. Listar canciones por g�nero" << endl;
    cout << "5. Buscar canciones por autor" << endl;
    cout << "6. Salir" << endl;
    cout << "Ingrese una opci�n: ";
    cin >> opcion;
    return opcion;
}

void cargar(tlista_canciones& lista)
{
    ifstream archivo("canciones.txt");
    if (!archivo.is_open())
    {
        cout << "No se pudo abrir el archivo" << endl;
    }

    while (lista.contador < DIM && archivo >> lista.elementos[lista.contador].numero)
    {
        archivo >> lista.elementos[lista.contador].titulo;
        archivo >> lista.elementos[lista.contador].autor;
        archivo >> lista.elementos[lista.contador].genero;
        lista.contador++;
    }

    archivo.close();

}

void guardar(const tlista_canciones& lista) {
    ofstream archivo("canciones.txt");
    if (!archivo.is_open()) {
        cout << "Error al guardar el archivo de canciones." << endl;
        return;
    }

    for (int i = 0; i < lista.contador; i++) {
        archivo << lista.elementos[i].numero << endl;
        archivo << lista.elementos[i].titulo << endl;
        archivo << lista.elementos[i].autor << endl;
        archivo << lista.elementos[i].genero << endl;
    }

    archivo.close();
}

void ingresar(tlista_canciones& lista) {
    if (lista.contador < DIM) {
        TCanciones nuevaCancion;
        nuevaCancion.numero = lista.contador + 1;

        cin.ignore();
        cout << "Ingrese el titulo de la cancion: ";
        getline(cin, nuevaCancion.titulo);
        cout << "Ingrese el nombre del autor: ";
        getline(cin, nuevaCancion.autor);
        cout << "Ingrese el g�nero de la canci�n: ";
        getline(cin, nuevaCancion.genero);

        lista.elementos[lista.contador] = nuevaCancion;
        lista.contador++;

        cout << "Cancion ingresada con exito." << endl;
    }
    else {
        cout << "Error: La lista de canciones esta llena." << endl;
    }
}

void eliminar(tlista_canciones& lista)
{

}

void listarCanciones(tlista_canciones& lista)
{
    if (lista.contador > 0) {
        cout << "Lista de canciones:" << endl;
        for (int i = 0; i < lista.contador; i++) {
            cout << "Numero: " << lista.elementos[i].numero << endl;
            cout << "Titulo: " << lista.elementos[i].titulo << endl;
            cout << "Autor: " << lista.elementos[i].autor << endl;
            cout << "Genero: " << lista.elementos[i].genero << endl;
            cout << "-------------------" << endl;
        }
    }
    else {
        cout << "No hay canciones para mostrar." << endl;
    }
}

void listarGenero(tlista_canciones& lista) {
    if (lista.contador > 0) {
        string Buscado;
        cout << "Ingrese el g�nero de canciones a listar: ";
        cin.ignore();
        getline(cin, Buscado);

        cout << "Canciones del g�nero " << Buscado << ":" << endl;
        for (int i = 0; i < lista.contador; i++) {
            if (lista.elementos[i].genero == Buscado) {
                cout << "Numero: " << lista.elementos[i].numero << endl;
                cout << "Titulo: " << lista.elementos[i].titulo << endl;
                cout << "Autor: " << lista.elementos[i].autor << endl;
                cout << endl;
            }
        }
    }
    else {
        cout << "No hay canciones para mostrar." << endl;
    }
}

void buscarAutor(tlista_canciones& lista) {

}
