
#include <iostream> 
using namespace std; 
bool isPrimo(int num); 

int main ()
{
const int dim = 7; 
double ventas [dim] = {45.2,323.8,878,23.1,0.54,65,98} ;
string dias[7]= {"Lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
for (int i=0; i < dim; i++)
{
 cout << "ventas del " << dias [i] << " " << ventas [i] << endl;   
}

}
