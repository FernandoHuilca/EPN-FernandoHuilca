//Author Fernando Huilca
/*3.	Se quiere leer tres calificaciones de un alumno y determinar su promedio, si el promedio es 10, escribir en la pantalla tu promedio es A, si el promedio es 9 escribir tu promedio es B y si el promedio es 8 escribir C, de lo contrario si la calificación es menor a 8 escribir reprobado.
*/
#include <iostream>
using namespace std;
int main()
{
double nota1, nota2 , nota3, promedio; // declaro las variables que voy a recibir del usuario y las que necesito para la ejecucion

cout << "Escriba la primera calificacion: " ;
cin >> nota1;  
cout << "Escriba la segunda calificacion: " ;
cin >> nota2;
cout << "Escriba la tercera calificacion: " ;
cin >> nota3; // recibo y guardo las calificaciones

promedio = (nota1+nota2+nota3)/3; //Calculo el promedio de las tres calificaciones

    if (promedio == 10)
    
        cout << "Tu promedio es de A" << endl; 
    
    if (promedio >= 9 && promedio < 10 ) 
    
        cout << "Tu promedio es B" << endl;
    
    if (promedio >= 8 && promedio < 9)
    
        cout << "Tu promedio es C" << endl; 

    if (promedio >=0 && promedio < 8)
        cout << "REPROBADO" << endl; 
    

    return 0;
}