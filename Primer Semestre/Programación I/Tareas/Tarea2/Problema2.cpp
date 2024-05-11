/*2.	Escribe un programa en C++ que empiece solicitando dos números, uno que represente el precio de un producto y otro que represente las unidades del producto que se adquieren, un carácter que indique si se tiene derecho a descuento del 15% antes del I.V.A. (S/N), una cadena que será el nombre completo (varias palabras) del cliente, otra cadena con la cédula del cliente, otra más con la dirección (varias palabras) y una última con el nombre del producto. A continuación, el programa generará en la pantalla una factura de la compra realizada: nombre del cliente, dirección y cédula, nombre del producto, unidades adquiridas, precio unitario, total (unidades por precio), descuento aplicado, total tras descuento, tanto por ciento de I.V.A. aplicado (12%), cantidad de I.V.A. y precio final (añadiendo el I.V.A. al total). Cada dato irá en una línea, precedido de su nombre, y ocupará exactamente 10 espacios, estará ajustado a la derecha y mostrará 2 decimales. Utilice la biblioteca iomanip. Ejemplo de ejecución del programa:*/
#include <iostream> 
#include <string> //para usar getlinea y leer cadena de caracteres
#include <iomanip> //Para ajustar left or right el texto 
using namespace std; 

int main ()
{
    double price, total_descuento;
    int units; 
    char discount = 'n', aux;
    const double iva = 12; 
    string full_name, cell, address, product_name; 
    
    cout << "Ingrese el nombre del producto: " ; 
    getline(cin, product_name); 
    cout << "Ingrese el precio del producto: " ; 
    cin >> price;
    cout << "Ingrese las unidades de compra del producto: " ; 
    cin >> units;
    cout << "Ingrese el nombre del cliente: " ; 
    cin.get (aux); // MUY UTIL! para saltar espacios
    getline(cin,full_name); //Para ignorar los espacios y guardar todo el nombre 
    cout << "Ingrese el numero de cedula del cliente: " ; 
    getline(cin,cell);
    cout << "Ingrese la direccion del cliente: " ; 
    getline(cin,address);    
    cout << "¿Aplica descuento? (y/n) "  << endl; // Descuento del 15 % 
    cin >> discount;
    // Desde aqui voy a imprimir la factura 
    cout << "Factura:" << endl; 
    cout << right << setw (50)<< full_name << endl;
    cout << right << setw (50)<< address << endl; 
    cout << right << setw (50)<< cell << endl; 
    cout << "Producto: " << product_name << endl;
    cout << left << setw(20)<< "Precio unitario: " << right << setw(30)<< price << endl;  
    cout << left << setw(20)<< "Unidades: " << right << setw(30)<< units << endl;   
    cout << left << setw(20)<< "Total: " << right << setw (30) << fixed << setprecision(2) <<  price*units << endl; 
    if (discount == 'y')
    {
        cout << left << setw(20)<< "Descuento: " << right << setw (30) << fixed << setprecision(2) << (price*units)*0.15 << endl;
        total_descuento = (price*units)* 0.85;
        cout << left << setw(22)<< "Total tras descuento: " << right << setw (28) << fixed << setprecision(2) << total_descuento << endl;
    }
    else if (discount == 'n')
    {
        
        cout << left << setw(20)<< "Descuento: " << right << setw (30) << "0.00" << endl;
        total_descuento = (price*units);
        cout << left << setw(22)<< "Total tras descuento: " << right << setw (28) << fixed << setprecision(2) << total_descuento << endl;
    }
    cout << left << setw(20)<< "I.V.A: " << right << setw(30) << fixed << setprecision(2) << (total_descuento)*0.12 << endl;
    cout << left << setw(20)<< "Precio Final: " << right << setw (30) << fixed << setprecision(2)<< (total_descuento)*1.12 << endl; 
    


}


/*    cout << "Precio del producto: " << price << endl;
    cout << "Unidades: " << units << endl; 
    cout << "Descuento (y/n): " << discount << endl;
    cout << "Nombre del cliente: " << full_name << endl; 
    cout << "CI del cliente: " << cell << endl; 
    cout << "Direccion: " << address << endl;
    cout << "Nombre del producto: " product_name << endl;  */