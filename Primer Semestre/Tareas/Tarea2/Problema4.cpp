//Author Fernando Huilca
/*4.	Desarrolla un conversor de medidas anglosajonas a internacionales. El programa leerá un número real seguido 
de un espacio y una letra. La letra indicará la medida que se quiere convertir (p pulgadas; m  millas; f  grados
 Fahrenheit; g  galones líquidos; o  onzas; l libras). Mostrará la cantidad en la nueva unidad seguida de un
  espacio y otras letras representando la nueva unidad (respectivamente, cm  centímetros; m  metros; c  grados 
  Celsius; l litros; gr  gramos; kg  kilogramos). Definir los factores de conversión como constantes.*/
#include <iostream>
using namespace std; 

int main() 
{
        setlocale(LC_ALL, "es_ES.UTF_8");
    double a; 
    char unidad; 
    const double pul_met=0.0254, mill_m=1609.344, gal_lit=3.7854117, onz_lit=0.0296, lib_kg=0.453592;
    cout << "Conversor de medidas anglosajonas a internacionales." << endl; 
    cout << "Escriba la medida que desea transformar junto con su udidad:" ;
    cout << " \n Pulgadas (p) \n Millas (m) \n Grados Fahrenheit(f) \n Galones liquidos (g) \n Onzas (o) \n libras (l)" << endl;
    cin >> a >> unidad; 
    switch (unidad)
    {
    case 'p': 
        cout << "Su medida en el sistema internacional es "<< a*pul_met << " metros"; 
        break;
    case 'm': 
        cout << "Su medida en el sistema internacional es "<<  a*mill_m<< " metros"; 
        break;
    case 'f': 
        cout << "Su medida en el sistema internacional es "<<  ( a - 32) * 5/9 + 273.15  << " kelvin"; 
        break;
    case 'g': 
        cout << "Su medida en el sistema internacional es "<<  a*gal_lit<< " litros"; 
        break;
    case 'o': 
        cout << "Su medida en el sistema internacional es "<<  a*onz_lit << " litros"; 
        break;
    case 'l': 
        cout << "Su medida en el sistema internacional es "<<  a*lib_kg << " litros"; 
        break;
    default:
        cout << "Su unidad está mal seleccionanda" << endl ; 
        break;
    }
    return 0;
}
