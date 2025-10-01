public class EmailListener implements Listener{
    private String email;

    public EmailListener(String email){
        this.email = email;
    }

    @Override
    public void update(String data) {
        System.out.println(" ESTOY EN EMAIL data: " + data + " ESTE ES EL EMAIL AL QUE SE ENVIARIA " + email);
    }
}
