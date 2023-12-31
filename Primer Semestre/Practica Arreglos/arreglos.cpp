// Author Fernando Huilca y Alison Betancourt 
// Programa dedicado a resolver 4 diferentes ejercicios usando Arreglos
#include <iostream> 
using namespace std;
#include <string> 
#include <iomanip> 
#include <random> //para ejercicio 4
const int DIM_4 = 11;
const int DMDigitos = 10;//para ejercicio 2
// Prototipos de Funciones
int menu();
void saludo_Ejercicio(int opcion);
void imprimir_doubles(const double array[], int DIM);
void imprimir_validio(const double array[], int contador);
void ejercicio_1();
char menuEje1();
void ejercicio_2();
void invertir(int digitos_invertidos[], int DMDigitos);
void es_palindromo(int digitos_invertidos[], int digitos[], int i);
void ejercicio_3();
const int MAX = 20;//para ejercicio 3
void ejercicio_4();
int aleatorios(); // para ejercicio 4 
//Funcion para buscar en un arreglo recibe array y contador 
void buscado(double array[], int contador);
void agregar(double array[], int& contador);
void eliminar(double array[], int& contador);
//Funcion para dibujar diagrama de barras
void dibujar_diagrama_barras(const int datos[], int tamano);


/****************************************************************************************/

int main() {
    // Encabezado:
    cout << "                      BIENVENIDO A LOS EJERCICIOS DE FUNCIONES" << endl;
    cout << setw(54) << right << "~ AUTHOR Fernando Huilca" << endl;
    cout << setw(54) << right << "~ AUTHOR Alison Betancourt" << endl;
    cout << endl;
    int opcion = 1;
    while (opcion != 0) // Para presentar el menu varias veces
    {
        opcion = menu(); // Se muestra el menu con las opciones de cada ejercicio
        cout << endl;    // Salto de linea para mejor visualizacion
        switch (opcion) {
        case 1:
            saludo_Ejercicio(opcion);
            ejercicio_1();

            break;
        case 2:
            saludo_Ejercicio(opcion);
            ejercicio_2();
            break;
        case 3:
            saludo_Ejercicio(opcion);
            ejercicio_3();
            break;
        case 4:
            saludo_Ejercicio(opcion);
            ejercicio_4();

            break;
        }
    }
    cout << "Adios. " << endl;
    return 0;
}
/****************************************************************************************/

// FUNCIONES DEL PROGRAMA
int menu() {
    int opcion;
    do {
        cout << setw(41) << right << "MENU EJERCICIOS REALIZADOS" << endl;
        cout << setw(40) << right << "-------------------------" << endl;
        cout << endl;
        cout << "1. Calificaciones" << endl;
        cout << "2. Palindromo" << endl;
        cout << "3. Duplicados" << endl;
        cout << "4. Dados" << endl;
        cout << "0. Salir" << endl;
        cout << endl;
        cout << "Ingrese una opcion: ";

        cin >> opcion;
        if (opcion < 0 || opcion > 4) {
            cout << "Opcion seleccionada INCORRECTA." << endl;
            cout << "Por favor, digite un numero entero del 0 al 4" << endl;
        }
    } while (opcion < 0 || opcion > 4);
    return (opcion);
}
void saludo_Ejercicio(int opcion) {
    cout << "Bienvenido al ejericio " << opcion << endl;
    cout << "~ Autor Fernando Huilca. " << endl;
    cout << "~ Autor Alison Betancourt. " << endl;
    cout << endl;
}




void ejercicio_1()
{
    /*1.	Calificaciones Realizar un programa que permita ingresar un número determinado de calificaciones (max 50),
    donde el usuario decida cuando terminar de ingresar calificaciones. Además, usando los diferentes algoritmos permita,
     buscar, eliminar e insertar dichas calificaciones.*/

    int const DIM_1 = 50;
    int contador = 0;
    double nota;
    char desicion;
    double calificaciones[DIM_1] = { 0 };
    cout << "Ingrese la calificaion" << endl;
    cout << "Ingrese -1 para salir " << endl;
    cout << "Calificacion " << contador + 1 << ": ";
    cin >> nota;
    while (nota != -1 && contador < DIM_1)
    {
        calificaciones[contador] = nota;
        contador++;

        if (contador == 50)
        {
            cout << "Ya no puede ingresar mas calificaciones, llego al limite de 50." << endl;
        }
        else
        {
            cout << "Calificacion " << contador + 1 << ": ";
            cin >> nota;
        }
    }
    if (contador != 0)
    {
        do
        {
            desicion = menuEje1();
            switch (desicion) {
            case 'a':
                buscado(calificaciones, contador);
                break;
            case 'b':
                eliminar(calificaciones, contador);
                break;
            case 'c':
                agregar(calificaciones, contador);
                break;
            case 'd':
                imprimir_validio(calificaciones, contador);
                break;
            case 'e':
                imprimir_doubles(calificaciones, DIM_1);
                break;

            }

        } while (desicion != 'x' && desicion != 'X');
    }

    cout << endl;
    cout << "Adios." << endl;
    cout << endl;
}

