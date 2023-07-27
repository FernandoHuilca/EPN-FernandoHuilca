//Author Fernando Huilca y Mateo Quisilema
// Programa dedicado a resolver 6 diferentes ejercicios usando Funciones
#include <iostream> 
using namespace std;
#include <fstream> 
#include <string>
#include <sstream>
#include <iomanip>

//Prototipos de Funciones  
int menu();
void saludo_Ejercicio();
void ejercicio_1(); // Fernando Huilca
void ejercicio_2();
void ejercicio_3();
void ejercicio_4(); //Fernando Huilca
void ejercicio_5();
void ejercicio_6(); // Fernando HUilca

//Para ejercicio 4
double factorial(int n);
double potencia(double base, int exponente);
double exponencial(double x);

//Para ejercicio 6 
string nombre();
void busqueda(string nombre);

int opcion = 1;

int main()
{
    cout << "_______BIENVENIDO A LOS EJERCICIOS DE FUNCIONES______" << endl;
    cout << "                             ~ AUTHOR Fernando Huilca" << endl;
    cout << "                             ~ AUTHOR Mateo Quisilema" << endl;
    cout << endl;
    while (opcion != 0) // Para presentar el menu varias veces 
    {
        opcion = menu(); // Se muestra el menu con las opciones de cada ejercicio
        cout << endl; // Salto de linea para mas elegancia jeje
        switch (opcion)
        {
        case 1:
            saludo_Ejercicio();
            ejercicio_1();
            break;
        case 2:
            saludo_Ejercicio();
            break;
        case 3:
            saludo_Ejercicio();
            break;
        case 4:
            saludo_Ejercicio();
            ejercicio_4();
            break;
        case 5:
            saludo_Ejercicio();
            break;
        case 6:
            saludo_Ejercicio();
            ejercicio_6();
            break;


        }


    }
    cout << "Adios. " << endl;
    return 0;
}

//FUNCIONES DEL PROGRAMA
int menu()
{
    int opcion;
    do
    {
        cout << " ____MENU EJERCICIOS REALIZADOS____" << endl;
        cout << "|                                  |" << endl;
        cout << "|Seleccione el ejercicio que desee:|" << endl;
        cout << "|__________________________________|" << endl;
        cout << "|      Ejercicios        | Numero  |" << endl;
        cout << "|------------------------|---------|" << endl;
        cout << "| 1) Funcion Exponencial |    1    |" << endl;
        cout << "| 2) Ejercicio           |    2    |" << endl;
        cout << "| 3) Ejercicio           |    3    |" << endl;
        cout << "| 4) Mes por dia         |    4    |" << endl;
        cout << "| 5) Ejercicio           |    5    |" << endl;
        cout << "| 6) Ejercicio           |    6    |" << endl;
        cout << "|__________________________________|" << endl;
        cout << "| 0) SALIR                    0    |" << endl;
        cout << "|__________________________________|" << endl;
        cin >> opcion;
        if (opcion < 0 || opcion > 6)
        {
            cout << "Opcion seleccionada INCORRECTA." << endl;
            cout << "Por favor, digite un numero entero del 0 al 6" << endl;
        }
    } while (opcion < 0 || opcion > 6);
    return opcion;
}
void saludo_Ejercicio()
{
    cout << "Bienvenido al Ejercicio " << opcion << endl;
    cout << "Autor Fernando Huilca. " << endl;
    cout << "Autor Mateo Quisilema. " << endl;
    cout << endl;
}
void ejercicio_1()
{
    /*1.	Realice un programa que calcule la función exponencial de un número mediante la serie de Taylor:

    Para ello el programa preguntará al usuario el número “x” con el que desea realizar el cálculo de la función exponencial y luego se realizará mediante la suma de los 10 primeros elementos de la serie, codificando tres funciones: exponencial, factorial y potencia.
    */
    double x;
    cout << "Ingrese el número que desee para calcular la función exponencial: ";
    cin >> x;

    double resultado = exponencial(x);
    cout << "La función exponencial de " << x << " es: " << resultado << endl;
    cout << endl;


}

