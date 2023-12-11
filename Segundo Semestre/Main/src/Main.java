import LavadoDeAutos.LavadoDeAutos;
import Limpieza.Lavado;

public class DetalleAutos {
    public static void main(String[] args) {
        LavadoDeAutos limpieza = new LavadoDeAutos();
        LavadoDeAutos tiposDeLavado = new LavadoDeAutos(
                new Lavado("Limpieza exterior", "Pequeño", 20),
                new Lavado("(Limpieza interior y exterior", "Normal"40),
                new Lavado("Limpieza interior, exterior y motor", "Grande", 60),

                );
        Cliente registro = new Cliente();
        new Cliente("Juan", 100),

        limpieza.escoger(new Lavado("Limpieza exterior", "pequeño", 20));
        System.out.println(limpieza);

        Juan autoDeJuan = limpieza.escogerTipoDelavado();

        autoDeJuan.iniciarElTipoDeLavado(limpieza.iniciarLavado("Limpieza exterior", "Pequeño", 25),
                limpieza.iniciarLavado("Limpieza exterior", "Pequeño", 23));

        System.out.println(limpieza);

    }
}


//Cree un programa que este enfocado a una empresa de lavado de autos donde
// se ofrece varios tipos de lavados con precios deferentes ,  donde se pueda imprimir la factura del lavado