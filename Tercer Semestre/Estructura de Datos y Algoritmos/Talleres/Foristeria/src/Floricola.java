import javax.swing.*;
import java.util.Scanner;
/*
 * @author: Fernando Huilca, Alison Betancourt y Mateo Simbaña
 */
public class Floricola {
    // Problema de clase
    Scanner scanner = new Scanner(System.in);
    private int[][][] datos;
    private int tiposDeFlores;
    private final static int meses = 12;
    private int anios;

    public Floricola(){
        tiposDeFlores = 6;
        anios = 4;
        datos = new int[tiposDeFlores][meses][anios];
    }

    // Escritura de datos
    public void registrarDatos() {
        for (int i = 0 ; i < anios; i++){
            for (int j = 0; j < meses; j++){
                for (int k = 0; k < tiposDeFlores; k++){
                    System.out.print("\u001B[32m \t Ingrese el total producido del año: " + (i+1) + " del mes: " + (j+1) + " de la flor: " + (k+1) + " = \u001B[0m");
                    datos[k][j][i] = scanner.nextInt();
                }
            }
        }
    }

    //a) El total mensual de cada tipo de flor durante el primer año
    public void calcularPorAnios(int anio) {
        for (int i = 0 ; i < tiposDeFlores; i++){
            for (int j = 0; j < meses; j++){
                System.out.println("Total del mes " + j + " del tipo de flor " + i + "del año 1: " + datos[i][j][0]);
            }
        }
    }

    // b) Total produccion durante el primer anio
    public void calcularPorFlor(int tipoFlor) {
        int suma = 0 ;
        for (int i = 0 ; i < tiposDeFlores; i++){
            for (int j = 0; j < meses; j++){
                suma += datos[i][j][0];
            }
        }
        System.out.println("\u001B[32m \n La suma del total producido del tipo de flor " + tipoFlor + " es igual a = " + suma + " $ \u001B[0m");
    }

    // c) El total de la produccion del tercer tipo de flor a lo largo del ultimo anio
    public void calcularPorMes(int mes) {
        double suma = 0 ;
        for (int j = 0 ; j < tiposDeFlores; j++){
            for (int k = 0; k < anios; k++){
                suma += datos[j][mes][k];
            }
        }
        System.out.println("\u001B[32m \n La suma de el total producido del mes " + mes + " es igual a = " + suma + " $ \u001B[0m");
    }
}
