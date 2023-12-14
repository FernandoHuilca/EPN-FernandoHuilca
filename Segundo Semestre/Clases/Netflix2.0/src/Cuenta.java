public class Cuenta {
    private String contrasenia;
    private Suscripcion tipoDeSuscripcion;
    private String nombreUsuario;

    public Cuenta(String nombreUsuario, String contrasenia, Suscripcion tipoDeSuscripcion) {
    this.nombreUsuario = nombreUsuario;
    this.contrasenia = contrasenia;
    this.tipoDeSuscripcion = tipoDeSuscripcion;
    }

    public Suscripcion tipoDeSuscripcion() {
        return tipoDeSuscripcion;
    }
}
