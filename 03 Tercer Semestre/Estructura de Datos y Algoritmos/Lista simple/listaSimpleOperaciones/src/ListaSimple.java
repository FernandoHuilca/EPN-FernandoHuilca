import javax.swing.*;

public class ListaSimple {
    private NodoListaSimple nodoDeInicio;
    private NodoListaSimple nodoAuxiliar1;
    private NodoListaSimple nodoAuxiliar2;

    public ListaSimple() {
        super();
    }

    public void crearNodoInicioLista() {
        this.nodoDeInicio = new NodoListaSimple();
        this.nodoDeInicio.setInformación(JOptionPane.showInputDialog("Ingrese el nombre del primer nodo: "));
        this.nodoDeInicio.setLiga(null);

        int opcion = JOptionPane.showConfirmDialog(null, "Desea ingresar más nodos: ");
        while (opcion == JOptionPane.YES_NO_OPTION) {
            nodoAuxiliar1 = new NodoListaSimple();
            nodoAuxiliar1.setInformación(JOptionPane.showInputDialog("Ingrese el nombre del siguiente nodo: "));
            nodoAuxiliar1.setLiga(nodoDeInicio);
            this.nodoDeInicio = this.nodoAuxiliar1;
            opcion = JOptionPane.showConfirmDialog(null, "Desea ingresar más nodos: ");
        }
    }

    public void crearNodoFinalLista() {
        this.nodoDeInicio = new NodoListaSimple();
        this.nodoDeInicio.setInformación(JOptionPane.showInputDialog("Ingrese el nombre del 1er nodo"));
        this.nodoDeInicio.setLiga(null);
        this.nodoAuxiliar2 = this.nodoDeInicio;
        int opcion = JOptionPane.showConfirmDialog(null, "Desea ingresar mas nodos?");
        while (opcion == JOptionPane.YES_OPTION) {
            NodoListaSimple aux = new NodoListaSimple();
            aux.setInformación(JOptionPane.showInputDialog("Ingrese el nombre del siguiente nodo"));
            aux.setLiga(null);
            this.nodoAuxiliar2.setLiga(aux);
            this.nodoAuxiliar2 = aux;
            opcion = JOptionPane.showConfirmDialog(null, "Desea ingresar mas nodos?");
        }
    }

    public void insertarNodoInicio() {

        this.nodoAuxiliar1 = new NodoListaSimple();
        this.nodoAuxiliar1.setInformación(JOptionPane.showInputDialog("Ingrese el nombre de nodo"));
        this.nodoAuxiliar1.setLiga(this.nodoDeInicio);
        this.nodoDeInicio = this.nodoAuxiliar1;
    }

    public void insertarNodoFinal() {
        if (nodoDeInicio == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía. Primero debe crear la lista.");
        } else {
            this.nodoAuxiliar2 = this.nodoDeInicio;
            while (this.nodoAuxiliar2.getLiga() != null) {
                this.nodoAuxiliar2 = nodoAuxiliar2.getLiga();
            }

            this.nodoAuxiliar1 = new NodoListaSimple();
            this.nodoAuxiliar1.setInformación(JOptionPane.showInputDialog("Ingrese el nombre del nodo"));
            this.nodoAuxiliar1.setLiga(null);
            this.nodoAuxiliar2.setLiga(this.nodoAuxiliar1);
        }
    }

    public void recorrer2() {
        nodoAuxiliar1 = this.nodoDeInicio;
        if (nodoAuxiliar1 == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
        } else {
            StringBuilder listaRecorrida = new StringBuilder();
            while (nodoAuxiliar1 != null) {
                listaRecorrida.append(nodoAuxiliar1.getInformación()).append("\n");
                nodoAuxiliar1 = nodoAuxiliar1.getLiga();
            }
            JOptionPane.showMessageDialog(null, "Lista recorrida:\n" + listaRecorrida.toString());
            JOptionPane.showMessageDialog(null, "La lista ha sido recorrida completamente.");
        }
    }

    public void recorrer() {
        nodoAuxiliar1 = this.nodoDeInicio;
        while (nodoAuxiliar1 != null) {
            JOptionPane.showMessageDialog(null, nodoAuxiliar1.getInformación());
            nodoAuxiliar1 = nodoAuxiliar1.getLiga();
        }
    }

    public void eliminarNodoInicio() {
        nodoAuxiliar1 = nodoDeInicio;
        if (this.nodoAuxiliar1.getLiga() == null) {
            this.nodoDeInicio = null;
        } else {
            this.nodoDeInicio = nodoAuxiliar1.getLiga();
        }
    }

    public void buscarListaS() {
        NodoListaSimple q = nodoDeInicio;
        String o = JOptionPane.showInputDialog("Ingrese el carácter a buscar");
        int posicion = 1; // Contador para la posición

        while (q != null && !q.getInformación().equals(o)) {
            q = q.getLiga();
            posicion++;
        }

        if (q != null) {
            JOptionPane.showMessageDialog(null, "Valor encontrado: " + o + " en la posición: " + posicion);
        } else {
            JOptionPane.showMessageDialog(null, "Valor no encontrado: " + o);
        }
    }

    public String toString() {

        NodoListaSimple aux;
        String salida = "";
        aux = this.nodoDeInicio;

        while (aux != null) {
            salida += aux.getInformación() + "\n";
            aux = aux.getLiga();
        }
        return salida;
    }

    //eliminar que falta
    public void eliminarAlFinal() {
        NodoListaSimple aux1 = this.nodoDeInicio;//new NodoListaSimple(this.nodoDeInicio.getInformación(), this.nodoDeInicio.getLiga());
        NodoListaSimple aux2 = new NodoListaSimple();

        if (aux1.getLiga() == null) {
            nodoDeInicio = null;
            return;
        }
        while (aux1.getLiga() != null) {
            aux2 = aux1;
            aux1 = aux1.getLiga();
        }
        aux2.setLiga(null);
        aux1.setLiga(null);
        aux1 = null;
    }
}
