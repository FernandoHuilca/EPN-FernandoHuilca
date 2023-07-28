//Author Fernando Huilca
/*El problema consiste en calcular el monto de una compra y mostrarlo en consola. El cliente ingresará la cantidad de productos comprados teniendo el siguiente listado:
Producto	Costo (dólares/unidad)
Huevos	0.15
Aceite	1.10
Leche	0.90
Libra arroz	0.60
Cerveza	1.80
*/
#include <iostream>
using namespace std;
int main()
{
    double huevos, aceite, leche, libra_arroz, cerveza;
    double monto_compra, impuesto, impuesto_cerveza, descuento, total_pago, subtotal;

    cout << "Ingrese la cantidad de huevos comprados: " << endl;
    cin >> huevos;
    cout << "Ingrese la cantidad de aceite comprado: " << endl;
    cin >> aceite;
    cout << "Ingrese la cantidad de leche comprada: " << endl;
    cin >> leche;
    cout << "Ingrese la cantidad de libra de arroz comprado: " << endl;
    cin >> libra_arroz;
    cout << "Ingrese la cantidad de cerveza comprada: " << endl;
    cin >> cerveza;

    subtotal = (huevos * 0.15) + (aceite * 1.10) + (leche * 0.90) + (libra_arroz * 0.60) + ((cerveza * 1.80));
    monto_compra = (huevos * 0.15) + (aceite * 1.10) + (leche * 0.90) + (libra_arroz * 0.60) + ((cerveza * 1.80) * 1.05);
    impuesto = monto_compra * 0.12;
    impuesto_cerveza = (cerveza * 1.80) * 0.05;
    descuento = impuesto * 0.01;
    total_pago = monto_compra - descuento;

    cout << "            NOTA DE PAGO  " << endl;
    cout << " ---------------------------------------" << endl;
    cout << "|  cantidad |   Producto   |   Precio   |" << endl;
    cout << "|  " << huevos << "       |   Huevo      |   0.15     |" << endl;
    cout << "|  " << aceite << "        |   Aceite     |   1.10     |" << endl;
    cout << "|  " << leche << "        |   Leche      |   0.90     |" << endl;
    cout << "|  " << libra_arroz << "        |   L. arroz   |   0.60     |" << endl;
    cout << "|  " << cerveza << "        | Cerveza      |   1.80     |" << endl;
    cout << " ---------------------------------------" << endl;
    cout << "| Subtotal = " << subtotal << "                       |" << endl;
    cout << "| Impuesto del Iva = " << impuesto << "             |" << endl;
    cout << "| Impuesto a la cerveza = " << impuesto_cerveza << "          |" << endl;
    cout << "| Descuento del 1% = " << descuento << "           |" << endl;
    cout << "| Total=" << monto_compra << "                           |" << endl;
    cout << " ---------------------------------------" << endl;
    cout << endl;
    cout << "Vuelva pronto." << endl;

    return 0;
}