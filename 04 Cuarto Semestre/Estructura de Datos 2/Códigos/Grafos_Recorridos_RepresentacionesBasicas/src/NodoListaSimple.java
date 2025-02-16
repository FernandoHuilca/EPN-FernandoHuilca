
// Aplicamos el concepto de Genérico
public class NodoListaSimple<TIPO> {

    private TIPO tipo;  // Almacena el dato de tipo genérico
    private NodoListaSimple<TIPO> liga;  // Referencia al siguiente nodo en la lista simple

    // Aplicamos Polimorfismo en los constructores
    // Constructor con dato y referencia al siguiente nodo
    public NodoListaSimple(TIPO tipo, NodoListaSimple<TIPO> liga){
        this.tipo = tipo;
        this.liga = liga;
    }

    // Constructor con solo dato, referencia al siguiente nodo se establece como null
    public NodoListaSimple(TIPO tipo){
        this.tipo = tipo;
        this.liga = null;
    }

    // Constructor sin parámetros, inicializa el nodo con valores por defecto
    public NodoListaSimple(){
        super();
    }

    // Método para obtener el dato almacenado en el nodo
    public TIPO getDato(){
        return this.tipo;
    }

    // Método para establecer el dato almacenado en el nodo
    public void setDato(TIPO tipo) {
        this.tipo = tipo;
    }

    // Método para obtener la referencia al siguiente nodo
    public NodoListaSimple<TIPO> getLiga(){
        return this.liga;
    }

    // Método para establecer la referencia al siguiente nodo
    public void setLiga(NodoListaSimple<TIPO> liga){
        this.liga = liga;
    }
}