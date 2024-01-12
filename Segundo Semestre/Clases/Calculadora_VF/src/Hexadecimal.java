public class Hexadecimal extends SistemaNumerico {
    private String valor;
    public Hexadecimal(String valor) {
        this.valor = valor;
    }

    double cambiarADecimal(){ // este método vuelve de hexadecimal a double
        // encontré esto gracias :D
        int decimal = Integer.parseInt(valor, 16);
        return decimal;
    }
}