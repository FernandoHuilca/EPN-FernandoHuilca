public class Moto extends VehículoConMotor{
    public Moto(String matrícula){
        super(2,2, matrícula);
    }

    private void ponerCasco(){
        System.out.println("Casco Puesto");
    }

    @Override
    public void alistarSeguridad() {
        ponerCasco();
    }
}
