// Author: Fernando Huilca
// 15/06/2024

public class NodoListaCircular {
    //atributos de la clase ---------------------------------
    private String información;
    private NodoListaCircular liga;

    //Constructores con polimorfismo (sobrecarga o overloanding) ---------------------------------
    public NodoListaCircular(String información, NodoListaCircular liga) {
        this.información = información;
        this.liga = liga;
    }

    public NodoListaCircular(String información) {
        this.información = información;
        this.liga = null;
    }

    public NodoListaCircular() {
        información = null;
        liga = null;
    }

    //Getters y Setters ---------------------------------
    public String getInformación() {
        return this.información;
    }

    public void setInformación(String información) {
        this.información = información;
    }

    public NodoListaCircular getLiga() {
        return this.liga;
    }

    public void setLiga(NodoListaCircular liga) {
        this.liga = liga;
    }

}
