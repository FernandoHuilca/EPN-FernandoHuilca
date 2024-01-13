public class VehiculoConMotor extends Vehículo{
    private String matricula;

    public VehiculoConMotor(int numeroDeLlantas, int capacidadDePasajeros, String matricula){
        super(numeroDeLlantas, capacidadDePasajeros);
        this.matricula = matricula;
    }

    @Override
    public void alistarSeguridad() {

    }
}
