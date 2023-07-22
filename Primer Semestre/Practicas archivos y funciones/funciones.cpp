//Author Fernando Huilca 
// Programa dedicado a resolver 6 diferentes ejercicios 
#include <iostream> 
using namespace std; 
#include <fstream> 
#include <iomanip>
//Prototipos de Funciones  
int menu ();
void saludo_Ejercicio();
void ejercicio_4();

int opcion = 1;

int main ()
{
    cout << "_______BIENVENIDO A LOS EJERCICIOS DE FUNCIONES______" << endl; 
    cout << "                             ~ AUTHOR FERNANDO HUILCA" << endl;
    cout << endl; 
    while (opcion != 0) // Para presentar el menu varias veces 
    {
        opcion = menu(); // Se muestra el menu con las opciones de cada ejercicio
        cout << endl; // Salto de linea para mas elegancia jeje
        switch (opcion)
        {
        case 1:
            saludo_Ejercicio(); 
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
            break;
        

        }


    }
    cout << "Adios. " << endl;
    return 0;
 }

//FUNCIONES DEL PROGRAMA
 int menu ()
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
    }
    while (opcion < 0 || opcion > 6); 
    return opcion; 
 }
 void saludo_Ejercicio()
 {
    cout << "Bienvenido al Ejercicio " << opcion << endl; 
    cout << "Autor Fernando Huilca. " << endl; 
    cout << endl;
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


