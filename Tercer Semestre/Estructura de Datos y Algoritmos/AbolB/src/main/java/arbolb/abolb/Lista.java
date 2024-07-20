/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolb.abolb; // Declaración del paquete arbolb

import java.util.*; // Importación de la librería java.util, necesaria para usar ArrayList

/**
 * Clase Lista que maneja una lista de enteros
 * para realizar búsquedas.
 *
 * Autor: Mayrita
 */
public class Lista {
    // Variable de instancia - una lista de enteros ingresados
    public static ArrayList<Integer> ingresados;

    /**
     * Constructor de la clase Lista
     * Inicializa la lista de enteros
     */
    public Lista() {
        ingresados = new ArrayList<Integer>();
    }

    /**
     * Método para buscar un valor en la lista
     *
     * @param valor El valor a buscar en la lista
     * @return true si el valor está en la lista, false de lo contrario
     */
    public boolean buscar(int valor) {
        boolean esta = false; // Variable para indicar si el valor está en la lista
        // Bucle para recorrer la lista
        for (int i = 0; i < ingresados.size() && !esta; i++) {
            // Si el valor en la posición i de la lista es igual al valor buscado
            if (ingresados.get(i) == valor) {
                esta = true; // Cambia la variable a true para indicar que el valor fue encontrado
            }
        }
        return esta; // Devuelve el resultado de la búsqueda
    }
}
