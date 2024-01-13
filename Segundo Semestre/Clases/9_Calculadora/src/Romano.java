import java.util.HashMap;

public class Romano extends SistemaNumerico {
    private String numRomano;
    public static int convertirRomanoADecimal(String numeroRomano) {
        HashMap<Character, Integer> valores = new HashMap<>();
        valores.put('I', 1);
        valores.put('V', 5);
        valores.put('X', 10);
        valores.put('L', 50);
        valores.put('C', 100);
        valores.put('D', 500);
        valores.put('M', 1000);

        int resultado = 0;
        int previoValor = 0;

        for (int i = numeroRomano.length() - 1; i >= 0; i--) {
            char caracter = numeroRomano.charAt(i);
            int valor = valores.get(caracter);

            if (valor < previoValor) {
                resultado -= valor;
            } else {
                resultado += valor;
            }

            previoValor = valor;
        }

        return resultado;
    }
    public Romano(String numRomano) {
        this.numRomano = numRomano;
    }

    @Override
    double cambiarADecimal() {
        return convertirRomanoADecimal(numRomano);
    }
}
