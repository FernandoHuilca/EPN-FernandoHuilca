public class Cuenta {
    private String contrasenia;
    private Suscripcion tipoDeSuscripcion;
    private String nombreUsuario;
    private Perfil[] perfiles;
    private int contadorNumeroDePerfiles;

    public Cuenta(String nombreUsuario, String contrasenia, Suscripcion tipoDeSuscripcion) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.tipoDeSuscripcion = tipoDeSuscripcion;
        perfiles = new Perfil[tipoDeSuscripcion.numPerfiles()];
        contadorNumeroDePerfiles = 0;
    }

    public Suscripcion tipoDeSuscripcion() {
        return tipoDeSuscripcion;
    }

    public Perfil crearPerfil(String nombreDelPerfil) {
        Perfil nuevoPerfil = new Perfil(nombreDelPerfil);
        perfiles[contadorNumeroDePerfiles] = nuevoPerfil;
        System.out.println("\u001B[32m" + "Perfil creado con exito!! \t"+ "\u001B[0m" +  perfiles[contadorNumeroDePerfiles++]
                            + "\n\tPerfiles Creados: " + contadorNumeroDePerfiles + "\n\tPerfiles disponibles: " + (tipoDeSuscripcion.numPerfiles() - contadorNumeroDePerfiles));
        return nuevoPerfil;
    }


    @Override
    public String toString() {
        return
                "\n\tNombre de la cuenta: " + nombreUsuario
                        + "\n\tTipo de Suscripcion: " + tipoDeSuscripcion.getNombreDeSuscripcion() +
                        "\n\tPerfiles: " + contadorNumeroDePerfiles;
    }
}
