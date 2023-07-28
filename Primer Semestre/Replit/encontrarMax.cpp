#include <iostream>
using namespace std;

int const DIM = 8;

void imprima(int array[DIM]);
void encontrar(int array[DIM], int repetidos[DIM]);
int max_arreglo(int array[DIM]);

int main()
{
    int array[DIM] = {4, 22, 5, 6, 22, 7, 22, 4};
    int repetidos[DIM];
    imprima(array);
    encontrar(array, repetidos);
    imprima(repetidos);
    cout << "El valor que mas se repite es: " << array[max_arreglo(repetidos)] << " Fin del programa " << endl;

    return 0;
}

void imprima(int array[DIM])
{
    for (int i = 0; i < DIM; i++)
    {
        cout << array[i] << " ";
    }
    cout << endl;
}

void encontrar(int array[DIM], int repetidos[DIM])
{
    int numero;
    for (int i = 0; i < DIM; i++)
    {
        int contador = 0;
        numero = array[i];
        for (int j = 0; j < DIM; j++)
        {
            if (numero == array[j])
            {
                contador++;
            }
        }
        repetidos[i] = contador;
    }
}

int max_arreglo(int array[DIM])
{
    int max = 0, anterior, indice;
    for (int i = 0; i < DIM; i++)
    {
        anterior = array[i];
        if (anterior > max)
        {
            max = anterior;
            indice = i;
        }
    }
    return indice;
}
