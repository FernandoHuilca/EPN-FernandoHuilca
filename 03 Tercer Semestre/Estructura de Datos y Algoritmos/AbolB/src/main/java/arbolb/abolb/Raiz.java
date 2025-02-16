/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolb.abolb;

import java.util.*;

/**
 *
 * @author Mayrita
 */
public class Raiz {
    public static int grado;  // Grado del árbol B
    public Nodo primerNodo;  // Referencia al primer nodo (raíz) del árbol
    public static boolean esRaiz;  // Indica si es la raíz
    public static int nivel = 1;  // Nivel actual del árbol (para impresión)
    public static int imprimir = 1;  // Contador de impresión
    public static String arbol = "";  // Representación en texto del árbol

    // Constructor que inicializa el grado y el primer nodo del árbol
    public Raiz(int grado) {
        this.grado = grado;
        primerNodo = new Nodo();
        Lista llevarIngresos = new Lista();
        esRaiz = true;
    }

    // Método para insertar un valor en el árbol B
    public void insertar(int valor) {
        if (primerNodo.tengoHijos == false) {  // Si la raíz no tiene hijos
            int j = 0;
            for (int i = 0; i < primerNodo.valores.length; i++) {
                if (primerNodo.valores[i] == 0) {  // Encuentra una posición vacía
                    primerNodo.valores[i] = valor;  // Inserta el valor
                    Lista.ingresados.add(valor);  // Añade el valor a la lista de ingresados
                    j = i;
                    ordenar(primerNodo.valores, 6);  // Ordena los valores en el nodo
                    break;
                }
            }
            if (j == 2 * grado) {  // Si el nodo está lleno, hace un split
                split(primerNodo);
            }
        } else {
            setTengoHijos(primerNodo);  // Marca que la raíz tiene hijos
            ingresarEnHijos(primerNodo, valor);  // Inserta el valor en los hijos correspondientes
        }
    }

