import javax.swing.*;

public class Recursividad {
    private int num; // Variable para almacenar un número

    public int getNum() {
        return num;
    }

    public void setNum(int número) {
        num = número;
    }

    // Método para calcular el factorial de un número
    public int factorial(int n) {
        int resultado = 0;
        // Verificar si el número es 0 o 1 (paso base)
        if (n == 0 || n == 1) {
            resultado = 1; // Factorial de 0 y 1 es 1
        } else if (n > 1) {
            // Si el número es mayor que 1, realizar recursión
            resultado = n * factorial(n - 1); // Paso recursivo para calcular el factorial
        }
        return resultado;
    }

    // Método para calcular el término n de la serie de Fibonacci
    public int fibonacci(int n) {
        int fibo = 0;
        // Verificar si el número es 0 o 1 (paso base)
        if (n == 0 || n == 1) {
            fibo = n; // El término n de Fibonacci es igual a n para n=0,1
        } else {
            // Si no se cumple el paso base, realizar recursión
            fibo = fibonacci(n - 1) + fibonacci(n - 2); // Paso recursivo para calcular Fibonacci
        }
        return fibo;
    }

    // Método para calcular la potencia de un número
    public int potencia(int n, int e) {
        int potencia = 0;
        // Verificar si el exponente es 0 (paso base)
        if (e == 0) {
            potencia = 1; // Cualquier número elevado a 0 es 1
        } else if (e == 1) {
            potencia = n; // Cualquier número elevado a 1 es el mismo número
        } else if (e > 1) {
            // Si el exponente es mayor que 1, realizar recursión
            potencia = n * potencia(n, (e - 1)); // Paso recursivo para calcular la potencia
        }
        return potencia;
    }

    // Método para resolver el problema de las Torres de Hanoi
    public int torresDeHanoi(int n, String origen, String destino, String auxiliar) {
        int movimientos = 0;
        if (n == 1) {
            // Caso base: mover un disco de origen a destino
            JOptionPane.showMessageDialog(null, "Mover un disco del" + origen + " al " + destino);
        } else {
            // Caso recursivo: mover n-1 discos de origen a auxiliar, mover disco n de origen a destino, mover n-1 discos de auxiliar a destino
            torresDeHanoi(n - 1, origen, auxiliar, destino); // Mover n-1 discos de origen a auxiliar
            JOptionPane.showMessageDialog(null, "Mover un disco del" + origen + " al " + destino);
            torresDeHanoi(n - 1, auxiliar, destino, origen); // Mover n-1 discos de auxiliar a destino
        }
        // Calcular el número total de movimientos
        movimientos = (potencia(2, n) - 1);
        return movimientos;
    }
}
