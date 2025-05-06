import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Random rand = new Random();
    public static void main(String[] args) {

        MazoJuego mazoJuego = new MazoJuego(1);
        mazoJuego.barajar(mazoJuego.getListaDeCartas(), 1);
        BlackJack bj = new BlackJack();
        bj.jugar(mazoJuego, 100);
      




        /*



        ArrayList<String> mazo = new ArrayList<String>();
        llenarMazo(mazo);
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            System.out.print("Ingrese 1 para sacar una carta al azar: ");
            opcion = entrada.nextInt();
            if (opcion == 1) {
                System.out.println("Carta retirada del mazo: " + quitarCartaAzar(mazo));
            }
        } while (opcion != 0);

        for (int i = 0; i < mazo.size(); i++) {
            System.out.println(mazo.get(i));
        }

    }

    private static String quitarCartaAzar(ArrayList<String> mazo) {
        if (mazo.isEmpty()) {
            return "Mazo vacio";
        }
        int numAzar = rand.nextInt(mazo.size());
        return mazo.remove(numAzar);
    }

    private static void llenarMazo(ArrayList<String> mazo) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < 4; j++) {
                mazo.add(i + "");
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                switch (i) {
                    case 0:
                        mazo.add("J" + "");
                        break;
                    case 1:
                        mazo.add("Q" + "");
                        break;
                    case 2:
                        mazo.add("K" + "");
                    break;
                }
            }
        }*/
    }
}