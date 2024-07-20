/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolb.abolb; // Declaración del paquete arbolb

/**
 * Clase Nodo que representa un nodo en un árbol B.
 *
 * Autor: Mayrita
 */
public class Nodo {
    // Arreglo de enteros para almacenar los valores en el nodo
    public int[] valores;

    // Arreglo de nodos para almacenar los hijos del nodo
    public Nodo[] nodo;

    // Variable estática que almacena el número de valores en el nodo
    public static int numValores;

    // Booleano para indicar si el nodo tiene hijos
    public boolean tengoHijos = false;

    // Número de posiciones ocupadas en el nodo
    public int ocupados = 0;

    // Referencia al nodo padre
    public Nodo padre;

    /**
     * Constructor de la clase Nodo
     * Inicializa los arreglos de valores y de nodos hijos
     * basado en el grado del árbol B.
     */
    public Nodo() {
        // Inicializa el arreglo de nodos hijos con tamaño basado en el grado del árbol B
        nodo = new Nodo[Raiz.grado * 2 + 3];

        // Inicializa el arreglo de valores con tamaño basado en el grado del árbol B
        valores = new int[Raiz.grado * 2 + 1];
    }
}
