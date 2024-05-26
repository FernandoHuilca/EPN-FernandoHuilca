import javax.swing.*;

public class Recursividad {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int número) {
        num = número;
    }

    //Factorial
    public int factorial(int n) {
        int resultado = 0;
        //Damos las condiciones para cumplir con el paso base
        if (n == 0 || n == 1) {
            resultado = 1; //Paso Base
        }
        //Si el número es mayor a uno empieza el paso recursivo
        if (n > 1) {
            //Repetimos esta operación hasta que completemos todos los pasos pases del
            //paso recursivo y asi obtener el resultado
            resultado = n * factorial(n - 1); //Paso recursivo
        }
        //Devolvemos el resultado
        return resultado;
    }

    //Fibonacci
    public int fibonacci(int n) {
        int fibo = 0;
        //Definimos el paso base del algoritmo
        if (n == 0 || n == 1) {
            fibo = n; //Paso base
        } else {
            // Si no se cumple el paso base, se realiza la operación con
            // la recursividad.
            fibo = fibonacci(n - 1) + fibonacci(n - 2); //Paso recursivo
        }
        //Devolvemos el valor final 
        return fibo;
    }

    //Potencia
    public int potencia(int n, int e) {
        int potencia = 0;
        if (e == 0) {
            potencia = 1;
        } else {
            if (e == 1) {
                potencia = n;
            } else {
                if (e > 1) {
                    potencia = n * potencia(n, (e - 1));
                }
            }
        }
        return potencia;
    }

    //Torres de Hanoi
    public int torresDeHanoi(int n, String origen, String destino, String auxiliar) {
        int movimientos = 0;
        if (n == 1) {
            JOptionPane.showMessageDialog(null, "Mover un disco del" + origen + " al " + destino);
        } else {
            torresDeHanoi(n - 1, origen, auxiliar, destino);
            JOptionPane.showMessageDialog(null, "Mover un disco del" + origen + " al " + destino);
            torresDeHanoi(n - 1, auxiliar, destino, origen);
        }
        movimientos = (potencia(2, n) - 1);
        return movimientos;
    }
}
