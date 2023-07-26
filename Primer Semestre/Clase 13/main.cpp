#include <iostream>
#include <string>
using namespace std;

    typedef struct 
    {
        string nombre; 
        string apellido;
        int edad ; 
        string direccion ; 
        string nif;  

    }tPersona;

        typedef struct 
    {
        string calle_principal; 
        string calle_secundaria;
        int numero_casa; 

    }tDireccion;

void imprimir (tPersona persona);
tPersona leer_datos(tPersona persona);


int main()
{
    tPersona persona1, persona2; 
    // Resivir los datos 
    persona1 = leer_datos();

    
    
    //Imprimir la info guardada 
    imprimir(persona1);

    return 0; 

}

void imprimir (tPersona persona)
{
    cout << "Los datos ingresados son: " << endl;
    cout << "Nombre: " << persona.nombre << endl; 
    cout << "Apellido: " <<persona.apellido << endl;
    cout << "Edad: "  << persona.edad << endl;
    cout << "Direccion: " << persona.direccion << endl;
    cout << "NIF: " << persona.nif << endl;
}

tPersona leer_datos()
{
    tPersona persona; 
    cout << "***** Ingresar informacion ****" << endl; 
    cout << "Nombre: "; 
    cin >> persona.nombre; 
    cout << "Apellido: ";
    cin >> persona.apellido;
    cout << "Edad: ";
    cin >> persona.edad;
    cin.sync(); 
    cout << "Direccion: ";
    getline (cin, persona.direccion);
    cout << "NIF: ";
    cin >> persona.nif;
    return persona; 
}