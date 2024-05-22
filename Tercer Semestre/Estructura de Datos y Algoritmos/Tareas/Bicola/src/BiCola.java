import javax.swing.*;

// Clase BiCola que representa una doble cola (deque)
class BiCola {
    private String[] biCola;
    private int frente, fin, tamaño;

    // Constructor para inicializar la biCola
    public BiCola(int tamaño) {
        this.tamaño = tamaño;
        biCola = new String[tamaño];
        frente = -1;
        fin = -1;
    }

    // Método para insertar elemento al final
    public void insertarFin(String elemento) {
        if ((fin + 1) % tamaño == frente) {
            JOptionPane.showMessageDialog(null, "BiCola está llena.");
        } else {
            if (frente == -1) frente = 0;
            fin = (fin + 1) % tamaño;
            biCola[fin] = elemento;
        }
    }

    // Método para insertar elemento al frente
    public void insertarFrente(String elemento) {
        if ((frente - 1 + tamaño) % tamaño == fin) {
            JOptionPane.showMessageDialog(null, "BiCola está llena.");
        } else {
            if (frente == -1) {
                frente = 0;
                fin = 0;
            } else {
                frente = (frente - 1 + tamaño) % tamaño;
            }
            biCola[frente] = elemento;
        }
    }

    // Método para eliminar elemento del frente
    public void eliminarFrente() {
        if (frente == -1) {
            JOptionPane.showMessageDialog(null, "BiCola está vacía.");
        } else {
            if (frente == fin) {
                frente = -1;
                fin = -1;
            } else {
                frente = (frente + 1) % tamaño;
            }
        }
    }

    // Método para eliminar elemento del fin
    public void eliminarFin() {
        if (fin == -1) {
            JOptionPane.showMessageDialog(null, "BiCola está vacía.");
        } else {
            if (frente == fin) {
                frente = -1;
                fin = -1;
            } else {
                fin = (fin - 1 + tamaño) % tamaño;
            }
        }
    }

    // Método para representar la biCola como una cadena
    @Override
    public String toString() {
        if (frente == -1) {
            return "BiCola está vacía.";
        }
        StringBuilder resultado = new StringBuilder();
        int i = frente;
        while (true) {
            resultado.append(biCola[i]).append(" ");
            if (i == fin) break;
            i = (i + 1) % tamaño;
        }
        return resultado.toString();
    }
}