import javax.swing.*;
import java.util.Objects;

// Author: Fernando Huilca
// 15/06/2024

public class ListaCircular {
    //Vamos a ocupar los siguiente atributos
    private NodoListaCircular nodoInicio;
    private NodoListaCircular nodoAuxiliarA;
    private NodoListaCircular nodoAuxiliarB;

    //El siguiente es el constructor
    public ListaCircular() {
        nodoInicio = new NodoListaCircular();
        nodoAuxiliarA = new NodoListaCircular();
        nodoAuxiliarB = new NodoListaCircular();
    }

    /*
    CrearNodosIncioListaCircular() //Izquierda
    Inicio, AuxA, AuxB
    opción
    Crear nodoInicio
    Leer Inicio^Info <-- dato
    Inicio^Liga <- Inicio
    Crear nodoA
    A = Inicio
    Escribir "Desea más nodos?"
    Mientras(opción = 1 )
        Crear nodoB
        Leer nodoB^Info <-- dato
        NodoB^Liga <-- nodoInicio
           nodoA^liga <-- nodoB
        nodoInicio = nodoB
        Escribir "Desea más nodos?"
    Fin Mientras
    Fin CrearNodosInicioListaCircular()
        * */
    // método que va a crear nodos desde cero hacia la derecha
    public void crearNodosFinalListaCircular() {
        this.nodoInicio = new NodoListaCircular();
        this.nodoInicio.setInformación(JOptionPane.showInputDialog("Ingrese la información del primer nodo: "));
        this.nodoInicio.setLiga(nodoInicio);
        //Vamos a usar para crear más nodos
        nodoAuxiliarA = new NodoListaCircular();
        nodoAuxiliarA = this.nodoInicio;

        int opcion = JOptionPane.showConfirmDialog(null, "Desea ingresar más nodos: ");
        while (opcion == JOptionPane.YES_NO_OPTION) {
            nodoAuxiliarB = new NodoListaCircular();
            nodoAuxiliarB.setInformación(JOptionPane.showInputDialog("Ingrese la información del siguiente nodo: "));
            //apuntar circularmente
            nodoAuxiliarB.setLiga(nodoInicio);
            // Hacer que se pueda volver al ciclo
            nodoAuxiliarA.setLiga(nodoAuxiliarB);
            this.nodoAuxiliarA = nodoAuxiliarB;
            opcion = JOptionPane.showConfirmDialog(null, "Desea ingresar más nodos: ");
        }
    }

    /*
    * CrearNodosFinalListaCircular() //por la derecha
    Inicio, AuxA, AuxB
    opción
    Crear nodoInicio
    Leer Inicio^Info <-- dato
    Inicio^Liga <- Inicio
    Crear nodoA
    A = Inicio
    Escribir "Desea más nodos?"
    Mientras(opción = 1 )
        Crear nodoB
        Leer nodoB^Info <-- dato
        NodoB^Liga <-- nodoInicio
        nodoA^liga <-- nodoB
        nodoA = nodoB
        Escribir "Desea más nodos?"
    Fin Mientras
    Fin CrearNodosFinalListaCircular()
    * */
    // método que va a crear nodos desde cero hacia la Izquierda
    public void crearNodosInicioListaCircular() {
        this.nodoInicio = new NodoListaCircular();
        this.nodoInicio.setInformación(JOptionPane.showInputDialog("Ingrese la información del primer nodo: "));
        this.nodoInicio.setLiga(nodoInicio);
        //Vamos a usar para crear más nodos
        nodoAuxiliarA = new NodoListaCircular();
        nodoAuxiliarA = this.nodoInicio;

        int opcion = JOptionPane.showConfirmDialog(null, "Desea ingresar más nodos: ");
        while (opcion == JOptionPane.YES_NO_OPTION) {
            nodoAuxiliarB = new NodoListaCircular();
            nodoAuxiliarB.setInformación(JOptionPane.showInputDialog("Ingrese la información del siguiente nodo: "));
            //Apuntar al siguiente
            nodoAuxiliarB.setLiga(nodoInicio);
            //Cerrar para hacer que sea circular
            nodoAuxiliarA.setLiga(nodoAuxiliarB);
            this.nodoInicio = nodoAuxiliarB;
            opcion = JOptionPane.showConfirmDialog(null, "Desea ingresar más nodos: ");
        }
    }


    public void insertarNodoPorElInicio() {
        NodoListaCircular nodoAux = new NodoListaCircular();
        if (!estáLaListaCircularVacía()) {
            nodoAux.setInformación(JOptionPane.showInputDialog("Ingrese la información del nuevo nodo: "));
            nodoAux.setLiga(nodoInicio);
            nodoAuxiliarA.setLiga(nodoAux);
            nodoInicio = nodoAux;
        } else {
            JOptionPane.showMessageDialog(null, "La lista está vacía. Primero debe crear la lista.");
        }
    }


