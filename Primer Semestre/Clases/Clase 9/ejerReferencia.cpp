//Author Fernando Huilca 
#include <iostream>
#include <string>
using namespace std;
void (int op1; int op2; int &div; int &rest);

int main()

{
    int cociente, resto;
    for (int i = 1; i <= 5; i++)
    {
        for (int j = 1; j <=5; j++)
        {
        dividir (j,i, cociente, resto);
    
            cout << j << " entre" << i
                << " da un cociente de " << cociente
                << " y un residuo de " << resto << endl;
       }

    }
}

void dividir (int op1, int op2, int &cociente, int &residuo){
    div= op1 / op2;
    res = op1 % op2;

}