// Author Fernando Huilca
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class main {

    public static void main(String[] args) {

        // Configuración de las propiedades del servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.example.com"); // Reemplaza con tu servidor SMTP
        props.put("mail.smtp.port", "587"); // Reemplaza con el puerto adecuado

        // Credenciales del remitente
        final String username = "tu_correo@example.com";
        final String password = "tu_contraseña";

        // Datos del nuevo usuario registrado
        String nuevoUsuario = "nuevo_usuario@example.com";

        // Crear una sesión de correo
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crear un mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tu_correo@example.com")); // Remitente
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(nuevoUsuario)); // Destinatario
            message.setSubject("¡Bienvenido a Nuestra Empresa!");
            message.setText("Hola,\n\nGracias por registrarte en nuestra empresa. ¡Te damos la bienvenida!");

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo de registro enviado con éxito");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error al enviar el correo de registro: " + e.getMessage());
        }
    }
}





/*
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarCorreo {

    public static void main(String[] args) {

        // Configuración de las propiedades del servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.example.com"); // Reemplaza con tu servidor SMTP
        props.put("mail.smtp.port", "587"); // Reemplaza con el puerto adecuado

        // Credenciales del remitente
        final String username = "tu_correo@example.com";
        final String password = "tu_contraseña";

        // Crear una sesión de correo
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Crear un mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tu_correo@example.com")); // Remitente
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("destinatario@example.com")); // Destinatario
            message.setSubject("Asunto del correo");
            message.setText("Hola,\n\nEste es un ejemplo de cómo enviar un correo desde Java.");

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo enviado con éxito");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }
    }
}

 */
