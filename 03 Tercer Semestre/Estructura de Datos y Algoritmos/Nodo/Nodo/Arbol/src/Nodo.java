public class Nodo {
    private Integer INFO;
    private Nodo DER;
    private Nodo IZQ;

    /**
     *  Construtor de partes del nodo 
     * @param INFO dato del nodo
     * @param DER derecha del nodo
     * @param IZQ izquierda del nodo
     */
    public Nodo (Integer INFO, Nodo  DER, Nodo IZQ) {
        this.INFO = INFO; //Asigna el valor del nodo
        this.DER = DER; //Asigna la referencia del lado derecho
        this.IZQ= IZQ; //Asigna la referencia del lado izquierdo
    }
    /**
     * Constructor que inicializa un nodo vacio
     */
    public Nodo () {
        super();
        this.INFO= INFO;
        this.IZQ= null;
        this.DER= null;
    }
    /**
     * Metodo que tiene el valor del nodo
     * @return el valor del nodo (o info)
     */
    public Integer getINFO() {
        return INFO;
    }
    /**
     * Metodo para establecer la referencia al nodo izq
     * @param INFO el nuevo valor 
     */
    public void setINFO(Integer INFO) {
        this.INFO = INFO; //Asigna un nuevo valor al nodo 
    }
    /**
     * Metodo para tener la referencia del nodo izq
     * @return izq
     */
    public Nodo getIZQ() {
        return IZQ;
    }
    /**
     * Metodo para tener la referencia del nodo der
     * @return der
     */
    public Nodo getDER() {
        return DER;
    }
    /**
     * Metodo para establecer el nuevo valor izq
     * @param IZQ
     */
    public void setIZQ(Nodo IZQ) {
        this.IZQ= IZQ; //Nuevo valor al nodo izq
    }
    /**
     * Metodo para establecer el nuevo valor der
     * @param DER
     */
    public void setDER(Nodo DER) {
        this.DER= DER; //Nuevo valor al nodo der
    }
}
