public class Binario extends SistemaNumerico {
    private double valor;
    public Binario(double valor) {

        this.valor = valor;
    }

    double cambiarADecimal(){ // este método vuelve de binario a double
        String dobleHecoString=Integer.toString((int)valor);
        int NumeroDecimal=Integer.parseInt(dobleHecoString,2);
        return NumeroDecimal;
    }
}
