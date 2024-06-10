public class NodoListaSimple {
    private String información;
    private NodoListaSimple liga;
    public NodoListaSimple(String información, NodoListaSimple liga){
        this.información = información;
        this.liga = liga;
    }
    public NodoListaSimple(String información){
        this.información = información;
        this.liga = null;
    }
    public NodoListaSimple(){
        super();
    }
    public String getInformación(){
        return this.información;
    }
    public void setInformación(String información) {
        this.información = información;
    }
    public NodoListaSimple getLiga(){
        return this.liga;
    }
    public void setLiga(NodoListaSimple liga){
        this.liga = liga;
    }
}

