// Author: Fernando Huilca
public class Main {
    public static void main(String[] args) {
        //Vehículo vehículo = new Vehículo(9,20); //No puedo construir
        //vehículo.alistarSeguridad(); //No puedo llamar a algo vacío

        Vehículo vehículo = new Bicicleta();
        vehículo.alistarSeguridad();

        Bicicleta bicicleta= new Bicicleta();
        bicicleta.alistarSeguridad();


    }
}