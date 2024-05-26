import Pie.Pie;
import Zapato.Zapato;

// Author Fernando H.
public class Main {
    public static void main(String[] args) {
        Pie pie = new Pie(27);
        Pie pie2 = new Pie(41);
        Zapato zapato = new Zapato("negro", "Puma", "Cuero", 27, pie.getTalla());
        zapato.ponerZapato();
        zapato.imprimirSiLoEstanOcupando();// Sí está en uso
        zapato.atarCordones();
        zapato.imprimirSiLoEstanOcupando();// Sí está en uso
        zapato.sacarZapato();
        zapato.imprimirSiLoEstanOcupando();// Sí está en uso ERROR
        zapato.desatarCordones();
        zapato.imprimirSiLoEstanOcupando();// Sí está en uso
        zapato.sacarZapato();
        zapato.imprimirSiLoEstanOcupando();// No están en uso

        //Vamo a probar con otra talla de pie
        zapato = new Zapato("negro", "Puma", "Cuero", 27, pie2.getTalla());
        zapato.ponerZapato(); //ERROR

    }


}