// Author Fernando Huilca 
/*Realizar un programa que lea los datos personales que hay en el archivo "datos.txt" (Antes de codificar crear el archivo)): 
nombre y apellido, edad, teléfono y dirección. 
Mediante un menú le pregunte al usuario que dato desea conocer, este menú debe seguirse presentando hasta que el usuario lo desee.
Formato del archivo datos.txt:
---
Jennifer López
25
0912345678
Toledo y Madrid
-1
---
Pista
Se podría controlar mediante la opción Salir ejemplo:

Ingrese la opción del dato que desea conocer:
1. Nombres
2. Edad
3. Telefono
4. Dirección
0. Salir*/

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

int menu();

int main()
{
    int desicion = -1, edad;
    char aux;
    string fullname, direccion;
    int telefono;
    ifstream leerArchivo;

    cout << "Bienvenido" << endl;
    leerArchivo.open("datos.txt");
    if (!leerArchivo.is_open())
    {
        cout << "Archivo no abierto." << endl;
    }
    else
    {
        getline(leerArchivo, fullname);
        leerArchivo >> telefono;
        leerArchivo.get(aux);
        leerArchivo >> edad;
        leerArchivo.get(aux);
        getline(leerArchivo, direccion);
    

        while (desicion != 0)
        {
            desicion = menu();

            if (desicion >= 0 && desicion < 5)
            {
                switch (desicion)
                {
                case 1:
                    cout << fullname << endl;
                    break;
                case 2:
                    cout << edad << endl;
                    break;
                case 3:
                    cout << telefono << endl;
                    break;
                case 4:
                    cout << direccion << endl;
                    break;
                case 0:
                    cout << "FIN DEL PROGRAMA!!" << endl;
                    break;
                }
            }
            else
            {
                cout << "Opcion fuera de los limites, intente nuevamente" << endl;
            }
        }
    }
    leerArchivo.close();
    return 0;
}

int menu()
{
    int opcion;
    cout << "______MENU______" << endl;
    cout << "Seleccione que dato desea conocer: " << endl;
    cout << "1. Nombre" << endl;
    cout << "2. Edad" << endl;
    cout << "3. Telefono" << endl;
    cout << "4. Direccion" << endl;
    cout << "0. Salir" << endl;
    cout << "Ingrese el numero de eleccion: ";
    cin >> opcion;
    return opcion;
}