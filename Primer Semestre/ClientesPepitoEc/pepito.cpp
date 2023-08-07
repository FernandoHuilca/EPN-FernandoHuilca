//Autor: Feranando huilca 
#include <iostream>
using namespace std;
#include <string> 
#include <iomanip> 
#include <fstream> 

//Constates
const int DIM = 50;
//Estructuras
typedef struct
{
    string calle_principal;
    string calle_secundaria;
    double numero_casa;
}tDireccion;

typedef struct
{
    string nombres;
    string apellidos;
    int edad;
    string cedula;
    string telefono;
    string ciudad;
    tDireccion direccion;

}tCliente;

typedef struct
{
    tCliente elemento[DIM];
    int contador;
}tLista;

//Prototipos
//Menu para los clientes
int menu();
//Funcion para cargar o leer datos de un archivo
void cargar(tLista &lista);
//funcion para guardar 
void guardar(const tLista& lista); 
//Funcion para  concatenar nombre y apellido 
string full_name(const tCliente cliente);
//Funcion que muestra la lista completa de clientes validos 
void mostrarClientes(tLista& lista);
// Funcion para aniadir cliente 
void aniadir_cliente(tLista& lista);
//Funcion para eliminar un cliente
void eliminar_cliente(tLista &lista);
//Funcion para modificar algun cliente
void modificar_cliente(tLista &lista);



/********************************************************************/
int main()
{
    int opcion;
    tLista lista;
    cargar(lista);
    tCliente cliente;
    cout << "   Gestión de Clientes empresa PEPITO.EC  " << endl;
    do
    {
        opcion = menu();

        switch (opcion)
        {
        case 1:
            mostrarClientes(lista);
            break;
        case 2:
            aniadir_cliente(lista);
            break;
        case 3: 
            eliminar_cliente(lista);
            break;
        case 4:
        modificar_cliente(lista);
        break;
        }
    } while (opcion != 0);
    guardar(lista);






    return 0;

}
/*********************************************************************/

//Declaraciones de funciones 
int menu()
{
    int opcion;
    do
    {
        cout << "          Menu de Clientes     " << endl;
        cout << "1. Mostrar el listado de clientes. " << endl;
        cout << "2. Aniadir un nuevo cliente. " << endl;
        cout << "3. Eliminar un cliente existente. " << endl;
        cout << "4. Modificar un cliente. " << endl;
        cout << "0. Salir. " << endl;
        cout << "----------------------------------" << endl;
        cout << "Opcion: ";
        cin >> opcion;
        cout << endl;
        if (opcion < 0 || opcion > 4)
        {
            cout << "Valor ingresado fuera de los limites. " << endl;
            cout << "Ingrese un numero del 0 al 4 por favor. " << endl;
        }
    } while (opcion < 0 || opcion > 4);

    return opcion;
}


void cargar(tLista &lista)
{
    tCliente cliente;
    ifstream leer_archivo;
    lista.contador = 0;
    char aux; 
    leer_archivo.open("clientes.txt");
    if (!leer_archivo.is_open())
    {
        cout << "ERROR: El archivo no se pudo abrir." << endl;
    }
    else
    {
        getline(leer_archivo, cliente.nombres);
        while ((cliente.nombres != "xxx") && (lista.contador < DIM))
        {
            getline(leer_archivo, cliente.apellidos);
            leer_archivo >> cliente.edad;
            leer_archivo.get(aux);
            getline(leer_archivo, cliente.cedula);
            getline(leer_archivo, cliente.telefono);
            getline(leer_archivo, cliente.ciudad);
            getline(leer_archivo, cliente.direccion.calle_principal);
            getline(leer_archivo, cliente.direccion.calle_secundaria);
            leer_archivo >> cliente.direccion.numero_casa;
            leer_archivo.get(aux);

            lista.elemento[lista.contador] = cliente;

            lista.contador++;

            getline(leer_archivo, cliente.nombres);


        }
    } leer_archivo.close();
}

void guardar(const tLista& lista)
{
    ofstream escribir_archivo;
    escribir_archivo.open("clientes.txt");
    for (int i = 0; i < lista.contador; i++)
    {
        escribir_archivo << lista.elemento[i].nombres << endl;
        escribir_archivo << lista.elemento[i].apellidos << endl;
        escribir_archivo << lista.elemento[i].edad << endl;
        escribir_archivo << lista.elemento[i].cedula << endl;
        escribir_archivo << lista.elemento[i].telefono << endl;
        escribir_archivo << lista.elemento[i].ciudad << endl;
        escribir_archivo << lista.elemento[i].direccion.calle_principal << endl;
        escribir_archivo << lista.elemento[i].direccion.calle_secundaria << endl;
        escribir_archivo << lista.elemento[i].direccion.numero_casa << endl;
    }
    escribir_archivo << "xxx" << endl;
    escribir_archivo.close();
}