void imprimir_validio(const double array[], int contador)
{
    for (int i = 0; i < contador; i++)
    {
        cout << "Calificacion " << i + 1 << ": " << array[i] << endl;
    }
}

char menuEje1()
{
    char opcion;
    do {
        cout << setw(41) << right << "MENU OPCIONES CALIFICACIONES" << endl;
        cout << setw(39) << right << "-------------------------" << endl;
        cout << endl;
        cout << "a. Busca calificaciones" << endl;
        cout << "b. Eliminar alguna calificacion" << endl;
        cout << "c. Agregar calificacion nueva" << endl;
        cout << "d. Mostrar arreglo valido" << endl;
        cout << "e. Mostrar arreglo completo " << endl;
        cout << "x. Salir" << endl;
        cout << endl;
        cout << "Ingrese una opcion: ";

        cin >> opcion;
        if (opcion != 'a' && opcion != 'b' && opcion != 'c' && opcion != 'd' && opcion != 'e' && opcion != 'x') {
            cout << "Opcion seleccionada INCORRECTA." << endl;
            cout << "Por favor, digite una letra de las opciones" << endl;
            cout << endl;
        }
    } while (opcion != 'a' && opcion != 'b' && opcion != 'c' && opcion != 'd' && opcion != 'e' && opcion != 'x');
    return opcion;
}


void buscado(double array[], int contador)
{
    double buscado;
    cout << "Escriba la calificacion que desea buscar: ";
    cin >> buscado;
    cout << "Se muestran todas las posiciones en las que se encuentra la calificaion: " << endl;
    bool encontrado = false;
    for (int i = 0; i < contador; i++)
    {
        if (buscado == array[i])
        {
            cout << "La calificacion buscada esta en la posicion: " << i + 1 << endl;
            encontrado = true;
        }
    }
    if (!encontrado)
    {
        cout << "La calificacion ingresada no se encuentra en el listado." << endl;
    }
    cout << endl; // para que quede bonito jeje 

}

