// Author Fernando Huilca 
// Calculadora 
#include <iostream>
#include <string>
using namespace std; 
void menu (); 
double suma ();
double resta ();
double multiplicacion ();
double division ();
void saludo(); 

int opcion = 1;
double a, b, resultadodiv; 
string nombre; 

int main ()
{
   cout << "******* BIENVENIDO A LA POLICALCULADORA *******" << endl; 
   saludo (); 
    while (opcion != 0 )
    {
        menu ();
        if ( opcion >= 1 && opcion <=5)
        {
            cout << "Ingrese el primer valor: " << endl;
            cin >> a ; 
            cout << "Ingrese el segundo valor: " << endl;
            cin >> b ; 
            switch (opcion)
            {
            case 1: 
                cout << "El resultado de la suma es: " << suma () << endl;  
                break;
            case 2: 
                cout << "El resultado de la resta es: " << resta () << endl;
                break; 
            case 3: 
                cout << "El resultado de la multiplicacion es: " << multiplicacion () << endl; 
                break; 
            case 4: 
                cout << "El resultado de la division es: " << division () << endl;
                break;
            }
        
        }
        else if (opcion == 0)
        {
            break; 
        }
        else
        {
            cout << "Seleccion fuera de los parametros, intentelo de nuevo" << endl; 
        }
    }

    cout << "Vuelva pronto por mas calculos!!" << endl; 
    cout << endl; 
    cout << "BBBBB   Y    Y  EEEEE\n";
    cout << "B    B   Y  Y   E    \n";
    cout << "BBBBB     Y     EEEE \n";
    cout << "B    B    Y     E    \n";
    cout << "BBBBB     Y     EEEEE\n";
    return 0; 
}

void menu ()
{
    cout << "Seleccione la operacion que desea realizar: " << endl; 
    cout << "1. SUMA " << endl; 
    cout << "2. RESTA " << endl; 
    cout << "3. MULTIPLICACION " << endl; 
    cout << "4. DIVISION " << endl; 
    cout << "0. SALIR " << endl; 
    cout << "Escriba el numero: ";
    cin >> opcion; 
}
double suma ()
{
 return (a + b); 
}
double resta ()
{
 return (a - b); 
}
double multiplicacion ()
{
 return a * b; 
}
double division ()
{
    if (b==0)
    {
    cout << "No existe division para cero" << endl; 
    resultadodiv = 0; 
    }
    else 
    resultadodiv = a/b; 
 return resultadodiv; 
}
void saludo ()
{
    cout << "Ingrese su nombre completo: " ; 
    getline(cin, nombre);
    cout << "Bienvenido " << nombre << endl; 
    cout << endl;  

}



