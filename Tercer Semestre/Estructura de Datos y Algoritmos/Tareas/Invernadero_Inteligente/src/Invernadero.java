import java.util.Scanner;

public class Invernadero {
    private int numeroDeCultivos;
    private double areaDelInvernadero;
    private String modeloDeRiego;
    private boolean encendidoVentilacion;

    public Invernadero(int numeroDeCultivos, double areaDelInvernadero, String modeloDeRiego) {
        this.numeroDeCultivos = numeroDeCultivos;
        this.areaDelInvernadero = areaDelInvernadero;
        this.modeloDeRiego = modeloDeRiego;
        this.encendidoVentilacion = false;
    }

    public void obtenerNumeroDeCultivos() {
        System.out.println("El número de cultivos es: " + numeroDeCultivos);
    }

    public void obtenerAreaDeCultivos() {
        System.out.println("El área de cultivos es: " + areaDelInvernadero + " metros cuadrados");
    }

    public void encenderVentilacion() {
        boolean aux = encendidoVentilacion;
        this.encendidoVentilacion = true;
        System.out.println("La ventilacion fue encendida: ");
        System.out.println("La ventilacion a cambiado su estado de: " + aux + " a " + encendidoVentilacion);
    }

    public void apagarVentilacion() {
        boolean aux = encendidoVentilacion;
        this.encendidoVentilacion = false;
        System.out.println("La ventilacion fue apagada:");
        System.out.println("La ventilacion a cambiado su estado de: " + aux + " a " + encendidoVentilacion);
    }

    public void informacionVentilacion() {
        System.out.println("El estado de la ventilacion actual es: " + encendidoVentilacion);
        System.out.println("El modelo del riego es: " + modeloDeRiego);
    }

    public void modificarArea() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese la nueva area del inventario: ");
        areaDelInvernadero = entrada.nextDouble();
        System.out.println("El area ha sido cambiada a: " + areaDelInvernadero);
    }

    public void modificarModeloDeRiego() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el nuevo modelo de Riego: ");
        modeloDeRiego = entrada.nextLine();
        System.out.println("El nuevo modelo ha sido cambiada a: " + modeloDeRiego);
    }

    public void modificarNumeroDeCultivos() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el nuevo número de cultivos: ");
        numeroDeCultivos = entrada.nextInt();
        System.out.println("El numero de cultivos ha sido cambiado a: " + numeroDeCultivos);
    }
}