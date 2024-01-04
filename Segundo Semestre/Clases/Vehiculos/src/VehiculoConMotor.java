public class VehiculoConMotor extends Vehiculo{
    private String matricula;

    public VehiculoConMotor(int numeroDeLlantas, int capacidadDePasajeros, String matricula){
        super(numeroDeLlantas, capacidadDePasajeros);
        this.matricula = matricula;
    }
}
