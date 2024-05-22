import javax.swing.*;

public class ColaCircular {
    // Atributos de la clase:
    private int frente;
    private int fin;
    private int maximo;
    private String[] colaCircular; // En este ejemplo vamos a usar una cola de tipo String, pero es aplicable en cualquier tipo de dato

    public ColaCircular(int tamanioCola) { // Constructor de la clase colaCircular que recibe parámetro el tamanio
        colaCircular = new String[tamanioCola];
        maximo = tamanioCola - 1;
        frente = -1;
        fin = -1;
    }

    public void insertarDato(String dato) {
       if (colaEstáLlena()) {
            JOptionPane.showMessageDialog(null, "La cola está llena. Existe desbordamiento.");
        } else {
            if (colaEstáVacía()) { // Si la cola está vacía, inicializar frente y fin a 0
                frente = 0;
                fin = 0;
            } else if (fin == maximo) { // Si fin llega al final del arreglo, retroceder al principio
                fin = 0;
            } else {
                fin++; // Incrementar fin después de la inserción
            }
            colaCircular[fin] = dato; // Insertar el dato en la posición fin
        }
    }

    /*
    incio AlgoritmoInsertarDato
            si(colaEstáLlena())
                Escribir "La cola está llena. Desbor"
            Sino Si (fin = max)
                fin = 0
                sino fin++
                colaCircular[fin] <- Dato
    Fin AlgoritmoInsertarDato
     */

    public void eliminarDato() {
        if (colaEstáVacía()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía. No se puede eliminar nada.");
        } else {
            colaCircular[frente] = null; // Eliminar el dato en la posición frente
            if (frente == fin) { // Si solo hay un elemento en la cola, reiniciar frente y fin
                frente = -1;
                fin = -1;
            } else if (frente == maximo) { // Si frente llega al final del arreglo, retroceder al principio
                frente = 0;
            } else {
                frente++; // Avanzar frente después de la eliminación
            }
        }
    }

    // Métodos de apoyo adicionales
    private boolean colaEstáVacía() {
        return frente == -1;
    }

    private boolean colaEstáLlena() {
        return (frente == 0 && fin == maximo) || (fin + 1 == frente);
    }

    // Método para convertir la cola a una cadena para su visualización
    public String toString() {
        String salida = "";
        // Recorre la cola y construye la cadena de salida
        for (int i = 0; i < this.colaCircular.length; i++) {
            salida += this.colaCircular[i] + " | ";
        }
        return salida;
    }
}
