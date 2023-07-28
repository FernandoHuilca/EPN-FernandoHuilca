#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    int num = 123;
    double value = 45.67;
    string text = "Hello";

    cout << left << setw(10) << text << endl;        // Alineado a la izquierda
    cout << "|" << right << setw(10) << num << "|" << endl;        // Alineado a la derecha
    cout << "|" << internal << setw(10) << showpos << num << "|" << endl;  // Alineado internamente
    cout << "|" <<fixed << setw(10) << setprecision(2) << value << "|" << endl; // Alineado a la derecha y fijo con precisión decimal

    return 0;
}
