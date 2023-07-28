//Author Fernando Huilca
/*4.	Se requiere calcular el peso total de un arca, donde el usuario indica el número de animales de cada especie, y el peso de estos, de la siguiente lista de animales: León, Elefante, perro, gato, paloma.
*/
#include <iostream>
using namespace std;
int main()
{
int num_leon, num_elefante, num_perro, num_gato, num_paloma; 
double peso_leon, peso_elefante, peso_perro, peso_gato, peso_paloma; 
double peso_total; 

cout << "¿Cual es el numero de leones? " ; 
cin >> num_leon;
cout << "¿Cual es el peso de cada leon en kilogramos? " ; 
cin >> peso_leon;
cout << "¿Cual es el numero de elefantes? " ; 
cin >> num_elefante;
cout << "¿Cual es el peso de cada elefante en kilogramos? " ; 
cin >> peso_elefante;
cout << "¿Cual es el numero de perros? " ; 
cin >> num_perro;
cout << "¿Cual es el peso de cada perro en kilogramos? " ; 
cin >> peso_perro;
cout << "¿Cual es el numero de gatos? " ; 
cin >> num_gato;
cout << "¿Cual es el peso de cada gato en kilogramos? " ; 
cin >> peso_gato;
cout << "¿Cual es el numero de palomas? " ; 
cin >> num_paloma;
cout << "¿Cual es el peso de cada paloma en kilogramos? " ; 
cin >> peso_paloma;

peso_total= (num_leon * peso_leon) + (num_elefante * peso_elefante) + (num_perro * peso_perro) + (num_gato * peso_gato) + (num_paloma * peso_paloma);

cout << "El peso total del arca con los animales de cada especie es de " << peso_total << " kilogramos " << endl; 

    return 0;
}