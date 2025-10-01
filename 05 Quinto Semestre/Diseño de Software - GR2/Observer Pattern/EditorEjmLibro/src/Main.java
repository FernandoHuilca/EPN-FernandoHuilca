//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EmailListener emailListener = new EmailListener("fernando.huilca@epn.edu.ec");
        LoggingListener loggingListener = new LoggingListener("FernandoLoggin", "mensaje de loggin");
        Editor editor = new Editor();
        editor.getEventManager().suscribe("email", emailListener);
        editor.getEventManager().suscribe("open", loggingListener);
        editor.saveFile("examenInstrucciones.txt");
        editor.openFile("examenInstrucciones.txt");
    }
}