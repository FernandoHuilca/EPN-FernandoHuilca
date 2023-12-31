// Authores: Fernando Huilca y Mateo Quisilema
//  Programa dedicado a resolver 6 diferentes ejercicios usando Funciones
#include <iostream> 
using namespace std;
#include <fstream> 
#include <string>
#include <sstream>
#include <iomanip>
// Prototipos de Funciones
int menu();
void saludo_Ejercicio();
void ejercicio_1(); // Fernando Huilca

void ejercicio_2();
void enunciado_ejer_2();
void fin_ejercicio_2();
bool comprobar(int hora, int minuto, int segundo);

void ejercicio_3();
void enunciado_ejercicio3();
int calculo_ejercicio3(int hora, int minuto, int segundo);
void enunciado2_ejercicio3();
bool verificacion_ejercicio3(int hora, int minuto, int segundo);

void ejercicio_4(); // Fernando Huilca

void ejercicio_5();

void ejercicio_6(); // Fernando HUilca

double factorial(int n);
double potencia(double base, int exponente);
double exponencial(double x);

int opcion = 1;

int main() {
    cout << "_______BIENVENIDO A LOS EJERCICIOS DE FUNCIONES______" << endl;
    cout << "                             ~ AUTHOR Fernando Huilca" << endl;
    cout << "                             ~ AUTHOR Mateo Quisilema" << endl;
    cout << endl;
    while (opcion != 0) // Para presentar el menu varias veces
    {
        opcion = menu(); // Se muestra el menu con las opciones de cada ejercicio
        cout << endl;    // Salto de linea para mas elegancia jeje
        switch (opcion) {
        case 1:
            saludo_Ejercicio();
            ejercicio_1();
            break;
        case 2:
            saludo_Ejercicio();
            ejercicio_2();
            break;
        case 3:
            saludo_Ejercicio();
            ejercicio_3();
            break;
        case 4:
            saludo_Ejercicio();
            ejercicio_4();
            break;
        case 5:
            saludo_Ejercicio();
            ejercicio_5();
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

// FUNCIONES DEL PROGRAMA
int menu() {
    int opcion;
    do {
        cout << " ____MENU EJERCICIOS REALIZADOS____" << endl;
        cout << "|                                  |" << endl;
        cout << "|Seleccione el ejercicio que desee:|" << endl;
        cout << "|__________________________________|" << endl;
        cout << "|      Ejercicios        | Numero  |" << endl;
        cout << "|------------------------|---------|" << endl;
        cout << "| 1) Funcion Exponencial |    1    |" << endl;
        cout << "| 2) Funcion Segundo mas |    2    |" << endl;
        cout << "| 3) Tiempo en segundos  |    3    |" << endl;
        cout << "| 4) Mes por dia         |    4    |" << endl;
        cout << "| 5) Minutos en un CD    |    5    |" << endl;
        cout << "| 6) Directorio Telefono |    6    |" << endl;
        cout << "|__________________________________|" << endl;
        cout << "| 0) SALIR                    0    |" << endl;
        cout << "|__________________________________|" << endl;
        cin >> opcion;
        if (opcion < 0 || opcion > 6) {
            cout << "Opcion seleccionada INCORRECTA." << endl;
            cout << "Por favor, digite un numero entero del 0 al 6" << endl;
        }
    } while (opcion < 0 || opcion > 6);
    return (opcion);
}
void saludo_Ejercicio() {
    cout << "Bienvenido al Ejercicio " << opcion << endl;
    cout << "Autor Fernando Huilca. " << endl;
    cout << "Autor Mateo Quisilema. " << endl;
    cout << endl;
}
void ejercicio_1() {

    double x;
    cout << "Ingrese el numero que desee para calcular la funcion exponencial: ";
    cin >> x;

    double resultado = exponencial(x);
    cout << "La funcion exponencial de " << x << " es: " << resultado << endl;
    cout << endl;

}

void ejercicio_2() {
    int hora, minuto, segundo;
    bool verificacion;
    cout << "***Ingrese una hora cualquiera, de la siguiente manera***" << endl;
    cout << "La Hora en formato (24 horas):  ";
    cin >> hora;
    cout << "Los minutos:  ";
    cin >> minuto;
    cout << "Los segundos:  ";
    cin >> segundo;
    verificacion = comprobar(hora, minuto, segundo);

    if (verificacion) {

        if (segundo <= 58) {
            enunciado_ejer_2();
            cout << hora << " : " << minuto << " : " << segundo + 1 << endl;
            fin_ejercicio_2();
        }
        else {
            if ((minuto < 59) && (hora != 23)) {
                enunciado_ejer_2();
                cout << hora << " : " << minuto + 1 << " : "
                    << "00" << endl;
                fin_ejercicio_2();
            }
            else if ((minuto == 59) && (hora != 23)) {
                enunciado_ejer_2();
                cout << hora + 1 << " : "
                    << "00"
                    << " : "
                    << "00" << endl;
                fin_ejercicio_2();
            }
            else if ((minuto == 59) && (hora == 23)) {
                enunciado_ejer_2();
                cout << "00"
                    << " : "
                    << "00"
                    << " : "
                    << "00" << endl;
                fin_ejercicio_2();
            }
        }
    }
}
void enunciado_ejer_2() {
    cout << "*******************************" << endl;
    cout << "La Hora aumentada un segundo es:" << endl;
    cout << "Hora : Minuto : Segundo" << endl;
}
void fin_ejercicio_2() {
    cout << "*******************************" << endl << endl;
}
bool comprobar(int hora, int minuto, int segundo) {
    bool comprobar = true;
    if (hora < 0) {
        cout << "Recuerde que las horas son positivas" << endl << endl;
        comprobar = false;
    }
    else if (minuto < 0) {
        cout << "Recuerde que los minutos son positivos" << endl << endl;
        comprobar = false;
    }
    else if (segundo < 0) {
        cout << "Recuerde que los segundos son positivos" << endl << endl;
        comprobar = false;
    }
    else if (hora > 23) {
        cout << "Recuerde que las horas solo llegan a 23 " << endl << endl;
        comprobar = false;
    }
    else if (minuto > 59) {
        cout << "Recuerde que los minutos solo llegan hasta 59" << endl << endl;
        comprobar = false;
    }
    else if (segundo > 59) {
        cout << "Recuerde que los segundos solo llegan hasta 59" << endl << endl;
        comprobar = false;
    }
    return (comprobar);
}

void ejercicio_3() {
    int hora, minuto, segundo, sumatoria1, hora2, minuto2, segundo2, sumatoria2;
    bool verificado;
    cout << "***Ingrese la hora en el siguiente formato***" << endl;
    cout << "Ingrese la hora en fomto (12 horas): ";
    cin >> hora;
    cout << "Los minutos:  ";
    cin >> minuto;
    cout << "Los segundos:  ";
    cin >> segundo;
    verificado = verificacion_ejercicio3(hora, minuto, segundo);

    if (verificado) {
        enunciado_ejercicio3();
        sumatoria1 = calculo_ejercicio3(hora, minuto, segundo);
        cout << sumatoria1 << endl;

        enunciado2_ejercicio3();
        cout << "Ingrese la hora en fomto (12 horas): ";
        cin >> hora2;
        cout << "Los minutos:  ";
        cin >> minuto2;
        cout << "Los segundos:  ";
        cin >> segundo2;

        verificado = verificacion_ejercicio3(hora2, minuto2, segundo2);
        if (verificado) {
            sumatoria2 = calculo_ejercicio3(hora2, minuto2, segundo2);

            if ((sumatoria1 - sumatoria2) < 0) {
                cout << "Los segundos trancurridos entre ambas horas son: "
                    << (sumatoria1 - sumatoria2) * -1 << endl
                    << endl;
            }
            else {
                cout << "Los segundos trancurridos entre ambas horas son: "
                    << (sumatoria1 - sumatoria2) << endl
                    << endl;
            }
        }
    }
}
void enunciado_ejercicio3() {
    cout << "*****************************************************************"
        << endl;
    cout << "Los segundos transcurridos desde la ultima vez que fue las 12 son:"
        << endl;
    cout << "*****************************************************************"
        << endl;
}
void enunciado2_ejercicio3() {
    cout << "*******************************************************************"
        << endl;
    cout << "Ingrese una nueva hora para calcular los segundos entre ambas horas:"
        << endl;
    cout << "*******************************************************************"
        << endl;
}
int calculo_ejercicio3(int hora, int minuto, int segundo) {
    int sumatoria;
    if (hora == 12) {
        sumatoria = segundo + (minuto * 60);
    }
    else {
        sumatoria = segundo + (minuto * 60) + (hora * 3600);
    }
    return (sumatoria);
}
bool verificacion_ejercicio3(int hora, int minuto, int segundo) {
    bool comprobar = true;
    if (hora < 0) {
        cout << "Recuerde que las horas son positivas" << endl << endl;
        comprobar = false;
    }
    else if (minuto < 0) {
        cout << "Recuerde que los minutos son positivos" << endl << endl;
        comprobar = false;
    }
    else if (segundo < 0) {
        cout << "Recuerde que los segundos son positivos" << endl << endl;
        comprobar = false;
    }
    else if (hora > 13) {
        cout << "Recuerde que las horas solo llegan a 12 " << endl << endl;
        comprobar = false;
    }
    else if (minuto > 59) {
        cout << "Recuerde que los minutos solo llegan hasta 59" << endl << endl;
        comprobar = false;
    }
    else if (segundo > 59) {
        cout << "Recuerde que los segundos solo llegan hasta 59" << endl << endl;
        comprobar = false;
    }
    return (comprobar);
}

void ejercicio_4() {
    int dia_anio = -1;
    while (dia_anio < 1 || dia_anio > 365) // Para verificar si el usuario esta
        // ingresando el numero correcto
    {
        cout << "Introduzca un numero del 1 al 365" << endl;
        cin >> dia_anio;
        if (dia_anio < 1 || dia_anio > 365) {
            cout << "Lamentablemente, el numero que has ingresado es incorrecto."
                << endl;
            cout << "Por favor introduzce un valor numerico que se encuentre dentro "
                "del rango establecido,"
                << " el cual abarca desde 1 hasta 365. " << endl;
            cout << endl;
        }
        else {
            if (dia_anio <= 31)
                cout << "El numero que ingresaste pertenece al mes de ENERO. " << endl;
            else if (dia_anio <= 59)
                cout << "El numero que ingresaste pertenece al mes de FEBRERO. "
                << endl;
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
                cout << "El numero que ingresaste pertenece al mes de SEPTIEMBRE. "
                << endl;
            else if (dia_anio <= 304)
                cout << "El numero que ingresaste pertenece al mes de OCTUBRE. "
                << endl;
            else if (dia_anio <= 334)
                cout << "El numero que ingresaste pertenece al mes de NOVIEMBRE. "
                << endl;
            else
                cout << "El numero que ingresaste pertenece al mes de DICIEMBRE. "
                << endl;

            cout << endl; // Salto de linea para mas elegancia
        }
    }
}
void ejercicio_5() {
    ofstream archivo;

    archivo.open("songs.txt");
    if (archivo.fail()) {
        cout << "No se pudo abrir el archivo";
    }
    else {
        archivo << "Numero de   " << "Tiempo de la cancion   " << "   Tiempo total   " << endl;
        archivo << "cancion     " << "Minutos     segundos   " << "Minutos   Segundos" << endl;
        archivo << "-------     " << "-------     -------    " << "-------   ------- " << endl;

        int centinela, segundos, minutos, iterador = -1;
        int segundos1 = 0, minutos1 = 0, i = 1, sumamin = 0, sumaseg = 0;

        while (iterador != 0) {
            cout << "Ingrese el tiempo de la cancion en segundos: ";
            cin >> segundos;
            archivo << left << setw(12) << i;
            minutos1 = (segundos / 60);
            segundos1 = segundos % 60;
            sumamin = sumamin + minutos1;
            sumaseg = sumaseg + segundos1;
            if (sumaseg > 59) {
                sumamin = sumamin + 1;
                sumaseg = sumaseg - 60;
            }
            archivo << left << setw(12) << minutos1;
            archivo << left << setw(11) << segundos1;
            archivo << left << setw(10) << sumamin;
            archivo << sumaseg << endl;

            cout << "Desea ingresar una nueva cancion: " << endl;
            cout << "1. SI: " << endl;
            cout << "0. NO: " << endl;
            cin >> iterador;
            cout << endl;
            i++;
        }
        archivo << "Hay " << 79 - sumamin << " minutos y " << 60 - sumaseg
            << " segundos "
            << "de espacio restante en el CD DE 80 minutos" << endl;
    }
    archivo.close();
}

void ejercicio_6()
{
    /*6.	Escriba un programa simple de directorio telefónico en C++ que busque números en un archivo que contenga una lista de nombres y números telefónicos. Se debe indicar al usuario que introduzca el nombre y el apellido de una persona, y el programa produce entonces el número correspondiente o indica que el nombre no está en el directorio. Después de cada búsqueda, el programa debe preguntar al usuario si quiere buscar otro número y luego repetir el proceso o salir del programa. Los datos del archivo deben estar organizados de modo que cada línea contenga un nombre, un apellido y un número telefónico, separados por espacios en blanco. Puede volver al comienzo del archivo cerrándolo o abriéndolo de nuevo. Codifique la solución con funciones según sea apropiado. El resultado debe tener un formato claro y nítido y los mensajes de error deben ser informativos. No Utilizar arreglos ni estructuras.*/
    cin.ignore();
    char opcion = 'y';
    while (opcion != 'n')
    {
        string nombre, name, apellido, phone;
        cout << "Ingrese el nombre de la persona que desee conocer el numero " << endl;
        getline(cin, nombre);
        ifstream leerArchivo;
        leerArchivo.open("directorio.txt");
        if (!leerArchivo.is_open())
        {
            cout << "Archivo NO abierto " << endl;
        }
        else
        {
            while (name != "x")
            {
                leerArchivo >> name;
                leerArchivo >> apellido;
                leerArchivo >> phone;

                if (nombre == name + " " + apellido)
                {
                    cout << "El numero telefonico de " << nombre << ": " << phone << endl;
                    leerArchivo.close();
                    break;
                }
                if (name == "x")
                {
                    cout << "El nombre " << nombre << " no se encuentra dentro del directorio." << endl;
                    leerArchivo.close();

                }
            }



        }
        cout << "Desea seguir buscando? si (y) no (n): ";
        cin >> opcion;
        cin.ignore();

    }
    cout << "Gracias por ocupar el ejercicio 6. Adios. " << endl;
    cout << endl;

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