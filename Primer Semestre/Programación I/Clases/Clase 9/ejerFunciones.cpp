//Author Fernando Huilca 
#include <iostream>
#include <string>
using namespace std;
int dividir (int op1, int op2);
int residuo (int op1, int op2);

int main ()

{
int cociente, resto;
for (int i = 1; i <=5; i++)
{
    for (int j = 1; j <=5; j++) 
    {
        cociente = dividir(j,i);
        resto = dividir (j,i);
        cout <<j << " entre " << i 
        << " da un cociente de " << cociente
        << " y un residuo de " << resto << endl; 
    }

}
}

int dividir (int op1, int op2 )
{
return op1/op2;
}
int residuo (int op1, int op2)
{
    return op1 % op2;
}