    // Método para ordenar un arreglo
    public void ordenar(int arr[], int longitud) {
        longitud = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                longitud++;
            } else {
                break;
            }
        }
        for (int ord = 0; ord < longitud; ord++) {
            for (int ord1 = 0; ord1 < longitud - 1; ord1++) {
                if (arr[ord1] > arr[ord1 + 1]) {
                    int tmp = arr[ord1];
                    arr[ord1] = arr[ord1 + 1];
                    arr[ord1 + 1] = tmp;
                }
            }
        }
    }

    // Método para marcar que un nodo tiene hijos
    public void setTengoHijos(Nodo nodo) {
        if (nodo == primerNodo) {
            if (primerNodo.nodo[0] != null) {
                primerNodo.tengoHijos = true;
            }
        }
        for (int i = 0; i < nodo.nodo.length; i++) {
            if (nodo.nodo[i] != null) {
                nodo.tengoHijos = true;
                setTengoHijos(nodo.nodo[i]);
            }
        }
    }

    // Método para insertar un valor en los hijos de un nodo
    public void ingresarEnHijos(Nodo conHijos, int valor) {
        boolean entro = false;
        if (conHijos != null && !conHijos.tengoHijos) {
            ubicarValorEnArreglo(conHijos, valor);
            entro = true;
        }
        for (int i = 0; conHijos != null && i < 2 * grado + 1 && !entro; i++) {
            if (valor < conHijos.valores[i] || conHijos.valores[i] == 0) {
                entro = true;
                ingresarEnHijos(conHijos.nodo[i], valor);
                i = 2 * grado;
            }
        }
    }

    // Método para ubicar un valor en un arreglo
    public void ubicarValorEnArreglo(Nodo nodoA, int valor) {
        int cont = 0;
        while (cont <= 2 * grado) {
            if (nodoA.valores[cont] == 0) {
                nodoA.valores[cont] = valor;
                ordenar(nodoA.valores, 5);
                Lista.ingresados.add(valor);
                if (cont == 2 * grado) {
                    split(nodoA);
                }
                break;
            }
            cont++;
        }
    }

    // Método para ordenar nodos
    public void ordenarNodos(Nodo aOrdenar) {
        int i, j;
        i = 0;
        Nodo tmp;

        while (i < 2 * grado + 3 && aOrdenar.nodo[i] != null) {
            j = 0;
            while (j < 2 * grado + 2 && aOrdenar.nodo[j] != null && aOrdenar.nodo[j + 1] != null) {
                if (aOrdenar.nodo[j].valores[0] > aOrdenar.nodo[j + 1].valores[0]) {
                    tmp = aOrdenar.nodo[j];
                    aOrdenar.nodo[j] = aOrdenar.nodo[j + 1];
                    aOrdenar.nodo[j + 1] = tmp;
                }
                j++;
            }
            i++;
        }
    }

    // Método para hacer split a un nodo
    public void split(Nodo nodo) {
        Nodo hijoIzq = new Nodo();
        Nodo hijoDer = new Nodo();

        // split general
        if (nodo.nodo[0] != null) { // si tiene hijos antes de hacer el split entonces
            for (int i = 0; i < grado + 1; i++) { // los separa los hijos del nodo en hijoIzq e hijoDer
                hijoIzq.nodo[i] = nodo.nodo[i];
                hijoIzq.nodo[i].padre = hijoIzq;
                nodo.nodo[i] = null;
                hijoDer.nodo[i] = nodo.nodo[grado + 1 + i];
                hijoDer.nodo[i].padre = hijoDer;
                nodo.nodo[grado + 1 + i] = null;
            }
        }

        for (int i = 0; i < grado; i++) { // guarda los valores en hijoIzq e hijoDer
            hijoIzq.valores[i] = nodo.valores[i];
            nodo.valores[i] = 0;
            hijoDer.valores[i] = nodo.valores[grado + 1 + i];
            nodo.valores[grado + 1 + i] = 0;
        }
        nodo.valores[0] = nodo.valores[grado];
        nodo.valores[grado] = 0; // queda en nodo solo el valor que "subió"

        nodo.nodo[0] = hijoIzq; // asigna a nodo el nuevo hijo izquierdo (hijoIzq)
        nodo.nodo[0].padre = nodo; // se hizo en primer ciclo
        nodo.nodo[1] = hijoDer; // asigna a nodo el nuevo hijo derecho (hijoDer)
        nodo.nodo[1].padre = nodo; // se hizo en el primer ciclo
        setTengoHijos(primerNodo);
        ordenarNodos(nodo);

        if (nodo.padre != null) { // luego del split y asignar los hijos (hijoIzq, hijoDer), subir el valor al padre
            boolean subido = false;
            for (int i = 0; i < nodo.padre.valores.length && subido == false; i++) {
                if (nodo.padre.valores[i] == 0) {
                    nodo.padre.valores[i] = nodo.valores[0];
                    subido = true;
                    nodo.valores[0] = 0;
                    ordenar(nodo.padre.valores, 5);
                }
            }
            int posHijos = 0;
            for (int i = 0; i < 2 * grado + 3; i++) {
                if (nodo.padre.nodo[i] != null) {
                    posHijos++;
                } else {
                    break;
                }
            }
            nodo.padre.nodo[posHijos] = nodo.nodo[0];
            nodo.padre.nodo[posHijos + 1] = nodo.nodo[1];
            nodo.padre.nodo[posHijos].padre = nodo.padre;
            nodo.padre.nodo[posHijos + 1].padre = nodo.padre;
            int aqui = 0;
            for (int i = 0; i < 2 * grado + 3 && nodo.padre.nodo[i] != null; i++) {
                if (nodo.padre.nodo[i].valores[0] == nodo.valores[0]) {
                    aqui = i;
                    break;
                }
            }
            Nodo papa = nodo.padre;
            nodo = null;
            int j = aqui;
            while (j < 2 * grado + 2 && papa.nodo[j] != null && papa.nodo[j + 1] != null) {
                papa.nodo[j] = papa.nodo[j + 1];
                j++;
            }
            papa.nodo[j] = null;
            ordenar(papa.valores, 5);
            ordenarNodos(papa);
            if (papa.valores[2 * grado] != 0) {
                split(papa);
            }
        }
    }

    // Método para eliminar un valor del árbol
    public void eliminar(int valor) { // elimina de la lista el valor y vuelve a crear el árbol
        boolean encontrado = false;
        int j = 0;
        for (int i = 0; i < Lista.ingresados.size() && !encontrado; i++) {
            if (Lista.ingresados.get(i) == valor) {
                encontrado = true;
                j = i;
            }
        }
        if (encontrado == true) {
            Lista.ingresados.remove(j);
        } else {
            System.out.println("El valor a eliminar no se encuentra en el árbol B");
        }
        ArrayList<Integer> auxiliar = Lista.ingresados;
        Lista.ingresados = new ArrayList<Integer>();
        primerNodo = new Nodo();
        primerNodo.tengoHijos = false;
        for (int k = 0; k < auxiliar.size(); k++) {
            Integer y = auxiliar.get(k);
            int o = y.intValue();
            insertar(o);
        }
    }

    // Método para buscar un valor en el árbol
    public boolean buscar(int valor) {
        boolean esta = false;
        for (int i = 0; i < Lista.ingresados.size() && !esta; i++) {
            if (Lista.ingresados.get(i) == valor) {
                esta = true;
                System.out.println("El elemento buscado sí se encuentra en el árbol B");
                return esta;
            }
        }
        System.out.println("El elemento buscado no se encuentra en el árbol B");
        return false;
    }

    // Método para recorrer el árbol y generar su representación en texto
    public String recorrer(Nodo nodo) {
        arbol += "\n";
        for (int i = 0; i < 2 * grado + 1; i++) {
            if (nodo.nodo[i] != null) {
                if (i == 0) {
                    nivel++;
                    imprimir = 1;
                } else {
                    imprimir++;
                }
                recorrer(nodo.nodo[i]);
            }
            arbol += "[ ";
            for (int j = 0; nodo.nodo[i] != null && j < nodo.nodo[i].valores.length; j++) {
                if (nodo.nodo[i].valores[j] != 0) {
                    arbol += nodo.nodo[i].valores[j] + ", ";
                }
            }
            arbol += " ]";
        }
        if (arbol.length() > (2 * grado + 3) * 4) {
            System.out.println(arbol);
            return arbol;
        }
        return arbol;
    }

    // Método para iniciar el recorrido del árbol
    public String llamarRecorrer() {
        String mostrar = recorrer(primerNodo);
        nivel = 1;
        imprimir = 1;
        return arbol;
    }

    // Método para verificar si una cadena es un número
    public boolean esNumero(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