void ejercicio_2()
{
    /*2. Palíndromo. Dado un número entero positivo, 𝑛, determine si se trata de un palíndromo o no. Pista: utilice dos arreglos.
    10001 – Palíndromo; 303 – Palíndromo; 669 – No es un Palíndromo.*/
    int num, i = 0;
    cout << "******************* NUMERO PALINDROMO ******************* " << endl;
    cout << "Verificar si el numero es palindromo o no: " << endl;
    cout << "*Recuerde,al ingresar su numero debe ser un numero natural." << endl;
    cout << "Ingrese el numero a ser verificado: " << endl;
    cin >> num;
    cout << endl;
    if (num < 0) {
        cout << "El numero ingresado no es positivo." << endl;
        cout << endl;
    }
    int digitos[DMDigitos];
    int digitos_invertidos[DMDigitos];
    while (num > 0) {
        digitos[i] = num % 10;
        digitos_invertidos[i] = num % 10;
        num = num / 10;
        i++;
    }
    invertir(digitos, i);
    es_palindromo(digitos_invertidos, digitos, i);
}
void es_palindromo(int digitos_invertidos[], int digitos[], int i)
{
    bool SI_O_NO_palindromo = true;
    for (int j = 0; j < i; j++) {
        if (digitos[j] != digitos_invertidos[j]) {
            SI_O_NO_palindromo = false;
            cout << "El numero ingresado NO es un palindromo." << endl;
            cout << endl;
            break;
        }
        if (digitos[j] = digitos_invertidos[j]) {
            SI_O_NO_palindromo = true;
            cout << "El numero ingresado es un palindromo." << endl;
            cout << endl;
            break;
        }
    }
}
void invertir(int digitos_invertidos[], int DMDigitos) {
    int temp;
    for (int i = 0; i < DMDigitos / 2; i++) {
        temp = digitos_invertidos[i];
        digitos_invertidos[i] = digitos_invertidos[DMDigitos - 1 - i];
        digitos_invertidos[DMDigitos - 1 - i] = temp;
    }
}
void ejercicio_3()
{
    /*3.Duplicados. Use un arreglo unidimensional para resolver el siguiente problema. Recibir como entrada 20 números,
    cada uno de los cuales debe estar entre 10 y 100, inclusive. A medida que se lea cada número, validarlo y almacenarlo en el arreglo,
    sólo si no es un duplicado de un número ya leído. Después de leer todos los valores, mostrar sólo los valores únicos que el usuario introdujo.
    Prepárese para el “peor caso”, en el que los 20 números son diferentes. Use el arreglo más pequeño que sea posible para resolver este problema.*/
    int numerosGuardados[MAX];
    int num;
    int contador;
    int NV = 0; //numero de veces
    cout << "Ingrese 20 numeros en un rango de 10 a 100: " << endl;
    for (int i = 0; i < MAX; i++)
    {
        bool numero_duplicado = false;
        cin >> num;
        if (num >= 10 && num <= 100)
        {
            for (contador = 0; contador < NV; contador++)
            {
                if (num == numerosGuardados[contador])
                {
                    numero_duplicado = true;
                    break;
                }
            }
            if (!numero_duplicado)
            {
                numerosGuardados[NV] = num;
                NV++;
            }
        }
        else
        {
            cout << "El numero se encuentra fuera del rango indicado." << endl;
        }
    }
    cout << "Sus valores ingresados unicos son: " << endl;
    for (int i = 0; i < NV; i++)
    {
        cout << numerosGuardados[i] << endl;
    }
}
void ejercicio_4()
{
    /*4.	Dados. Escriba un programa para simular el tiro de dos dados. Después debe calcularse la suma de los dos valores. [Nota: cada dado puede
     mostrar un valor entero del 1 al 6, por lo que la suma de los valores variará del 2 al 12, siendo 7 la suma más frecuente, mientras que 2 y 12
     serán las sumas menos frecuentes]. En la figura 1, se muestran las 36 posibles combinaciones de los dos dados. Su programa debe tirar los dados
     36 000 veces. Utilice un arreglo unidimensional para registrar el número de veces que aparezca cada una de las posibles sumas. Imprima los
     resultados en formato tabular. Determine además si los totales son razonables (es decir, hay seis formas de tirar un 7, por lo que
     aproximadamente una sexta parte de los tiros deben ser 7).*/
    int limite = 36000, suma;
    int frecuencia[DIM_4] = { 0 };

    for (int i = 0; i < limite; i++)
    {
        int dado1 = aleatorios();
        int dado2 = aleatorios();
        int suma = dado1 + dado2;
        frecuencia[suma - 2] += 1; // frecuencia [suma - 2] = frecuencia [suma - 2] + 1, 
    }

    cout << " -----------------------------" << endl;
    cout << "|    Suma    |  Frecuencia    |" << endl;
    for (int i = 0; i < DIM_4; i++)
    {
        cout << "|      " << setw(6) << left << i + 2 << "|     " << setw(11) << left << frecuencia[i] << "|" << endl;
    }
    cout << " -----------------------------" << endl;
    cout << endl; // para mejor visualizacion 
    int reduc[DIM_4];
    for (int i = 0; i < DIM_4; i++)
    {
        reduc[i] = (frecuencia[i]) / 1000;
    }
    cout << "Diagrama de Barras con los datos obtenidos: " << endl; cout << endl;
    dibujar_diagrama_barras(reduc, DIM_4);
    cout << endl;
    cout << "En el diagrama de barras que se presenta se puede observar" << endl;
    cout << "la relacion funcional entre la frecuencia y la suma de los dados." << endl;
    cout << "Se muestra la conocida Campana de Gauss, donde es evidente que la " << endl;
    cout << "frecuencia de la suma 7 es mayor que el resto. " << endl;
    cout << endl;
}
int aleatorios() {
    random_device rd;  // Semilla del dispositivo
    mt19937 gen(rd()); // Inicializar semilla aleatoria
    int min = 1;
    int max = 6; // Rangos
    uniform_int_distribution<int> distribution(min, max);
    return distribution(gen);
}
void imprimir_doubles(const double array[], int DIM)
{
    for (int i = 0; i < DIM; i++)
    {
        cout << array[i] << endl;
    }
}



void agregar(double array[], int& contador)
{
    int pos;
    double newElemento;
    cout << "En que posicion desea agegar la nueva calificacion: ";
    cin >> pos;
    pos--;
    cout << "Escriba la calificacion que desea agregar: ";
    cin >> newElemento;
    if (pos < contador)
    {
        // Abrir hueco XD 
        for (int i = contador; i > pos; i--)
        {
            array[i] = array[i - 1];
        }
        // Insertar e incrementar contador 
        array[pos] = newElemento;
        contador++;
    }
    else
        cout << "NO hay espacio para agregar mas calificaciones" << endl;
}

void eliminar(double array[], int& contador)
{
    cout << "EL CONTADOR " << contador << endl;
    int pos;
    cout << "En que posicion desea eliminar la calificacion: ";
    cin >> pos;
    pos--;
    for (int i = pos; i < contador - 1; i++)
    {
        array[i] = array[i + 1];
    }
    contador--;
}


// Función para dibujar el diagrama de barras
void dibujar_diagrama_barras(const int datos[], int tamano) {
    // Encontrar el máximo valor en el arreglo 
    int max_valor = datos[0];
    for (int i = 1; i < tamano; i++) {
        if (datos[i] > max_valor) {
            max_valor = datos[i];
        }
    }

    // Dibujar el diagrama de barras
    for (int i = max_valor; i > 0; i--) {
        for (int j = 0; j < tamano; j++) {
            if (datos[j] >= i) {
                cout << "### ";
            }
            else {
                cout << "    ";
            }
        }
        cout << endl;
    }

    // Etiquetas del eje x 
    for (int i = 0; i < tamano; i++) {
        cout << " " << i + 2 << "  ";
    }
    cout << endl;
}
