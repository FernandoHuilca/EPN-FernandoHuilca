// Author: Fernando Huilca
#include <iostream>
#include <sstream>
#include <fstream>
#include <iostream>
#include <iomanip>
using namespace std;

//Personal Libreria



//Librerias
void presentarListaDeAmigos();
int presentarMenuPrincipal();



int main()
{
    
    switch (presentarMenuPrincipal())
    {
    case 1: 
    {
        presentarListaDeAmigos();
    }
    default:
        break;
    }

}

void presentarListaDeAmigos() {
    ofstream leerArchivo;
    leerArchivo.open("ListaDeAmigos.txt");
    if (!leerArchivo.is_open())
    {
        cout << "Error: No se pudo abrir el archivo de amigos";
    }
    else
    {

    }
}
int presentarMenuPrincipal() {
    int opcion; 
    do {
        cout << "___________Chat Secreto___________" << endl;
        cout << "1. Mostrar amigos " << endl;
        cout << "0. Salir" << endl;
        cin >> opcion;
    } while (opcion < 0 || opcion > 1);
    return opcion; 
}