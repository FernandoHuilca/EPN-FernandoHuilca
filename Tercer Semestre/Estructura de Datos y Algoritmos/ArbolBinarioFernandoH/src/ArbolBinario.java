import javax.swing.*;

public class ArbolBinario {
    private Nodo apNodo; // Apuntador principal del nodo (Nodo raíz)
    private String arbol; // Impresión del árbol

    public ArbolBinario() { // Constructor del árbol binario
        super();
        this.apNodo = null; // Raíz inicia con null
        this.arbol = ""; // Árbol vacío
    }

    /*
    CrearNodoArbol(ApNodo)
    INFO, IZQ, DER <- campos Nodo
    Op <- Entero
    Crear(ApNodo)
    Leer ApNodo^.INFO
    Escribir "Desea Nodos por IZQ 1: Si 0: No"
    Leer Op
    Si (Op = 1) entonces
        Crear(ONodo)
        Hacer ApNodo^.IZQ <- ONodo
        Regresar a CrearNodoArbol(ApNodo^.IZQ)
    SiNo
        Hacer ApNodo^.IZQ <- null
    Escribir "Desea Nodos por DER 1: Si 0: No"
    Leer Op
    Si (Op = 1) entonces
        Crear(ONodo)
        Hacer ApNodo^.DER <- ONodo
        Regresar a CrearNodoArbol(ApNodo^.DER)
    SiNo
        Hacer ApNodo^.DER <- null
    FinSi
    FinCrearNodoArbol()
    */

    public void crearNodo() {
        apNodo = crearNodoAux(apNodo);
    }

    private Nodo crearNodoAux(Nodo apNodo) {
        apNodo = new Nodo();
        String valor = JOptionPane.showInputDialog("Ingrese el valor del nodo: ");
        apNodo.setINFO(Integer.parseInt(valor));

        int opción = JOptionPane.showConfirmDialog(null, "Ingrese un nodo por la izquierda del nodo " + apNodo.getINFO(), null, JOptionPane.YES_NO_OPTION);
        if (opción == JOptionPane.YES_OPTION) {
            apNodo.setIZQ(crearNodoAux(null));
        } else {
            apNodo.setIZQ(null);
        }

        opción = JOptionPane.showConfirmDialog(null, "Ingrese un nodo por la derecha del nodo " + apNodo.getINFO(), null, JOptionPane.YES_NO_OPTION);
        if (opción == JOptionPane.YES_OPTION) {
            apNodo.setDER(crearNodoAux(null));
        } else {
            apNodo.setDER(null);
        }

        return apNodo;
    }
    /*
       PREORDEN(RAIZ)
       INFO, IZQ, DER <- campos Nodo
       Si (RAIZ != null) entonces
           Visitar RAIZ "Leer INFO"
           Regresar PREORDEN(RAIZ^.IZQ)
           Regresar PREORDEN(RAIZ^.DER)
       FinSi
       FinPREORDEN()
       */
    public void recorridoPreOrden(Nodo raíz) {
        if (raíz != null) {
            JOptionPane.showMessageDialog(null, raíz.getINFO());
            recorridoPreOrden(raíz.getIZQ());
            recorridoPreOrden(raíz.getDER());
        }
    }
    /*
        INORDEN(RAIZ)
        INFO, IZQ, DER <- campos Nodo
        Si (RAIZ != null) entonces
            Regresar INORDEN(RAIZ^.IZQ)
            Visitar RAIZ "Leer INFO"
            Regresar INORDEN(RAIZ^.DER)
        FinSi
        FinINORDEN()
        */
    public void recorridoInOrden(Nodo raíz) {
        if (raíz != null) {
            recorridoInOrden(raíz.getIZQ());
            JOptionPane.showMessageDialog(null, raíz.getINFO());
            recorridoInOrden(raíz.getDER());
        }
    }
    /*
        POSORDEN(RAIZ)
        INFO, IZQ, DER <- campos Nodo
        Si (RAIZ != null) entonces
            Regresar POSORDEN(RAIZ^.IZQ)
            Regresar POSORDEN(RAIZ^.DER)
            Visitar RAIZ "Leer INFO"
        FinSi
        FinPOSORDEN()
        */
    public void recorridoPosOrden(Nodo raíz) {
        if (raíz != null) {
            recorridoPosOrden(raíz.getIZQ());
            recorridoPosOrden(raíz.getDER());
            JOptionPane.showMessageDialog(null, raíz.getINFO());
        }
    }

    // Método para obtener el nodo
    public Nodo getApNodo() {
        return apNodo;
    }

    // Método para modificar el nodo
    public void setApNodo(Nodo otroNodo) {
        apNodo = otroNodo;
    }

    @Override
    public String toString() {
        this.arbol = "";
        imprimirArbolAux(this.apNodo, 0);
        return this.arbol;
    }

    private void imprimirArbolAux(Nodo nodo, int nivel) {
        if (nodo != null) {
            imprimirArbolAux(nodo.getDER(), nivel + 1);
            for (int i = 0; i < nivel; i++) {
                this.arbol += "          ";
            }
            this.arbol += Integer.toString(nodo.getINFO()) + "\n";
            imprimirArbolAux(nodo.getIZQ(), nivel + 1);
        }
    }

}
