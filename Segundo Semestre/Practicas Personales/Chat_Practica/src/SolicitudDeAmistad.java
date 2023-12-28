public class SolicitudDeAmistad {
    private Usuario solicitante;
    private final String mensajeDelSolicitante;

    public SolicitudDeAmistad(Usuario solicitante, String mensajeDelSolicitante) {

        this.solicitante = solicitante;
        this.mensajeDelSolicitante = mensajeDelSolicitante;
    }

    @Override
    public String toString() {
        return "Solicitudes de Amistad: "
                + "\n\t" + solicitante.nombre()+ " quiere ser tu amigo." +
                " \n\tMensaje de Solicitud: \"" + mensajeDelSolicitante + "\"";
    }
}
