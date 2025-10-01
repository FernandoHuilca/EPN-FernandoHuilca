public class Foco {
    private Boolean estadoPrendido;
    private double lumenesEmitidos = 100.0;
    public Foco() {
        estadoPrendido = false;
    }
    public void prender() {
        estadoPrendido = true;
    }
    public void apagar() {
        estadoPrendido = false;
    }
    public double getlumenesEmitidos(){
        if (estadoPrendido){
            return lumenesEmitidos;
        }else return 0;
    }


}
