#include <iostream> 
using namespace std;
#include <iostream>
#include <iomanip> 



//aqui van las estructuas 
typedef struct 
{
    string nombre;
    string apellidos; 
    int edad ;
    string dirreccion ;
    string nif ;  

}tPersona;



void imprimir (tPersona persona);

int main ()
{
    tPersona persona1, persona2; 
    cout << "**********Informacion Personal **************** " << endl; 
    cout << "Escriba el nombre de la persona: ";
    cin >> persona1.nombre; 
    cout << "Escriba el apellido de la persona: ";
    cin >> persona1.apellidos; 
    cout << "Escriba el edad de la persona: ";
    cin >> persona1.edad; 
    cin.ignore();
    cout << "Escriba el dirreccion de la persona: ";
    getline(cin, persona1.dirreccion);
    cout << "Escriba el nif de la persona: ";
    cin >> persona1.nif;

    imprimir(persona1);








}

void imprimir (tPersona persona)
{
    cout << "Los datos ingresados son: " << endl; 
    cout << "el nombre es " << persona.nombre << endl; 
    cout << "el apellido es " << persona.apellidos << endl; 
    cout << "el edad es " << persona.edad << endl; 
    cout << "el dirreccion es " << persona.dirreccion << endl; 
    cout << "el nif es " << persona.nif << endl; 
}