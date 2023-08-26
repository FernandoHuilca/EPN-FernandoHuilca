#include <iostream>
#include <string>
using namespace std;

int main()
{
    string password = "4508";
    string intento;
    //bool acceso; 
    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            for (int k = 0; k < 10; k++)
            {
                for (int l = 0; l < 10; l++)
                {
                    intento = to_string(i) + to_string(j) + to_string(k) + to_string(l);

                    if (password == intento)
                    {
                        cout << "La contrasennia es: " << i << j << k << l << endl;
                        break;
                    }
                }
            }
        }
    }

    return 0;
}
