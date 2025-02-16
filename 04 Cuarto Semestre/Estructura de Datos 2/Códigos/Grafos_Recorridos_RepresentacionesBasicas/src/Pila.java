public class Pila<T> {

    private ListaSimple<T> datos;

    public Pila() {
        this.datos = new ListaSimple<>();
    }

    public void add(T dato) {
        this.datos.agregarALaIzquierda(dato); // Agregar al inicio para cumplir LIFO
    }

    public T getDato(int numDato) {
        return datos.getDato(numDato);
    }

    public int getNumDeDatos() {
        return datos.getNúmeroDeDatos();
    }

    public T eliminarDato() {
        if (datos.getNúmeroDeDatos() == 0) {
            return null; // La pila está vacía
        }
        T dato = datos.getDato(0); // Obtener el dato en el inicio
        datos.eliminarALaIzquierda(); // Eliminar desde el inicio para cumplir LIFO
        return dato;
    }

    public boolean estaVacia() {
        return datos.getNúmeroDeDatos() == 0;
    }
}
