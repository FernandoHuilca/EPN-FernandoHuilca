
#include <iostream> 
#include <string>
#include <iomanip>
using namespace std; 


int main ()
{
    string nombre; 
    int horas;
    double salario, Apagar, normal, extra; 
    cout << "Escriba el nombre del empleado: " << endl;
    cin >> nombre; 
    cout << "Escriba las horas trabajadas por del empleado: " << endl;
    cin >> horas; 
    cout << "Escriba el salario por hora del empleado: " << endl;
    cin >> salario; 
    if (horas <= 40)
    {
        Apagar = horas * salario; 
        cout << "Al empleado " << nombre << " se le tiene que pagar: " << Apagar << " dolares. " << endl;
    }
    else 
    {
      normal = 40 * salario; 
      extra = (horas - 40 )* salario * 1.5;
      Apagar = normal + extra; 
        cout << "Al empleado " << nombre << " se le tiene que pagar: " << Apagar << " dolares. " << endl;
    }   
    
    return 0;
}
void busqueda(string nombreCompleto)
{
     string name = " " , phone = " "; 
     int contador = 0; 
     char aux = ' ';
    ifstream leerAarchivos; 

    leerArchivo.open("directorio.txt");
    if (!leerArchivo.is_open())
    {
        cout << setw()<< "Archivo no abierto." << endl;
        return;
    }

    string linea;
    while (getline(leerArchivo, linea))
    {
        // Encontrar el primer espacio en blanco que separa el nombre y el número de teléfono
        size_t pos = linea.find(' ');
        if (pos != string::npos)
        {
            // Extraer el nombre de la línea
            string nombre_archivo = linea.substr(0, pos);

            // Comparar el nombre con el nombre del archivo (considerar mayúsculas y minúsculas)
            if (nombreCompleto == nombre_archivo)
            {
                // Extraer el número de teléfono de la línea
                string numero_telefono = linea.substr(pos + 1);

                cout << "Número de teléfono de " << nombreCompleto << ": " << numero_telefono << endl;
                return; // Terminar la búsqueda si se encuentra el nombre
            }
            cout << "NOMNRE " << nombre_archivo << endl;
        }
    }

    cout << "Nombre no encontrado en el directorio." << endl;
}

