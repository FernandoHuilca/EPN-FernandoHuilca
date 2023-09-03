#include "buscar.h"


int buscar_nombre(const tlistaLibros lista, bool & encontrado) {
    int pos;
    string nombre; 
    encontrado = false;
    char aux;
    cin.sync();
    rlutil::locate(45, 10);
    cout << "Ingrese el nombre del libro que busca: "; 
    getline(cin,nombre); 
    for (int i = 0; ((i < lista.contador_libros) && (!encontrado)); i++) {
        if (lista.ele_libros[i].nombre == nombre) {
            pos = i;
            encontrado = true;
        }
        else {
            pos = -1;
            encontrado = false; 
        }
    }
    return pos;
}