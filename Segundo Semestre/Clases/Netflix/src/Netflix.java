public class Netflix {
    private Cuenta[] cuentas;
    private Suscripcion[] suscripciones;
    private Pelicula[] peliculas;
    private Series[] series;
    private int contadorDeCuentas;

    public Netflix (){
        cuentas = new Cuenta[1000];
        suscripciones = new Suscripcion[1000];
        peliculas = new Pelicula[1000];
        series = new Series[1000];
        contadorDeCuentas = 0;
    }

    public void registrarCuenta(Cuenta cuenta) {
        cuentas[contadorDeCuentas++] = cuenta;
    }

    public void verPelicula(int numeroDeCuenta, int numeroDePelicula) { //TODO: Preguntar a Carlitos God 😈
        if (cuentas[numeroDeCuenta].suscripcion() == null){
            System.out.println("NO PUEDE VER PELICULAS PORQUE NO TIENE SUSCRIPCION");
        }
    }
}
