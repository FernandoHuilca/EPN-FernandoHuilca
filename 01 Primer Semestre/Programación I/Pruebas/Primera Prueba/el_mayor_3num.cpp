// Autor Fernnando Huilca 
// Programa para comparar 3 numeros he imprimmir en orden descendiente  
#include <iostream>
using namespace std; 

int main ()
{
    int a, b, c; 
    cout << "Ingrese el primer numero por favor: " << endl;
    cin >> a;
    cout << "Ingrese el segundo numero por favor: " << endl;
    cin >> b;
    cout << "Ingrese el tercer numero por favor: " << endl;
    cin >> c;
    if (a>b)
    {
        if (a>c)
        {
            if (b>c)
            {
                cout << "a>b>c" << endl;
            }
             else 
            {
                cout << "a>c>b" << endl;
            }
        }
        else 
        {
            cout << "c>a>b" << endl;
        }
    }
    else 
    {
        if (b>c) 
        {
            if (c>a)
            {
                cout << "b>c>a" << endl;
            }
            else 
            {
                cout << "b>a>c" << endl; 
            }
        }
        else 
        {
            cout << "C>B>A" << endl;
        }
    }
   


return 0;
}