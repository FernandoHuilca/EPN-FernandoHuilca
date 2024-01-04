public abstract class Vehiculo {
    private int numeroDeLlantas;
    private int capacidadDePasajeros;
    private Asiento[] asientos;

    public Vehiculo(int numeroDeLlantas, int capacidadDePasajeros) {
        this.numeroDeLlantas = numeroDeLlantas;
        this.capacidadDePasajeros = capacidadDePasajeros;
        asientos = new Asiento[capacidadDePasajeros];
    }

    public void acelerar(){
        System.out.println("Esta acelerando");
    }

    public void frenar(){
        System.out.println("Esta acelerando");ope
    }
    public abstract void alistarSeguridad();

}
