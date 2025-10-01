public class LoggingListener implements Listener {
    private String fileName;
    private String message;

    public LoggingListener(String log_fileName, String message ) {
    this.fileName = log_fileName;
    this.message = message;
    }
    @Override
    public void update(String data) {
        System.out.println("ESTOY EN LOGGING LISTENER: \nEste es la data:" + data + " \nEsta es el mensaje " + message);
    }
}
