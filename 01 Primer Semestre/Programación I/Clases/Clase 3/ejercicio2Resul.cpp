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
    cout << "Ingrese su usuario: " << endl; 
    cin >> username; 
    cout << "Ingrese su contraseña: " << endl; 
    cin >> password;

    if (username == usuario)
    {
            if (password == clave) {
                cout << "Biembenido"; 
            }
            else {
                cout << "usuario incorrecto";
            }
    {
    else 
    {
        cout << "Usuario incorrecto";
    }
   

    return 0;
}