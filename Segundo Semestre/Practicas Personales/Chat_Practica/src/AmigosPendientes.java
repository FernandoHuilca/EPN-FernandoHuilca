public class AmigosPendientes {
    private Usuario solicitado;
    private final String mensajeDelSolicitante; //No queremos cambiar el mensaje de solicitud

    public AmigosPendientes(Usuario solicitado, String mensajeDelSolicitante) {
        this.solicitado = solicitado;
        this.mensajeDelSolicitante = mensajeDelSolicitante;
    }
    @Override
    public String toString() {
        return "Amigos Pendientes: "
                + "\n\t" + solicitado.nombre()+ " aun no te acepta." +
                " \n\tMensaje de Solicitud: \"" + mensajeDelSolicitante + "\"";
    }
}
