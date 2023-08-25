//Author Fernando Huilca 
#include <iostream>
using namespace std; 
#include <fstream>
#include <string>
#include <iomanip>
const int DIM = 100;
typedef struct
{
    string usuario;
    string contrasenia; 
}tRegistros;
typedef struct
{
    tRegistros elementos[DIM];
    int contador;
}tListas_registros;

int main()
{


    

}


bool acceso(tListas_registros& lista)
{
    string user;
    string password;
    ifstream leer_datos; 
    leer_datos.open("UserAndPassword.txt");
    if (!leer_datos.is_open())
    {
        cout << "Error: No se abrio el archivo con los registros de usuarios " << endl;
    
    }
    else
    {
        tRegistros Persona;
        cout << "Usuario: ";
        cin >> user;
        cout << "Contrasenia: ";
        cin >> password;
        lista.contador = 0; 
        getline(leer_datos, Persona.usuario)
        while ((Persona.usuario != "xxx") && (lista.contador < DIM))
        {

        }
       
        if ()
        {
            return true;
        }
        else
        {
            cout << "ERROR: Usuario o contrasenia incorrectos. " << endl;
        }
    }


    
}

void cargar(tListas_registros& lista, bool& ok)
{
    tRegistros Persona;
    ifstream leer_archivo;
    char aux;
    lista.contador = 0;
    leer_archivo.open("UserAndPassword.txt");
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