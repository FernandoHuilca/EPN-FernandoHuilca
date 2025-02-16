//Author Fernando Huilca 
#include <iostream>
#include <string>
using namespace std;
void dividir(int op1, int op2, int& resultado, bool& exito);

int main()

{
    int num1, num2, resultado;
    bool exito = true;
    cout << "Valor1: " << endl;
    cin >> num1;
    cout << "Valor2: " << endl;
    cin >> num2;
    dividir(num1, num2, resultado, exito);
    if (exito)
    {
        cout << num1 << " / " << num2 << " = " << resultado << endl;
    }
    else
    {
        cout << "No se puede dividir para 0 " << endl;
    }


}

void dividir(int op1, int op2, int& resultado, bool& exito)
{
    if (op2 != 0) {
        resultado = op1 / op2;
    }
    else
    {
        exito = false;
    }
}


