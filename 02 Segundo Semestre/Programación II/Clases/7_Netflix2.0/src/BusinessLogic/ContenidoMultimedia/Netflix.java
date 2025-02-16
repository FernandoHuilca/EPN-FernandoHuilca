package BusinessLogic.ContenidoMultimedia;

import BusinessLogic.ContenidoMultimedia.ControlDeExcepciones.DineroInsuficiente;
import BusinessLogic.ContenidoMultimedia.ControlDeExcepciones.VerContenidoCuentaSinPagar;

import java.util.ArrayList;

public class Netflix {

    private ArrayList<Cuenta> cuentas;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Serie> series;

    public Netflix() {
        cuentas = new ArrayList<Cuenta>();
        peliculas = new ArrayList<Pelicula>();
        series = new ArrayList<Serie>();
    }

    public Pelicula regresarPeli(int numeroDePeli) {

        return peliculas.get(numeroDePeli);
    }


    public Cuenta crearCuenta(String nombreUsuario, String contrasenia, Suscripcion tipoDeSuscripcion, double dineroDelUsuario) throws DineroInsuficiente {
        if (dineroDelUsuario != tipoDeSuscripcion.getPrecio()) {
            throw new DineroInsuficiente();
        }
        Cuenta nuevaCuenta = new Cuenta(nombreUsuario, contrasenia, tipoDeSuscripcion);
        cuentas.add(nuevaCuenta);
        System.out.println("\u001B[32m" + "Felicidades!! Ahora usted tiene una cuenta " + tipoDeSuscripcion.getNombreDeSuscripcion() + "\u001B[0m");
        return nuevaCuenta;    //TODO: Preguntar a Carlos, porque el código luego del if no se ejecuta si lanzo el error
    }

    public void reproducirPelicula(Cuenta cuenta, int numeroDePelicula) {
        if (cuenta == null) {
            try {
                throw new NullPointerException("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La cuenta no existe!!");
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        if (numeroDePelicula >= peliculas.size()) {
            try {
                throw new NullPointerException("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La peli no está en el arreglo!!");
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        if (cuenta.tipoDeSuscripcion() == Suscripcion.SIN_PAGAR) {
            try {
                throw new VerContenidoCuentaSinPagar();
            } catch (VerContenidoCuentaSinPagar e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println("Disfrute de la peli!!!" + peliculas.get(numeroDePelicula));
    }

    public void agregarPelicula(String nombrePeli, String genero) {
        peliculas.add(new Pelicula(nombrePeli, genero));
        System.out.println("\u001B[32m" + "Película \"" + nombrePeli + "\" agregada con ÉXITO!!" + "\u001B[0m");
    }

    public void agregarSerie(String nombreSerie, String genero, int numTemporada, int numCapitulos) {
        series.add(new Serie(nombreSerie, genero, numTemporada, numCapitulos));
        System.out.println("\u001B[32m" + "Serie \"" + nombreSerie + "\" agregada con EXITO!!" + "\u001B[0m");

    }

    public void reproducirSerie(Cuenta cuenta, int numSerie, int numTemporada, int numCapitulo) {
        if (cuenta == null || numSerie >= series.size()) {
            try {
                if (cuenta == null) {
                    throw new NullPointerException("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La cuenta no existe!!");
                } else {
                    throw new NullPointerException("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La serie no esta en el arreglo!!");
                }
            } catch (NullPointerException e) {
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
        System.out.println("Disfrute de la Serie!!!" + series.get(numSerie));
    }


    @Override
    public String toString() {
        return "Netflix:" +
                "\ncuentas = " + cuentas.size() + imprimirTodasLasCuentas() +
                "\n\npelículas = " + peliculas.size() + imprimirTodasLasPeliculas() +
                "\n\nseries = " + series.size() + imprimirTodasLasSeries();

    }

    private String imprimirTodasLasSeries() {
        StringBuilder result = new StringBuilder();
        for (Serie magia : series) {
            result.append("\n\t").append(magia.toString());
        }
        return result.toString();
    }

    private String imprimirTodasLasPeliculas() {
        StringBuilder result = new StringBuilder();
        for (Pelicula magia : peliculas) {
            result.append("\n\t").append(magia.toString());
        }
        return result.toString();
    }

    private String imprimirTodasLasCuentas() {
        StringBuilder result = new StringBuilder();
        for (Cuenta magia : cuentas) {
            result.append("\n\t").append(cuentas.toString());
        }
        return result.toString();
    }


}
