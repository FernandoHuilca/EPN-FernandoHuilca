// Author Fernando Huilca 
/*3. Un almacén de pedidos por correo vende cinco productos distintos, cuyos precios de venta son los siguientes:
Zapatilla Adidas 1, $160.00;
Zapatilla Nike, $180.00;
Camiseta FEF, $80.00;
Calentador FEF, $145.00 y
Gorra Nike, $25.00.
*Escriba un programa que le muestre al usuario los productos disponibles, para que el elija y también le pregunte la cantidad de esos productos:

*El usuario puede comprar varios productos.

Si el usuario compra productos Nike tendrá un 20% de descuento en esos productos.

Si el usuario compra productos FEF tendrá un 50% de descuento en esos productos.

Su programa debe utilizar una instrucción switch para determinar el precio de venta de cada producto.

Debe calcular y mostrar el valor total de venta de todos los productos vendidos, el descuento y el IVA del 12%.

Use un ciclo controlado por centinela (ejemplo: ingrese el número de producto 0 para terminar) para determinar cuándo debe el programa dejar de iterar para mostrar los resultados finales.*/

#include <iostream>
#include <string>
#include <fstream> 
#include <iomanip>
using namespace std;
int menu();
void factura();
ifstream leerarchivo;
ofstream escribirarchivo;

int main()
{
    int opcion;
    int cantiAdidas, cantiNike, cantiCamiFEF, cantiCalentadorFEF, cantiGorra;
    escribirarchivo.open("datos.txt");
    do
    {
        opcion = menu();
        if (opcion >= 0 && opcion <= 5)
        {
            
            switch (opcion)
            {
            case 1:
                cout << "Que cantidad de zapatillas Adidas desea comprar: " << endl;
                cin >> cantiAdidas;
                escribirarchivo  << cantiAdidas << " " << (cantiAdidas * 160) << " " <<  "Zapatillas Adidas" << endl;
                break;
            case 2:
                cout << "Que cantidad de zapatillas Nike desea comprar: " << endl;
                cin >> cantiNike;
                escribirarchivo  << cantiNike << " " << (cantiNike * 180)*0.8 << " " << "Zapatillas Nike" << endl;
                break;
            case 3:
                cout << "Que cantidad de Camisetas FEF desea comprar: " << endl;
                cin >> cantiCamiFEF;
                escribirarchivo  << cantiCamiFEF << " " << (cantiCamiFEF * 80) * 0.5 << " " << "Camisetas FEF" << endl;
                break;
            case 4:
                cout << "Que cantidad de Calentadores FEF desea comprar: " << endl;
                cin >> cantiCalentadorFEF;
                escribirarchivo   << cantiCalentadorFEF << " " << (cantiCalentadorFEF * 144) * 0.5 << " " << "Calentadorees FEF" << endl;
                break;
            case 5:
                cout << "Que cantidad de Gorras Nike desea comprar: " << endl;
                cin >> cantiGorra;
                escribirarchivo  << cantiGorra << " " << (cantiGorra * 25) * 0.8 << " " << "Gorras Nike" << endl;
                break;
            case 0:
                cout << "Fin del Programa " << endl;
                escribirarchivo << -1; 
                escribirarchivo.close(); 
                break;

            default:
                cout << "No use desimales, solo los enteros del 0 al 5" << endl;
                break;
            }

        }
        else
        {
            cout << "NUMERO FUERA DE RANGO " << endl;
        }

    } while (opcion != 0);

    factura();

    return 0;

}







// Defino la funcion menu
int menu()
{
    int opcion;
    cout << " _______________MENU_______________" << endl;
    cout << "| Seleccione el producto a comprar |" << endl;
    cout << "|__________________________________|" << endl;
    cout << "| Producto               | Precio  |" << endl;
    cout << "|------------------------|---------|" << endl;
    cout << "| 1) Zapatillas Adidas   | $160.00 |" << endl;
    cout << "| 2) Zapatillas Nike     | $180.00 |" << endl;
    cout << "| 3) Camiseta FEF        | $80.00  |" << endl;
    cout << "| 4) Calentador FEF      | $145.00 |" << endl;
    cout << "| 5) Gorra Nike          | $25.00  |" << endl;
    cout << "|__________________________________|" << endl;
    cout << "| 0) SALIR                         |" << endl;
    cout << "|__________________________________|" << endl;
    cin >> opcion;

    return opcion;
}
void factura()
{
    string nameproducto;
    int cantidadproducto;
    double precio, total = 0; 
    char aux;
    leerarchivo.open("datos.txt");
    cout << "_______________________Compra de venta_________________________" << endl;
    cout << "|" << left << setw(20) << "Producto" << "|" << left << setw(20) << "Cantidad" << "|"
        << right << setw(20) <<" Valor a pagar " << "|" << endl;
    cout << "_______________________________________________________________" << endl;
    leerarchivo >> cantidadproducto;
    while (cantidadproducto != -1)
    {
        leerarchivo  >> precio;
        getline(leerarchivo, nameproducto);
        total = total + precio;
        cout << "|" << internal << setw(20) << nameproducto << "|" << internal << setw(20) << cantidadproducto 
            << "|" << internal << setw(20) << precio <<"|" << endl;
        
        leerarchivo >> cantidadproducto; 

    }
    cout << "_______________________________________________________________" << endl;
    cout << "|" << left << setw(20) << " IVA = " << right << setw(40) << total*0.12 << " | " << endl;
    cout << "_______________________________________________________________" << endl;
    cout << "|" << left << setw(20) << "TOTAL A PAGAR = " << right << setw (40) << (total* 0.12)+ total << " | " << endl;
    cout << "_______________________________________________________________" << endl;
    
    leerarchivo.close(); 

}