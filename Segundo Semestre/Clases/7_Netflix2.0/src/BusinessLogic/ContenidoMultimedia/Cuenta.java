package BusinessLogic.ContenidoMultimedia;

import BusinessLogic.ContenidoMultimedia.ControlDeExcepciones.MaximoDePerfiles;

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
        if (tipoDeSuscripcion.getNumeroMáximoDePerfiles() == contadorNumeroDePerfiles){
            try {
                throw new MaximoDePerfiles();
            } catch (MaximoDePerfiles e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
        Perfil nuevoPerfil = new Perfil(nombreDelPerfil);
        perfiles[contadorNumeroDePerfiles] = nuevoPerfil;
        System.out.println("\u001B[32m" + "Perfil creado con éxito!! \t"+ "\u001B[0m" +  perfiles[contadorNumeroDePerfiles++]
                            + "\n\tPerfiles Creados: " + contadorNumeroDePerfiles + "\n\tPerfiles disponibles: " + (tipoDeSuscripcion.numPerfiles() - contadorNumeroDePerfiles));
        return nuevoPerfil;
    }


    @Override
    public String toString() {
        return
                "\n\tNombre de la cuenta: " + nombreUsuario
                        + "\n\tTipo de Suscripción: " + tipoDeSuscripcion.getNombreDeSuscripcion() +
                        "\n\tPerfiles: " + contadorNumeroDePerfiles;
    }
}
