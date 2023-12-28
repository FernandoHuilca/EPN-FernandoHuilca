import java.time.LocalDate;

public class ChatOnline {
    public final int NUM_MAX_USUARIOS = 10000;
    private Usuario[] usuarios;
    private int contadorDeUsuarios;

    public ChatOnline(){
        usuarios = new Usuario[NUM_MAX_USUARIOS];
        contadorDeUsuarios = 0;
    }

    public Usuario registrarUsuario(String nombre, String usuarioEmail, String contrasenia, String celular) {
    usuarios[contadorDeUsuarios] = new Usuario(nombre, usuarioEmail, contrasenia, celular, LocalDate.now());
        System.out.println("Usuario: " + nombre + " registrado con exito!!");
        return usuarios[contadorDeUsuarios++];
    }

    public void enviarSolicitudAmistad(Usuario solicitante, Usuario solicitado, String mensajeDelSolicitante) {
        solicitante.agregarAListaDeAmigosPendientes(solicitado, mensajeDelSolicitante);
        solicitado.agregarAListaDeSolicitudesDeAmistad(solicitante, mensajeDelSolicitante);
    }
}
