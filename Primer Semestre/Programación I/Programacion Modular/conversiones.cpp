#include "conversiones.h"

double valor;
double resultado;

void centigrados_Kelvin()
{
    cout << "Ingresa la temperatura en Centigrados: ";
    cin >> valor;
    resultado = valor + 273.15;
    cout << "La temperatura en Kelvin es: " << resultado << " K" << endl;
}
void libras_gramos()
{
    cout << "Ingresa el valor en Libras: ";
    cin >> valor;
    resultado = valor * 453.592;
    cout << "El valor en Gramos es: " << resultado << " g" << endl;
}

void pulgadas_centimetros()
{
    cout << "Ingresa la longitud en Pulgadas: ";
    cin >> valor;
    resultado = valor * 2.54;
    cout << "La longitud en Centimetros es: " << resultado << " cm" << endl;
}

void kilometros_millas()
{
    cout << "Ingresa la distancia en Kilometros: ";
    cin >> valor;
    resultado = valor * 0.621371;
    cout << "La distancia en Millas es: " << resultado << " mi" << endl;
}

void litros_galones()
{
    cout << "Ingresa el volumen en Litros: ";
    cin >> valor;
    resultado = valor * 0.264172;
    cout << "El volumen en Galones es: " << resultado << " gal" << endl;
}