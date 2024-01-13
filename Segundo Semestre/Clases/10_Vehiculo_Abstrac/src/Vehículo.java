public abstract class Vehículo {
    private int numeroDeLlantas;
    private int capacidad;
    private Asiento[] asientos;

    public Vehículo(int numeroDeLlantas, int capacidad){
        this.numeroDeLlantas = numeroDeLlantas;
        this.capacidad = capacidad;
        asientos = new Asiento[capacidad];
    }

    public void acelerar(){ }

    public void frenar(){ }

    public abstract void alistarSeguridad(); //METODO ABSTRACTO POR ESO EL PUNTO Y COMA, porque iba a estar vacío, con ello se cambia la clase abstracta

    //Siempre que necesite un método abstracto la clase va a ser abstracta
    //A la vez si no tienes métodos abstractos, no importa si la clase es abstracta
    //Una clase es abstracta cuando no puedo definir que va a ser ese método o la misma clase
    //Todo lo abstracto es cursivo
}
