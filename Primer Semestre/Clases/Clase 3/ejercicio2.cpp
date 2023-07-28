// Autor: Fernando Huilca 
// Programa para practicar while
/*Preguntar al usuario que nos increse un usuario y una contraseña*/
// tablas de verdad y es verdad si ambas verdad
#include <iostream>
#include <string> 
using namespace std; 

int main ()
{
    string usuario = "nombre", clave = "1234", username, password;
    
    int limite = 3, intentos = 1;
    bool acceso = false;
    while (intentos <= 3 && !acceso) // Se detiene hasta que la condicion sea falsa 
    {
        cout << "Ingrese su usuario: " << endl; 
    cin >> username; 
    cout << "Ingrese su contraseña: " << endl; 
    cin >> password;
    if (username == usuario && password == clave)
    {  
        cout << "BIENVENIDO!!" ;
        //breack -no es recomendado usar 
        acceso = true; 
    }
    else {
        cout << "Su usuario y contraseña son incorrectos" << endl;
        intentos++;
    }
    }
    // cout << "No tienes mas intentos." << endl; 

    return 0;
}
