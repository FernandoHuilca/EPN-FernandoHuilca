public class EmailListener implements Listener{
    private String email;

    public EmailListener(String email){
        this.email = email;
    }

    @Override
    public void update(String data) {
        System.out.println(" ESTOY EN EMAILLISTENER: \nEsta es la data: " + data + " \nEste el email al que se enviará " + email);
    }
}
