import ContenidoMultimedia.Pelicula;
import ContenidoMultimedia.Serie;
import ControlDeExcepciones.DineroInsuficiente;
import ControlDeExcepciones.VerContenidoCuentaSinPagar;

public class Netflix {

    private Cuenta[] cuentas;
    private int contadorDeCuentas;
    private Pelicula[] peliculas;
    private int contadorDePeliculas;
    private Serie[] series;
    private int contadorDeSeries;

    public Netflix() {
        cuentas = new Cuenta[1000];
        contadorDeCuentas = 0;
        peliculas = new Pelicula[1000];
        contadorDePeliculas = 0;
        series = new Serie[1000];
        contadorDeSeries = 0;
    }

    public Pelicula regresarPeli(int numeroDePeli) {

        return peliculas[numeroDePeli];
    }


    public Cuenta crearCuenta(String nombreUsuario, String contrasenia, Suscripcion tipoDeSuscripcion, double dineroDelUsuario) throws DineroInsuficiente {
        if (dineroDelUsuario != tipoDeSuscripcion.getPrecio()) {
            throw new DineroInsuficiente();
        }
        Cuenta nuevaCuenta = new Cuenta(nombreUsuario, contrasenia, tipoDeSuscripcion);
        cuentas[contadorDeCuentas++] = nuevaCuenta;
        System.out.println("\u001B[32m" + "Felicidades!! Ahora usted tiene una cuenta " + tipoDeSuscripcion.getNombreDeSuscripcion() + "\u001B[0m");
        return nuevaCuenta;    //TODO: Preguntar a Carlos, porque el código luego del if no se ejecuta si lanzo el error
    }

    public void reproducirPelicula(Cuenta cuenta, int numeroDePelicula) {
        if (cuenta == null ) {
            try {
                throw new NullPointerException("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La cuenta no existe!!");
            } catch (NullPointerException e){
                System.out.println(e.getMessage());
                return;
            }
        }
        if (peliculas[numeroDePelicula] == null) {
            try {
                throw new NullPointerException("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La peli no está en el arreglo!!");
            } catch (NullPointerException e){
                System.out.println(e.getMessage());
                return;
            }
        }
        if (cuenta.tipoDeSuscripcion() == Suscripcion.SIN_PAGAR) {
            try {
                throw new VerContenidoCuentaSinPagar();
            } catch (VerContenidoCuentaSinPagar e){
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println("Disfurte de la peli!!!" + peliculas[numeroDePelicula]);
    }

    public void agregarPelicula(String nombrePeli, String genero) {
        Pelicula nuevaPelicula = new Pelicula(nombrePeli, genero);
        peliculas[contadorDePeliculas++] = nuevaPelicula;
        System.out.println("\u001B[32m" + "ContenidoMultimedia.Pelicula \"" + nombrePeli + "\" agregada con EXITO!!" + "\u001B[0m");
    }

    public void agregarSerie(String nombreSerie, String genero, int numTemporada, int numCapitulos) {
        Serie nuevaSerie = new Serie(nombreSerie, genero, numTemporada, numCapitulos);
        series[contadorDeSeries++] = nuevaSerie;
        System.out.println("\u001B[32m" + "ContenidoMultimedia.Serie \"" + nombreSerie + "\" agregada con EXITO!!" + "\u001B[0m");

    }

    public void reproducirSerie(Cuenta cuenta, int numSerie, int numTemporada, int numCapitulo) {
        if (cuenta == null || series[numSerie] == null ) {
            try {
                if (cuenta == null) {
                    throw new NullPointerException("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La cuenta no existe!!");
                }else {
                    throw new NullPointerException("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La serie no esta en el arreglo!!");
                }
            } catch (NullPointerException e){
                System.out.println(e.getMessage());
                return;
            }
        }
        if (cuenta.tipoDeSuscripcion() == Suscripcion.SIN_PAGAR) {
            try {
                throw new VerContenidoCuentaSinPagar();
            } catch (VerContenidoCuentaSinPagar e) {
                System.out.println(e.getMessage());
            }
            return;
        }
        System.out.println("Disfrute de la ContenidoMultimedia.Serie!!!" + series[numSerie]);
    }


    @Override
    public String toString() {
        return "Netflix:" +
                "\ncuentas = " + contadorDeCuentas + imprimirTodasLasCuentas() +
                "\n\npeliculas = " + contadorDePeliculas + imprimirTodasLasPeliculas() +
                "\n\nseries = " + contadorDeSeries + imprimirTodasLasSeries();

    }

    private String imprimirTodasLasSeries() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < contadorDeSeries; i++) {
            result.append("\n\t").append(series[i].toString());
        }
        return result.toString();
    }

    private String imprimirTodasLasPeliculas() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < contadorDePeliculas; i++) {
            result.append("\n\t").append(peliculas[i].toString());
        }
        return result.toString();
    }

    private String imprimirTodasLasCuentas() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < contadorDeCuentas; i++) {
            result.append("\n\t").append(cuentas[i].toString());
        }
        return result.toString();
    }


}
