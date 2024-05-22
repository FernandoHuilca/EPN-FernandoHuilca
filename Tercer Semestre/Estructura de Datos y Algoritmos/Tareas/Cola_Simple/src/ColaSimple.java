import javax.swing.*;
import java.util.concurrent.atomic.AtomicReference;

public class ColaSimple {
    // Declaración de variables de instancia
    private String cola[];
    private int frente = -1;
    private int fin = -1;

    // Constructor por defecto
    public ColaSimple() {
        super();
    }

    // Constructor que inicializa la cola con una dimensión específica
    public ColaSimple(int dimension) {
        this.cola = new String[dimension];
    }

    // Método getter para obtener el arreglo cola
    public String[] getCola() {
        return cola;
    }

    // Método setter para establecer un nuevo arreglo cola
    public void setCola(String[] cola) {
        this.cola = cola;
    }

    // Método para insertar elementos en la cola
    public void insertarCola(String nombre) {
        // Verifica si la cola está llena
        if (this.fin + 1 == this.cola.length) {
            JOptionPane.showMessageDialog(null, "La cola está llena. Existe desbordamiento.");
        } else {
            // Incrementa el índice fin y agrega el elemento
            this.fin++;
            this.cola[this.fin] = nombre;
            // Si es el primer elemento, ajusta el índice frente
            if (this.fin == 0) {
                this.frente = 0;
            }
        }
    }

    // Método para eliminar elementos de la cola
    public void eliminarElemento() {
        // Verifica si la cola está vacía
        if (this.frente == -1) {
            JOptionPane.showMessageDialog(null, "La cola está vacía. No hay elementos en la cola.");
        } else {
            // Si hay un solo elemento, lo elimina y resetea la estructura
            if (this.frente == this.fin) {
                this.cola[this.frente] = null;
                this.frente = -1;
                this.fin = -1;
            } else {
                // Elimina el elemento y avanza el índice frente
                this.cola[this.frente] = null;
                this.frente++;
            }
        }
    }

    // Método para convertir la cola a una cadena para su visualización
    public String toString() {
        String salida = "";
        // Recorre la cola y construye la cadena de salida
        for (int i = 0; i < this.cola.length; i++) {
            salida += this.cola[i] + " | ";
        }
        return salida;
    }
}












