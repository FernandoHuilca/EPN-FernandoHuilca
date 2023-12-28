import java.time.LocalDate;

public class Usuario {
    private static final int MAX_SOLICITUDES_AMISTAD = 1000 ;
    private final int MAX_AMIGOS_PENDIENTES = 1000;
    private String nombre;
    private String usuario;
    private String contrasenia;
    private String celular;
    private final LocalDate fechaDeRegistro; //Aqui es importante el uso del "FINAL" porque no queremos cambiar dicha fecha
    private AmigosPendientes[] listaAmigosPendiente;
    private int contadorAmigosPendientes;
    private SolicitudDeAmistad[] listaSolicitudesDeAmistad;
    private int contadorSolicitudesAmistad;

    public Usuario(String nombre, String usuario, String contrasenia, String celular, LocalDate fechaDeRegistro) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.celular = celular;
        this.fechaDeRegistro = fechaDeRegistro;
        listaAmigosPendiente = new AmigosPendientes[MAX_AMIGOS_PENDIENTES];
        contadorAmigosPendientes = 0;
        listaSolicitudesDeAmistad = new SolicitudDeAmistad[MAX_SOLICITUDES_AMISTAD];
        contadorSolicitudesAmistad = 0;
    }

    public void agregarAListaDeAmigosPendientes(Usuario solicitado, String mensajeDelSolicitante) {
        listaAmigosPendiente[contadorAmigosPendientes++] = new AmigosPendientes(solicitado, mensajeDelSolicitante);
    }

    public void agregarAListaDeSolicitudesDeAmistad(Usuario solicitante, String mensajeDelSolicitante) {
        listaSolicitudesDeAmistad[contadorSolicitudesAmistad++] = new SolicitudDeAmistad(solicitante, mensajeDelSolicitante);
    }

    public void imprimirSolicitudesDeAmistad() {
        boolean ok = true;
        for (int i = 0 ; i < contadorSolicitudesAmistad; i++){
            System.out.println(listaSolicitudesDeAmistad[i]);
            ok = false;
        }
        if (ok){
            System.out.println("No hay solicitudes de amistad. Por feo xd");
        }
    }

    public String nombre() {
        return nombre;
    }

    public void imprimirSolicitudesDeAmistadPendientes() {
        boolean ok = true;
        for (int i = 0 ; i < contadorAmigosPendientes; i++){
            System.out.println(listaAmigosPendiente[i]);
            ok = false;
        }
        if (ok){
            System.out.println("No hay amigos pendientes que te acepten la solicitud. Por feo xd");
        }
    }
}