string full_name(const tCliente cliente)
{

    return cliente.nombres + " " + cliente.apellidos;
}


void mostrarClientes(tLista& lista)
{

    cout << "--------Lista de los clientes--------" << endl;
    //cout << "-------------------------------------------" << endl;
    cout << setw(10) << "Nombre" << setw(10) << "Edad" << setw(10) << "Cedula";
    cout << setw(10) << "Telefono" << setw(10) << "Calle principal" << setw(15);
    cout << "Ciudad" << setw(15) << "Calle secundaria" << setw(10) << "Numero de casa" << endl;
    for (int i = 0; i < lista.contador; i++)
    {
        cout << setw(40) << full_name(lista.elemento[i]);
        cout << setw(3) << lista.elemento[i].edad;
        cout << setw(15) << lista.elemento[i].cedula;
        cout << setw(15) << lista.elemento[i].telefono;
        cout << setw(15) << lista.elemento[i].ciudad;
        cout << setw(15) << lista.elemento[i].direccion.calle_principal;
        cout << setw(15) << lista.elemento[i].direccion.calle_secundaria;
        cout << setw(15) << lista.elemento[i].direccion.numero_casa;
        cout << endl;


    }
}

void aniadir_cliente(tLista& lista)
{
    if (lista.contador == DIM)
    {
        cout << "No se puede aniadir mas clientes. Sin espacio." << endl;
    }
    else
    {
        cout << "Ingrese los nombres del cliente: ";
        cin.ignore();
        getline(cin, lista.elemento[lista.contador].nombres);
        cout << "Ingrese los apellidos del cliente: ";
        getline(cin, lista.elemento[lista.contador].apellidos);
        cout << "Ingrese la edad del cliente: ";
        cin >> lista.elemento[lista.contador].edad;
        cin.ignore();
        cout << "Ingrese la cedula del cliente: ";
        getline(cin, lista.elemento[lista.contador].cedula);
        cout << "Ingrese el telefono del cliente: ";
        getline(cin, lista.elemento[lista.contador].telefono);
        cout << "Ingrese la ciudad del cliente: ";
        getline(cin, lista.elemento[lista.contador].ciudad);
        cout << "Ingrese la calle principal del cliente: ";
        getline(cin, lista.elemento[lista.contador].direccion.calle_principal);
        cout << "Ingrese la calle secundaria del cliente: ";
        getline(cin, lista.elemento[lista.contador].direccion.calle_secundaria);
        cout << "Ingrese el numero de casa del cliente: ";
        cin >> lista.elemento[lista.contador].direccion.numero_casa;
        lista.contador++;


    }
}

void eliminar_cliente(tLista &lista)
{
    int pos;
    cout << "Cual es la posicion del cliente que desea eliminar: ";
    cin >> pos ; 
    pos--;
    if ((pos < 0 ) || (pos > lista.contador))
    {
        cout << "El elemento que desea eliminar no se encuentra en la lista" << endl; 
    }
    else
    {
        for (int i = pos; i < lista.contador -1 ; i++)
        {
            lista.elemento[i] = lista.elemento[i+1];
        }
        lista.contador --;
    }
    
}

void modificar_cliente(tLista &lista)
{
    int pos; 
    pos--;
    cout << "Escroba la posicion del cliente que desea modificar: ";
    cin >> pos;
    if ((pos < 0 ) || (pos > lista.contador-1))
    {
        cout << "El elemento que desea eliminar no se encuentra en la lista" << endl; 
    }
    else
    {
        cout << "Ingrese los nombres del cliente: ";
        cin.ignore();
        getline(cin, lista.elemento[pos].nombres);
        cout << "Ingrese los apellidos del cliente: ";
        getline(cin, lista.elemento[pos].apellidos);
        cout << "Ingrese la edad del cliente: ";
        cin >> lista.elemento[pos].edad;
        cin.ignore();
        cout << "Ingrese la cedula del cliente: ";
        getline(cin, lista.elemento[pos].cedula);
        cout << "Ingrese el telefono del cliente: ";
        getline(cin, lista.elemento[pos].telefono);
        cout << "Ingrese la ciudad del cliente: ";
        getline(cin, lista.elemento[pos].ciudad);
        cout << "Ingrese la calle principal del cliente: ";
        getline(cin, lista.elemento[pos].direccion.calle_principal);
        cout << "Ingrese la calle secundaria del cliente: ";
        getline(cin, lista.elemento[pos].direccion.calle_secundaria);
        cout << "Ingrese el numero de casa del cliente: ";
        cin >> lista.elemento[pos].direccion.numero_casa;
        
    }
}



