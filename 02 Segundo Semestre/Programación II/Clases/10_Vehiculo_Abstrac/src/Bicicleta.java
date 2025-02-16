public class Bicicleta extends Vehículo{

    public Bicicleta(){
        super(2,1);
    }
    private void ponerCasco(){
        System.out.println("Casco Puesto");
    }

    public void alistarSeguridad(){
        ponerCasco();
    }
}
