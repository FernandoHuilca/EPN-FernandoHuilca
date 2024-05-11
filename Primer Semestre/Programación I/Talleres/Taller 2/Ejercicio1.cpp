//Author Fernando Huilca
/*1. Escriba un programa que lea los números de un archivo datos.txt (cada línea contiene un número real positivo) y muestre en la pantalla el mayor, el menor y la mediana de todos ellos. El archivo termina con un 0 como centinela. */
#include <iostream> 
using namespace std;
#include <fstream> // Para usar leer files (carpetas)

int main()
{
    double numero, anterior = 0, maximo = 0, minimo = 0;
    double a, b, c;
    int i = 1;

    ifstream archivo; //ifstream para ingresar datos
    archivo.open("archivo.txt"); //para abrir el archivo de nombre archivo.txt
    if (!archivo.is_open()) //con esto verificamos si se abrio o no el archivo
    {
        cout << "No se pudo abrir el archivo" << endl; //en caso de que no se habra 
    }
    else // en caso de que el archivo si lo hallamos abierto 
    {
        //Calculo de la mediana
        archivo >> a >> b >> c;
        if (a > b)
        {
            if (a > c)
            {
                if (b > c)
                {
                    cout << "La mediana de " << a << " " << b << " y " << c << " es: " << b << endl;
                }
                else
                {
                    cout << "La mediana de " << a << " " << c << " y " << b << " es: " << c << endl;
                }
            }
            else
            {
                cout << "La mediana de " << c << " " << a << " y " << b << " es: " << a << endl;
            }
        }
        else
        {
            if (b > c)
            {
                if (c > a)
                {
                    cout << "La mediana de " << b << " " << c << " y " << a << " es: " << c << endl;
                }
                else
                {
                    cout << "La mediana de " << b << " " << a << " y " << c << " es: " << a << endl;
                }
            }
            else
            {
                cout << "La mediana de " << c << " " << b << " y " << a << " es: " << b << endl;
            }
        }
        archivo.close();

        //Para determinar maximo y minimo

        ifstream archivo; //ifstream para ingresar datos
        archivo.open("archivo.txt"); //para abrir el archivo de nombre archivo.txt
        if (!archivo.is_open()) //con esto verificamos si se abrio o no el archivo
        {
            cout << "No se pudo abrir el archivo" << endl; //en caso de que no se habra 
        }
        else // en caso de que el archivo si lo hallamos abierto 
        {
        archivo >> numero;
        while (numero != 0)
        {
            if ((numero > maximo) && i == 1)
            {
                maximo = numero;
                minimo = numero;
            }

            else if (numero > maximo)
            {
                maximo = numero;
            }
            else if (numero < minimo)
            {
                minimo = numero;
            }
            i++;
            archivo >> numero;

        }
        }

        cout << "El menor de los numeros es " << minimo << endl;
        cout << "El mayor de los numeros es " << maximo << endl;

        archivo.close();
    }

    return 0;
}