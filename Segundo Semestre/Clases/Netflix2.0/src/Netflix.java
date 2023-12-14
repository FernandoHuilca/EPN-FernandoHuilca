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


    public Cuenta crearCuenta(String nombreUsuario, String contrasenia, Suscripcion tipoDeSuscripcion, double dineroDelUsuario) {
        if (dineroDelUsuario != tipoDeSuscripcion.getPrecio()) {
            System.out.println("\u001B[31m" + "ERROR:" + "\u001B[0m" + " el dinero depositado no es el correcto!!");
            return null;
        }
        Cuenta nuevaCuenta = new Cuenta(nombreUsuario, contrasenia, tipoDeSuscripcion);
        cuentas[contadorDeCuentas++] = nuevaCuenta;
        System.out.println("\u001B[32m" + "Felicidades!! Ahora usted tiene una cuenta " + tipoDeSuscripcion.getNombreDeSuscripcion() + "\u001B[0m");
        return nuevaCuenta;
    }

    public void reproducirPelicula(Cuenta cuenta, int numeroDePelicula) {
        if (cuenta == null) {
            System.out.println("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La cuenta no existe!!");
            return;
        }
        if (peliculas[numeroDePelicula] == null){
            System.out.println("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La peli no esta en el arreglo!!");
            return;
        }
        if (cuenta.tipoDeSuscripcion() == Suscripcion.SIN_PAGAR) {
            System.out.println("\u001B[31m" + "ERROR: " + "\u001B[0m" + " Su cuenta no tiene una suscripcion valida para ver pelis o series!!" );
            return;
        }
        System.out.println("Disfurte de la peli!!!" + "\n\t nombreDeLaPeli: " + peliculas[numeroDePelicula].getNombre()
                + "\n\t Genero: " + peliculas[numeroDePelicula].getGenero());
    }

    public void agregarPelicula(String nombrePeli, String genero) {
        Pelicula nuevaPelicula = new Pelicula(nombrePeli, genero);
        peliculas[contadorDePeliculas++] = nuevaPelicula;
        System.out.println("\u001B[32m" + "Pelicula \"" + nombrePeli + "\" agregada con EXITO!!" + "\u001B[0m");
    }

    public void agregarSerie(String nombreSerie, String genero, int numTemporada, int numCapitulos) {
        Serie nuevaSerie = new Serie(nombreSerie, genero, numTemporada, numCapitulos);
        series[contadorDeSeries++] = nuevaSerie;
        System.out.println("\u001B[32m" + "Serie \"" + nombreSerie + "\" agregada con EXITO!!" + "\u001B[0m");

    }

    public void reproducirSerie(Cuenta cuenta, int numSerie, int numTemporada, int numCapitulo) {
        if (cuenta == null) {
            System.out.println("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La cuenta no existe!!");
            return;
        }
        if (series[numSerie] == null){
            System.out.println("\u001B[31m" + "ERROR:" + "\u001B[0m" + " La serie no esta en el arreglo!!");
            return;
        }
        if (cuenta.tipoDeSuscripcion() == Suscripcion.SIN_PAGAR) {
            System.out.println("\u001B[31m" + "ERROR: " + "\u001B[0m" + " Su cuenta no tiene una suscripcion valida para ver pelis o series!!" );
            return;
        }
        System.out.println("Disfurte de la Serie!!!"  + series[numSerie]);
    }
}
