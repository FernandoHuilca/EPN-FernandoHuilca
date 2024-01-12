
public class Octal extends SistemaNumerico {
    private double valor;
    public Octal(double valor) {
        this.valor = valor;
    }
    double cambiarADecimal(){ // este método vuelve de octal a decimal (Aunque en específico devuelve un int
        int decimal = Integer.parseInt(Integer.toString((int)valor), 8);

        return decimal;
    }
}

/*
pruebale ese
int decimal = Integer.parseInt(hexadecimal, 16);
 */


