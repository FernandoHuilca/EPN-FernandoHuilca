
public class ColaSimple<T> {
    // Atributos
    private ListaSimple<T> datos;

    public ColaSimple() {
        this.datos = new ListaSimple<>();
    }

    // Método para agregar un pedido al final de la cola
    public boolean agregarDato(T nuevoDato) {
        return datos.agregarALaDerecha(nuevoDato);
    }

    // Método para remover un pedido del frente de la cola
    public T eliminarDato() {
        if (datos.getNúmeroDeDatos() == 0) {
            return null; // La cola está vacía
        }
        T dato = datos.getDato(0);
        datos.eliminarALaDerecha();
        return dato;
    }

    // Método para obtener el número de pedidos en la cola
    public int getNumeroDeDatos() {
        return datos.getNúmeroDeDatos();
    }

    // Método para obtener el pedido
    public T getDato(int i) {
        return datos.getDato(i);
    }

}