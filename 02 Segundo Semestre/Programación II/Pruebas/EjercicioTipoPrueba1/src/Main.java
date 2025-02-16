// Author Fernando Huilca
public class Main {
    public static void main(String[] args) {

        System.out.println("\n\tCaso 1. Crear Autolavado y lavar un carro___________________________________________");
        AutoLavado autoLavadoQuito = new Autolavado();
        Cliente fernando = new Cliente("Fernando Huilca", Vehiculo.GRANDE);
        autoLavadoQuito.lavarVehiculo(fernando, Lavada.SUPER, 40.00);


    }
}