void ejercicio_2()
{

}
void ejercicio_3()
{

}
void ejercicio_4()
{
    /*4.	Escribir un programa en C++ que tome un número en el intervalo de 1 a 365 como entrada. El número representa el día del año. El programa produce después el nombre del mes (suponga que el año no es bisiesto). Esto se puede hacer comparando el día del año con el número de días en el año que preceden el inicio de cada mes. Por ejemplo, 59 días preceden a marzo, que tiene 31 días. Así que, si el día del año está en el intervalo de 60 a 91, entonces su programa produciría marzo. El programa debe producir un mensaje de error si el número introducido no está en el intervalo requerido. El indicador y el mensaje de error deben aclarar al usuario cómo se debe introducir el número. Asegúrese de usar el formato y comentarios apropiados en su código. El resultado se debe marcar con claridad y tener un formato nítido.*/
    int dia_anio = -1;
    while (dia_anio < 1 || dia_anio > 365) //Para verificar si el usuario esta ingresando el numero correcto 
    {
        cout << "Introduzca un numero del 1 al 365" << endl;
        cin >> dia_anio;
        if (dia_anio < 1 || dia_anio > 365)
        {
            cout << "Lamentablemente, el numero que has ingresado es incorrecto." << endl;
            cout << "Por favor introduzce un valor numerico que se encuentre dentro del rango establecido,"
                << " el cual abarca desde 1 hasta 365. " << endl;
            cout << endl;
        }
        else
        {
            if (dia_anio <= 31)
                cout << "El numero que ingresaste pertenece al mes de ENERO. " << endl;
            else if (dia_anio <= 59)
                cout << "El numero que ingresaste pertenece al mes de FEBRERO. " << endl;
            else if (dia_anio <= 90)
                cout << "El numero que ingresaste pertenece al mes de MARZO. " << endl;
            else if (dia_anio <= 120)
                cout << "El numero que ingresaste pertenece al mes de ABRIL. " << endl;
            else if (dia_anio <= 151)
                cout << "El numero que ingresaste pertenece al mes de MAYO. " << endl;
            else if (dia_anio <= 181)
                cout << "El numero que ingresaste pertenece al mes de JUNIO. " << endl;
            else if (dia_anio <= 212)
                cout << "El numero que ingresaste pertenece al mes de JULIO. " << endl;
            else if (dia_anio <= 243)
                cout << "El numero que ingresaste pertenece al mes de AGOSTO. " << endl;
            else if (dia_anio <= 273)
                cout << "El numero que ingresaste pertenece al mes de SEPTIEMBRE. " << endl;
            else if (dia_anio <= 304)
                cout << "El numero que ingresaste pertenece al mes de OCTUBRE. " << endl;
            else if (dia_anio <= 334)
                cout << "El numero que ingresaste pertenece al mes de NOVIEMBRE. " << endl;
            else
                cout << "El numero que ingresaste pertenece al mes de DICIEMBRE. " << endl;

            cout << endl; // Salto de linea para mas elegancia
        }
    }


}
void ejercicio_5()
{

}
void ejercicio_6()
{
    /*6.	Escriba un programa simple de directorio telefónico en C++ que busque números en un archivo que contenga una lista de nombres y números telefónicos. Se debe indicar al usuario que introduzca el nombre y el apellido de una persona, y el programa produce entonces el número correspondiente o indica que el nombre no está en el directorio. Después de cada búsqueda, el programa debe preguntar al usuario si quiere buscar otro número y luego repetir el proceso o salir del programa. Los datos del archivo deben estar organizados de modo que cada línea contenga un nombre, un apellido y un número telefónico, separados por espacios en blanco. Puede volver al comienzo del archivo cerrándolo o abriéndolo de nuevo. Codifique la solución con funciones según sea apropiado. El resultado debe tener un formato claro y nítido y los mensajes de error deben ser informativos. No Utilizar arreglos ni estructuras.*/
    string name = "Bob";
    nombre();
    busqueda(name);


}


double factorial(int n) {
    if (n == 0)
        return 1;
    else
        return n * factorial(n - 1);
}

double potencia(double base, int exponente) {
    double resultado = 1;
    for (int i = 0; i < exponente; i++) {
        resultado *= base;
    }
    return resultado;
}

double exponencial(double x) {
    double suma = 0;
    for (int n = 0; n < 10; n++) {
        double resul = potencia(x, n) / factorial(n);
        suma += resul;
    }
    return suma;
}


string nombre()
{
    string full_name;
    cout << "Introduzca el nombre y apellido de la persona " << endl;
    //cin >> full_name;
    getline(cin, full_name);  
    cout << "El nombre de la persona es: " << full_name << endl;

    return full_name;
}

void busqueda(string nombre)
{
    ifstream leerArchivo;
    leerArchivo.open("directorio.txt");
    if (!leerArchivo.is_open())
    {
        cout << "Archivo no abierto." << endl;
        return;
    }

    string linea;
    while (getline(leerArchivo, linea))
    {
        // Leer el nombre y el número telefónico de la línea
        string nombre_archivo, numero_telefono;
        istringstream iss(linea);
        iss >> nombre_archivo >> numero_telefono;

        // Comparar el nombre con el nombre del archivo (considerar mayúsculas y minúsculas)
        if (nombre == nombre_archivo)
        {
            cout << "Número de teléfono de " << nombre << ": " << numero_telefono << endl;
            return; // Terminar la búsqueda si se encuentra el nombre
        }
    }

    cout << "Nombre no encontrado en el directorio." << endl;
}





