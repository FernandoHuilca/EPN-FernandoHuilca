public abstract class VehículoConMotor extends Vehículo{
    private String matrícula;


    public VehículoConMotor(int numeroDeLlantas, int capacidad, String matrícula){ //reciba o reenvíe
        super(numeroDeLlantas, capacidad);
        this.matrícula = matrícula;
    }

    public void arrancar(){

    }

    public void apagar(){

    }
}
