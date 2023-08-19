#include "basicos.h"
double suma(double a, double b)
{
    return (a + b);
}
double resta(double a, double b)
{
    return (a - b);
}
double multiplicacion(double a, double b)
{
    return a * b;
}
double division(double a, double b)
{
    double resultadodiv; 
    if (b == 0)
    {
        cout << "No existe division para cero" << endl;
        resultadodiv = 0;
    }
    else
        resultadodiv = a / b;
    return resultadodiv;
}