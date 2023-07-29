#include <iostream>
using namespace std;

const int MAX = 10 ; 
typedef struct 
{
int elementos [MAX];
int contador; 
} tlista;


int main() 
{

  tlista lista;
  inicializar(lista);

  
}

void inicializar (tlista & lista)
{
  int num;
  lista.contador=0;
  cout << "Cuantos numeros desea ingresar(max 10): "; 
  cin >> num; 
  for (int i =0 ; i < num; i++)
    {
      cout << "Ingrese el numero " << i+1 << ". =";
      cin >> lista.elementos[i];
      lista.contador++;
    }
}

void imprimir (tlista lista)
  {
    for (int i =0; i< lista.contador; i++)
      {
        cout << "! " << lista.elementos[i] << " ";
      }
    cout << "! " << endl;
  }











/* 

-> Estudiar sobre definir los tipos de datos por el usuario 
-> typedef double tVentas [dias]; esto si se puede pasar en una funcion como variable y te reglesa el arreglo con la dimension de dias 
-> Estudiar sobre arreglo inclompletos y un contador que me regrese el numero de dicho elementos que son validos 
  -> Tambien hacer una funcion que me ordene los datos de un arreglo definido por el usuario 
  -> Un arreglo que guarde los numeros del codigo fibonachi y que posterior mente imporima el numero que indique el usuario con el indice que ingrese 
  
  -> Insertar un elemento nuevo en un arreglo incompleto usar un contador para ver cuantos espacios son validos 
  -> como estoy agregando un elemnto en un arreglo
  
  */