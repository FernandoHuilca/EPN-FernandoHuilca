import java.util.Scanner;

// Author: Mateo Simbaña, Alison Bentacout and Fernando Huilca
public class Main {
    public static void main(String[] args) {
        // Una florícola lleva un registro del total producido mensualmente por tipo de flores:
        // La florícola consta de 6 tipos de flores y la información se ha registrado a lo largo
        // de los últimos 4 anios
        Floricola floricola = new Floricola();

        System.out.println("\u001B[31m \n __________ Ingrese los datos para el arreglo _______________ \u001B[0m");
        floricola.registrarDatos();


        System.out.println("\u001B[31m \n Ingresos del primer año: \u001B[0m");
        floricola.calcularPorAnios(1);
        System.out.println("\u001B[31m \n Ingresos del primer tipo de flor: \u001B[0m");
        floricola.calcularPorFlor(1);
        System.out.println("\u001B[31m \n Ingresos del primer mes: \u001B[0m");
        floricola.calcularPorMes(1);
    }
}