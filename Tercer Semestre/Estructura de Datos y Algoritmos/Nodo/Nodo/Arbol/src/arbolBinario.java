import javax.swing.JOptionPane;

public class arbolBinario {
    private Nodo APNODO; //Tipo de dato nodo (raíz)
    private String ARBOL; 

    public arbolBinario(){//Constructor arbol binario
        super();
        this.APNODO= null;
        this.ARBOL= "";
    }
    public void crearNodos(){
        APNODO = crearNodoAux(APNODO);
    }
    public Nodo crearNodoAux (Nodo APNODO){
        APNODO= new Nodo();
        String valor = JOptionPane.showInputDialog("Ingrese el valor del nodo");
        APNODO.setINFO(Integer.parseInt(valor));
        int opcion = JOptionPane.showConfirmDialog(null, "Ingresar un nodo por la izquierda del nodo" + APNODO.getINFO()); //Pregunta si quiero meter por la izquierda 
        if (opcion== JOptionPane.YES_OPTION){
            APNODO.setIZQ(crearNodoAux(APNODO.getIZQ()));
        }
        opcion= JOptionPane.showConfirmDialog(null, "Ingresar un nodo por la derecha del nodo" +APNODO.getINFO());
        if (opcion== JOptionPane.YES_NO_OPTION){ //Posible error 
            APNODO.setDER(crearNodoAux(APNODO.getDER()));
        }
        return APNODO; 
    }
/**
 * 
 * @param raiz : variable del nodo que se irá visitando
 * Funcion para el recorrido pre orden
 * 
 * Algoritmo:
 * PreOrden(Raiz)
 * Info, Der, Izq <- camposNodo
 * Si(Raiz != null) entonces
 *      visitarRaiz "Leer info"
 *      Regresar PreOrden (Raiz^. Izq) 
 *      Regresar PreOrden (Raiz^.Der)
 * Fin Si
 * Fin PreOrden
 * 
 */
    public void recorridoPreOrden(Nodo raiz){
            if(raiz != null){
                JOptionPane.showMessageDialog(null, raiz.getINFO());
                recorridoPreOrden(raiz.getIZQ());
                recorridoPreOrden(raiz.getDER()); 
            }
    }
/**
 * 
 * @param raiz : variable del nodo que se irá visitando
 * Función para el recorrido in orden
 * 
 * Algoritmo:
 * InOrden(Raiz)
 * Info, Der ,Izq <- camposNodo
 * Si (Raiz != null) entonces
 *      Llamar InOrden (Raiz^.Izq)
 *      Visitar Raiz "Leer info"
 *      Llamar InOrden (Raiz^.Der)
 *Fin Si
*Fin InOrden()
 */
    public void recorridoInOrden(Nodo raiz){
        if(raiz!=null){
            recorridoInOrden(raiz.getIZQ());
            JOptionPane.showMessageDialog(null, raiz.getINFO());
            recorridoInOrden(raiz.getDER());
        }
    }

    /**
     * 
     * @param raiz : variable del nodo que se irá visitando
     * Función para el recorrido pos orden
     * 
     * Algoritmo:
     * PosOrden(Raiz)
     * Info, Der, Izq <- camposNode
     * Si (Raiz != null) entonces
     *      Llamar PosOrden (Raiz^.Izq)
     *      Llamar PosOrden (Raiz^.Der)
     *      Visitar Raiz "Leer info"
     * Fin Si
     * Fin PosOrden
     */
    public void recorridoPosOrden(Nodo raiz){
        if(raiz !=null){
            recorridoPosOrden(raiz.getIZQ());
            recorridoPosOrden(raiz.getDER());
            JOptionPane.showMessageDialog(null, raiz.getINFO());
        }
    }

    /**
     * Funcion para obtener un nodo del árbol
     */
    public Nodo getNodo(){
        return APNODO;
    }
    public void setAPNODO(Nodo aPNODO){
        APNODO = APNODO;
    }
/**
 * Transforma el objeto arbol en string
 */
    public String toString(){
        this.ARBOL= " ";
        imprimirArbolAux(this.APNODO,0);
        return this.ARBOL;
    }

public void imprimirArbolAux(Nodo nodo, int nivel){
    if(nodo!=null){
        imprimirArbolAux(nodo.getDER(), nivel+1);
        for(int i=0; i < nivel; i++){
            this.ARBOL += "        ";
        }
        this.ARBOL+= Integer.toString(nodo.getINFO())+ "\n";
        imprimirArbolAux(nodo.getIZQ(), nivel+1);
    }
}




    }

