// Fernando Huilca
#include <iostream> 
#include <string>
using namespace std;
#include <fstream> // Para usar files (carpetas)

int main()
{
    string nombreL, cedulaL, nombreE, cedulaE;
    int edadL, semestreL, edadE, semestreE;
    char aux;
    ofstream archivoE; // out Para escribir en pantalla
    ifstream archivoL; // in Para leer de archivos  
    //****Escritura
    cout << "Ingrese los datos del estudiante" << endl;
    cout << "Cedula ";
    cin >> cedulaE;
    cin.get(aux);
    cout << "Nombre ";
    getline (cin, nombreE);
    cout << "Edad ";
    cin >> edadE;
    cout << "Semestre ";
    cin >> semestreE;
    //Escribir datos en el archivo
    archivoE.open("estudiante.txt");
    archivoE << endl << cedulaE << endl << nombreE << endl << edadE << endl << semestreE << endl;
    //Lectura del archivo 
    archivoL.open("estudiante.txt");
    if (!archivoL.is_open()) {
        cout << "El archivo no se ha leido" << endl;
    }
    else 
    {
        archivoL >> cedulaL;
        archivoL.get(aux);
        getline(archivoL, nombreL);
        archivoL >> edadL;
        archivoL >> semestreL;

    }
    //Imprimir en pantalla
    cout << "Cedula: " << cedulaL << "\n"
        << "Nombre: " << nombreL << endl
        << "Edad: " << edadL << endl
        << "Semestre: " << semestreL << endl;





    return 0; 
}