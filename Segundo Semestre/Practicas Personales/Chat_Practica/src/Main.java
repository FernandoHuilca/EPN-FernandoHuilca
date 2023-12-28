// Author: Fernando Huilca
public class Main {
    public static void main(String[] args) {
        ChatOnline chatOnline = new ChatOnline();


        System.out.println("\n\t\u001B[34m Caso 1. Crear dos usuarios de chatOnline con sus datos _____________________________________________\u001B[0m");
        Usuario fernando = chatOnline.registrarUsuario("Fernando Huilca", "fernandohuilca3@gmail.com", "contraseniaSegura","0979835003");
        Usuario eliceo = chatOnline.registrarUsuario("Eliceo Villagomez", "eliceovillagomez@gmail.com", "contraseniaSegura","0987654321");

        System.out.println("\n\t\u001B[34m Caso 1. Enviar una solicitud de amistad a otro usuario registrado __________________________________\u001B[0m");
        chatOnline.enviarSolicitudAmistad(fernando, eliceo, "Holis, aceptame la soli. Quiero ser tu amiguito UwU");

        System.out.println("\n\t\u001B[34m Caso 1. Imprimir lista de solicitudes de amistad y solicitudes pendientes ___________________________\u001B[0m");
        fernando.imprimirSolicitudesDeAmistad();
        fernando.imprimirSolicitudesDeAmistadPendientes();
        eliceo.imprimirSolicitudesDeAmistad();
        eliceo.imprimirSolicitudesDeAmistadPendientes();


    }
}