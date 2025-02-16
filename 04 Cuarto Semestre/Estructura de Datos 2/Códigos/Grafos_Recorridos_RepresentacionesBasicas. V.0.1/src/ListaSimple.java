
public class ListaSimple<T> {
    // NodoGrafo de inicio de la lista
    private NodoListaSimple<T> nodoDeInicio;
    // Contador de nodos en la lista
    private int contadorDeNodos;

    // Constructor que inicializa la lista vacía
    public ListaSimple() {
        this.nodoDeInicio = null;
        this.contadorDeNodos = 0;
    }

    // Agrega un nuevo dato al inicio de la lista
    public boolean agregarALaIzquierda(T dato) {
        NodoListaSimple<T> nuevoNodo = new NodoListaSimple<>();
        nuevoNodo.setDato(dato);

        if (nodoDeInicio == null) {
            nodoDeInicio = nuevoNodo; // La lista estaba vacía, el nuevo nodo se convierte en el inicio
        } else {
            nuevoNodo.setLiga(nodoDeInicio); // El nuevo nodo apunta al antiguo inicio
            nodoDeInicio = nuevoNodo; // El nuevo nodo se convierte en el nuevo inicio
        }
        contadorDeNodos++; // Se incrementa el contador de nodos
        return true;
    }

    // Agrega un nuevo dato al final de la lista
    public boolean agregarALaDerecha(T dato) {
        NodoListaSimple<T> nuevoNodo = new NodoListaSimple<>();
        nuevoNodo.setDato(dato);

        if (nodoDeInicio == null) {
            nodoDeInicio = nuevoNodo; // La lista estaba vacía, el nuevo nodo se convierte en el inicio
        } else {
            NodoListaSimple<T> actual = nodoDeInicio;
            while (actual.getLiga() != null) {
                actual = actual.getLiga(); // Avanza al último nodo
            }
            actual.setLiga(nuevoNodo); // El último nodo apunta al nuevo nodo
        }
        contadorDeNodos++; // Se incrementa el contador de nodos
        return true;
    }

    // Devuelve el número de nodos en la lista
    public int getNúmeroDeDatos() {
        return contadorDeNodos;
    }

    // Obtiene el dato en la posición especificada
    public T getDato(int i) {
        if (i < 0 || i >= contadorDeNodos) {
            return null; // Posición inválida
        }

        NodoListaSimple<T> actual = nodoDeInicio;
        for (int j = 0; j < i; j++) {
            actual = actual.getLiga(); // Avanza a la posición deseada
        }

        return actual.getDato(); // Devuelve el dato en la posición especificada
    }

    // Elimina el nodo al inicio de la lista
    public boolean eliminarALaIzquierda() {
        if (nodoDeInicio == null) {
            return false; // La lista está vacía
        }

        nodoDeInicio = nodoDeInicio.getLiga(); // El inicio se actualiza al siguiente nodo
        contadorDeNodos--; // Se decrementa el contador de nodos
        return true;
    }

    // Elimina el nodo al final de la lista
    public boolean eliminarALaDerecha() {
        if (nodoDeInicio == null) {
            return false; // La lista está vacía
        }

        if (nodoDeInicio.getLiga() == null) {
            nodoDeInicio = null; // Solo había un nodo, ahora la lista está vacía
        } else {
            NodoListaSimple<T> actual = nodoDeInicio;
            while (actual.getLiga().getLiga() != null) {
                actual = actual.getLiga(); // Avanza al penúltimo nodo
            }
            actual.setLiga(null); // El penúltimo nodo ahora es el último
        }
        contadorDeNodos--; // Se decrementa el contador de nodos
        return true;
    }

    // Elimina el nodo en la posición especificada
    public boolean eliminarEnIndice(int i) {
        if (i < 0 || i >= contadorDeNodos) {
            return false; // Posición inválida
        }

        if (i == 0) {
            return eliminarALaIzquierda(); // Elimina el nodo al inicio si la posición es 0
        }

        NodoListaSimple<T> actual = nodoDeInicio;
        for (int j = 0; j < i - 1; j++) {
            actual = actual.getLiga(); // Avanza al nodo antes del nodo a eliminar
        }
        actual.setLiga(actual.getLiga().getLiga()); // El nodo actual apunta al siguiente del nodo a eliminar
        contadorDeNodos--; // Se decrementa el contador de nodos
        return true;
    }

    // Busca un dato en la lista y lo devuelve si lo encuentra
    public T buscarDato(T dato) {
        NodoListaSimple<T> actual = nodoDeInicio;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual.getDato(); // Devuelve el dato si lo encuentra
            }
            actual = actual.getLiga(); // Avanza al siguiente nodo
        }
        return null; // Devuelve null si no encuentra el dato
    }

    // Elimina un nodo que contiene el dato especificado
    public boolean eliminarDato(T dato) {
        if (nodoDeInicio == null) {
            return false; // La lista está vacía
        }

        if (nodoDeInicio.getDato().equals(dato)) {
            nodoDeInicio = nodoDeInicio.getLiga(); // Elimina el nodo al inicio
            contadorDeNodos--;
            return true;
        }

        NodoListaSimple<T> actual = nodoDeInicio;
        while (actual.getLiga() != null) {
            if (actual.getLiga().getDato().equals(dato)) {
                actual.setLiga(actual.getLiga().getLiga()); // Elimina el nodo en el medio
                contadorDeNodos--;
                return true;
            }
            actual = actual.getLiga(); // Avanza al siguiente nodo
        }
        return false; // El dato no fue encontrado
    }

    // Modifica un dato existente en la lista
    public boolean modificarDato(T datoActual, T nuevoDato) {
        NodoListaSimple<T> actual = nodoDeInicio;

        while (actual != null) {
            if (actual.getDato().equals(datoActual)) {
                actual.setDato(nuevoDato); // Modifica el dato
                return true; // Indica que la modificación fue exitosa
            }
            actual = actual.getLiga(); // Avanza al siguiente nodo
        }

        return false; // Devuelve false si no se encontró el dato a modificar
    }

}