import java.util.Random;

public class CriptograficaSimetrica {
    private char[] letrasAlfabeto;
    private int[] equivalenciasAlasLetras;

    Random random = new Random();

    public CriptograficaSimetrica() {
        letrasAlfabeto = new char[25];
        for (int i = 0; i < 25; i++) {
            letrasAlfabeto[i] = (char) (97 + i);
        }
        equivalenciasAlasLetras = new int[25];
        for (int i = 0; i < 25; i++) {
            equivalenciasAlasLetras[i] = random.nextInt(300);
        }
    }


    public void enviarMensajeParaSerCriptado(String textoPlano) {
        for (int i = 0; i < textoPlano.length(); i++) {
            boolean encontrado = false;
            for (int j = 0; j < 25; j++) {
                if (textoPlano.charAt(i) == letrasAlfabeto[j]) {
                    System.out.print(equivalenciasAlasLetras[j] + " ");
                    encontrado = true;
                    break;  // No es necesario seguir buscando después de encontrar la letra
                }
            }

            if (!encontrado && textoPlano.charAt(i) == ' ') {
                System.out.print("@ ");
            }
        }
    }

    public void imprimirAlfabetoConSuClave() {
        for (int i = 0; i < 25; i++) {
            System.out.println(letrasAlfabeto[i]);
            System.out.println(equivalenciasAlasLetras[i]);
        }
    }
}