    public void insertarNodoPorElFinal() {
        NodoListaCircular nodoAux = new NodoListaCircular();
        if (!estáLaListaCircularVacía()) {
            nodoAux.setInformación(JOptionPane.showInputDialog("Ingrese la información del nuevo nodo: "));
            nodoAux.setLiga(nodoInicio);
            nodoAuxiliarA.setLiga(nodoAux);
            nodoAuxiliarA = nodoAux;
        } else {
            JOptionPane.showMessageDialog(null, "La lista está vacía. Primero debe crear la lista.");
        }
    }


    public String eliminarNodoInicio() {
        String aux = nodoInicio.getInformación();
        if (estáLaListaCircularVacía()) {
            return nodoInicio.getInformación() + " \nLa lista está vacía. Primero debe crear la lista.\n";
        } else if (laListaTieneUnElemento()) {
            eliminarLista();
            return aux + "\nLa lista tenía un solo elemento, ahora está vacía\n";
        } else {
            nodoAuxiliarA.setLiga(nodoInicio.getLiga());
            nodoInicio = nodoInicio.getLiga();
            return aux;
        }
    }

    public String eliminarNodoFinal() {
        if (estáLaListaCircularVacía()) {
            return "\nLa lista está vacía. Primero debe crear la lista.\n";
        } else if (laListaTieneUnElemento()) {
            String infoElementoEliminado = nodoInicio.getInformación();
            eliminarLista();
            return infoElementoEliminado + " \nLa lista tenía un solo elemento, ahora está vacía\n";
        } else {
            NodoListaCircular aux = nodoInicio;
            while (aux.getLiga() != nodoAuxiliarA) {
                aux = aux.getLiga();
            }
            String infoElementoEliminado = nodoAuxiliarA.getInformación();
            aux.setLiga(nodoInicio);
            nodoAuxiliarA = aux;
            return infoElementoEliminado;
        }
    }


    private void eliminarLista() {
        nodoInicio.setLiga(null);
        nodoInicio.setInformación(null);
        nodoAuxiliarB.setLiga(null);
        nodoAuxiliarB.setInformación(null);
        nodoAuxiliarA.setLiga(null);
        nodoAuxiliarA.setInformación(null);
    }

    public void recorrerLista() {
        int contador = 0;
        if (estáLaListaCircularVacía()) {
            System.out.println("La lista circular está vacía");
            return;
        }

        NodoListaCircular aux = nodoInicio;
        do {
            contador++;
            JOptionPane.showMessageDialog(null, contador + "  " + aux.getInformación());
            aux = aux.getLiga();
        } while (aux != nodoInicio);
    }


    public void buscarElementoListaCircular() {
        int posicionDelElementoBuscado = 1;  // Inicializar la posición
        if (estáLaListaCircularVacía()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía. Primero debe crear la lista.");
        } else {
            String elementoABuscar = JOptionPane.showInputDialog("Ingrese la información del nodo que desea buscar: ");
            NodoListaCircular nodoAuxiliar = nodoInicio;
            boolean encontrado = false;

            // Recorrer la lista circular
            do {
                if (nodoAuxiliar.getInformación().equals(elementoABuscar)) {
                    encontrado = true;
                    break;
                }
                nodoAuxiliar = nodoAuxiliar.getLiga();
                posicionDelElementoBuscado++;
            } while (nodoAuxiliar != nodoInicio);

            if (encontrado) {
                JOptionPane.showMessageDialog(null, "El elemento '" + elementoABuscar + "' está en la posición: " + posicionDelElementoBuscado);
            } else {
                JOptionPane.showMessageDialog(null, "El elemento '" + elementoABuscar + "' no se encuentra en la lista.");
            }
        }
    }

    private boolean laListaTieneUnElemento() {
        return nodoInicio.getLiga() == nodoInicio;
    }


    private boolean estáLaListaCircularVacía() {
        return nodoInicio.getLiga() == null;
    }

    public String toString() {

        NodoListaCircular aux;
        String salida = "";
        aux = this.nodoAuxiliarA.getLiga();
        if (this.nodoAuxiliarA.getLiga() != null) {
            do {
                salida += aux.getInformación() + "  ";
                aux = aux.getLiga();
            } while (aux != this.nodoAuxiliarA.getLiga());
            return salida;
        }
        return "La listaCircular está vacía";

    }

}
