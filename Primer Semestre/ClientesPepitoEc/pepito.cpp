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
void cargar(tLista lista);
//Funcion para  concatenar nombre y apellido 
string full_name(const tCliente cliente);
//Funcion que muestra la lista completa de clientes validos 
void mostrarClientes(const tLista &lista);


/********************************************************************/
int main() 
{
    int opcion ;
    tLista lista;  
    cargar(lista);
    cout << "---Gestión de Clientes empresa PEPITO.EC---";
    opcion = menu(); 
    
    while (opcion != 0)
    {
        switch (opcion)
        {
        case 1:
            mostrarClientes(lista); 
            break;
        
        default:
            break;
        }
    }
    





  return 0; 
    
}
/*********************************************************************/

//Declaraciones de funciones 
int menu ()
{
    int opcion; 
  do
  {
    cout << "------Menu de Clientes------" << endl; 
    cout << "1. Mostrar el listado de clientes. " << endl; 
    cout << "2. Aniadir un nuevo cliente. " << endl; 
    cout << "3. Eliminar un cliente existente. " << endl; 
    cout << "4. Modificar un cliente. " << endl; 
    cout << "0. Salir. " << endl;  
    cout << "--------------------------------------" << endl; 
    cout << "Opcion: " ; 
    cin >> opcion; 
    cout << endl; 
    if(opcion < 0 || opcion > 4)
    {
        cout << "Valor ingresado fuera de los limites. " << endl; 
        cout << "Ingrese un numero del 0 al 4 por favor. " << endl; 
    }
  } while (opcion < 0 || opcion > 4);
  
    return opcion; 
}


void cargar(tLista lista)
{
    tCliente cliente;
    ifstream leer_archivo; 
    lista.contador = 0; 
    leer_archivo.open("clientes.txt");
    if(!leer_archivo.is_open())
    {
        cout << "ERROR: El archivo no se pudo abrir." << endl; 
    }
    else
    {
        getline(leer_archivo, cliente.nombres); 
        while ((cliente.nombres != "xxx") && (lista.contador < DIM))
        {
            cin.ignore(); 
            getline(leer_archivo, cliente.apellidos); 
            leer_archivo >> cliente.edad; 
            cin.ignore(); 
            getline(leer_archivo, cliente.cedula); 
            cin.ignore(); 
            getline(leer_archivo, cliente.telefono);
            cin.ignore(); 
            getline(leer_archivo, cliente.ciudad); 
            cin.ignore(); 
            getline(leer_archivo, cliente.direccion.calle_principal); 
            cin.ignore(); 
            getline(leer_archivo, cliente.direccion.calle_secundaria);
            leer_archivo >> cliente.direccion.numero_casa;  
            cin.ignore();   

            lista.elemento[lista.contador] = cliente; 

            lista.contador++;

            getline(leer_archivo, cliente.nombres);

        
        }
    } leer_archivo.close(); 
}

void guardar(const tLista &lista)
{
    ofstream escribir_archivo; 
    escribir_archivo.open("clientes.txt");
    for(int i=0; i < lista.contador; i++)
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


void mostrarClientes(const tLista &lista)
{

    cout << "--------Lista de los clientes--------" << endl;  
    cout << "-------------------------------------------" << endl;
    cout  << setw (40) <<  "Nombre" << setw(15) << "Edad" << setw(32) << "Cedula" << setw(35)<< "Telefono" << setw(35) << "Calle principal"<< setw(35) << "Ciudad" << setw(35) << "Calle secundaria" << setw(10) << "Numero de casa" << endl;    
    for (int i = 0; i < lista.contador; i++)
    { 
        cout << setw(40) << full_name(lista.elemento[i]);
        cout << setw(3) << lista.elemento[i].edad; 
        cout << setw(35) << lista.elemento[i].cedula;
        cout << setw(35) << lista.elemento[i].telefono;
        cout << setw(35) << lista.elemento[i].ciudad; 
        cout << setw(35) << lista.elemento[i].direccion.calle_principal;
        cout << setw(35) << lista.elemento[i].direccion.calle_secundaria;
        cout << setw(35) << lista.elemento[i].direccion.numero_casa;
        cout << endl; 
        
         
    }
}

void aniadir_cliente(tLista &lista, tCliente &cliente)
{
    if(lista.contador == DIM)
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