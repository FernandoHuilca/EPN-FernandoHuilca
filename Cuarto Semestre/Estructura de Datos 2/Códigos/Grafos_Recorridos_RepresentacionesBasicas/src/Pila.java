public class Pila<T> {

    private ListaSimple<T> datos;

    public Pila(){
        this.datos = new ListaSimple<>();
    }

    public void add(T dato) {
        this.datos.agregarALaDerecha(dato);
    }

    public T getDato(int numDato) {
        return datos.getDato(numDato);
    }

    public int getNumDeDatos() {
        return datos.getNúmeroDeDatos();
    }

    public T eliminarDato() {
        if (datos.getNúmeroDeDatos() == 0) {
            return null; // La cola está vacía
        }
        T dato = datos.getDato(0);
        datos.eliminarALaDerecha();
        return dato;
    }
}
