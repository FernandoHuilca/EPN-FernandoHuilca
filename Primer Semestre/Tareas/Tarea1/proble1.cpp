//Author Fernando Huilca
/*El problema consiste en un profesor quiere un programa para ingresar N calificaciones, se le preguntará al usuario, después mostrará el promedio de estas, la más baja y la más alta.*/
#include <iostream>
using namespace std; 
int main ()
{
    int numcalifica, contador=1 ;
    double notas=0, sumatoria=0, anterior=0, mayor, menor;

cout << "Cual es el numero de calificaciones que piensa ingresar? " << endl; 
cin  >> numcalifica;
while (contador <= numcalifica)
{
    cout <<  "Ingrese la calificacion numero " << contador << ": " ;
    cin >> notas;
    if (notas > anterior)
        mayor = notas;  
    else 
        mayor = anterior; 

    if (notas < anterior)
    menor = notas;
    else 
    menor = anterior;

    anterior = notas;
    
    sumatoria += notas;
    ++contador;
}
cout << "El promedio de las notas ingresadas es " << sumatoria/numcalifica << endl; 
cout << "La nota mas alta es " << mayor << endl; 
cout << "La nota mas baja es " << menor << endl; 

    return 0;
}