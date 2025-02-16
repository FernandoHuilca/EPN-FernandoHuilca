// Author: Mateo Simbaña, Alision Betancourt and Fernando Huilca

//Supongamos que se deben leer los elementos de un
//arreglo A con índices comprendidos entre el 1 y el
//30. Cuál es el algoritmo que esta estructura de
//datos necesita para especificar dicha operación

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arreglo = new int[30];
        int limiteInferior = 1;
        int limiteSuperior = 100;
        Random random = new Random();

        Scanner sc = new Scanner(System.in);

        //Escritura
        System.out.println("\n\t\u001B[34m Implementación de la Escritura de Arreglos _____________________________________________ \u001B[0m");
        for(int i = 0 ; i < 30; i++){
            arreglo[i] = i;
        }
        System.out.println("Escritura Exitosa");

        //Asignacion
        System.out.println("\n\t\u001B[34m Implementación de la Asignación de Arreglos _____________________________________________ \u001B[0m");
        for (int i = 0; i < 30; i++) {
            arreglo[i] = random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
        }
        System.out.println("Asignación Exitosa");

        //Lectura
        System.out.println("\n\t\u001B[34m Implementación de la Lectura de Arreglos _____________________________________________ \u001B[0m");
        for (int i = 0; i < 30; i++) {
            System.out.print(arreglo[i] + " ");
        }

        // Insercion
        System.out.println("\n\t\u001B[34m Implementación de la Inserción de Arreglos _____________________________________________ \u001B[0m");
        System.out.print("Escriba un nuevo elemento para asignarlo: ");
        int nuevoElemento = sc.nextInt();
        System.out.print("Escriba la posición para asignar el nuevo elemento: ");
        int posiciónDeterminada = sc.nextInt();
        arreglo[posiciónDeterminada] = nuevoElemento;


        //Eliminacion
        System.out.println("\n\t\u001B[34m Implementación de Eliminación de Arreglos _____________________________________________ \u001B[0m");
        System.out.print("Numero a eliminar: ");
        int numero = sc.nextInt();
        for (int i = 0; i < 30; i++) {
            if(arreglo[i] == numero)
                arreglo[i] = 0; // El 0 representa que el elemento del arreglo está vacío
        }



        //_________________________________ Arreglos Bidimensionales __________________________________________//

        int numFila = 5;
        int numColumna = 5;
        Scanner sc = new Scanner(System.in);
        char[][] arregloBidi = new char[numFila][numColumna];

        //Escritura
        System.out.println("\n\t\u001B[32m Implementación de la Escritura de Arreglos Bidimensional _____________________________________________ \u001B[0m");
        for(int i = 0 ; i < numFila; i++){
            for(int j = 0 ; j < numColumna; j++)
                arregloBidi[i][j] = ' ';
        }
        System.out.println("Escritura Exitosa");


        //Asignacion
        System.out.println("\n\t\u001B[34m Implementación de la Asignación de Arreglos Bidimensional _____________________________________________ \u001B[0m");
        for(int i = 0 ; i < numFila; i++){
            for(int j = 0 ; j < numColumna; j++)
                arregloBidi[i][j] = (char)((i * numColumna)+j + i + 32);
        }
        System.out.println("Asignación Exitosa");


        //Lectura
        System.out.println("\n\t\u001B[34m Implementación de la Lectura de Arreglos Bidimensional _____________________________________________ \u001B[0m");
        for(int i = 0 ; i < numFila; i++){
            for(int j = 0 ; j < numColumna; j++)
                System.out.print(arregloBidi[i][j] + " ");
            System.out.println();
        }

        // Insercion
        System.out.println("\n\t\u001B[34m Implementación de la Inserción de Arreglos Bidimensional_____________________________________________ \u001B[0m");
        System.out.print("Escriba un nuevo elemento para asignarlo: ");
        char nuevoElemento = sc.nextLine().charAt(0); //Hay que castear para que acepte char
        System.out.print("Escriba la posición de la fila para asignar el nuevo elemento: ");
        int posiciónFila = sc.nextInt();
        System.out.print("Escriba la posición de la columna para asignar el nuevo elemento: ");
        int posiciónColumna = sc.nextInt();
        arregloBidi[posiciónFila][posiciónColumna] = nuevoElemento;

        // //Eliminacion
        System.out.println("\n\t\u001B[34m Implementación de Eliminación de Arreglos Bidimensional _____________________________________________ \u001B[0m");
        System.out.print("Char a eliminar: ");
        sc.nextLine(); // Limpiar el buffer de entrada
        char charAEliminar = sc.nextLine().charAt(0);
        for(int i = 0 ; i < numFila; i++){
            for(int j = 0 ; j < numColumna; j++) {
                if (arregloBidi[i][j] == charAEliminar){
                    arregloBidi[i][j] = ' '; //El espacio significa que el elemento se ha eliminado
                }
            }
        }







    }

}