// Author: Fernando E. Huilca
//02 / 05 / 2024

public class Main {
    public static void main(String[] args) {
        Invernadero invernadero = new Invernadero(4, 100.25,
                "Riego por Aspersion");

        // Una vez declarado el invernadero y sus datos procedo a hacer las pruebas y metodos
        System.out.println("____________________ Invernadero Automatizado _____________________________");
        System.out.println(" ");

        System.out.println("Caso 1. Obtener el numero de cultivos del invernadero _____________________");
        invernadero.obtenerNumeroDeCultivos();
        System.out.println(" ");

        System.out.println("Caso 2. Obtener el area del invernadero ___________________________________");
        invernadero.obtenerAreaDeCultivos();
        System.out.println(" ");

        System.out.println("Caso 3. Encender la ventilación ____________________________________________");
        invernadero.encenderVentilacion();
        System.out.println(" ");

        System.out.println("Caso 4. Apagar la ventilación ______________________________________________");
        invernadero.apagarVentilacion();
        System.out.println(" ");

        System.out.println("Caso 5. Mostrar informacion a cerca de la ventilacion ______________________");
        invernadero.informacionVentilacion();
        System.out.println(" ");


        System.out.println("Caso 6. Modificar los datos del Area _______________________________________");
        invernadero.modificarArea();
        System.out.println(" ");



        System.out.println("Caso 7. Modificar el modelo de Riego  _______________________________________");
        invernadero.modificarModeloDeRiego();
        System.out.println(" ");



        System.out.println("Caso 8. Modificar el numero de cultivos _____________________________________");
        invernadero.modificarNumeroDeCultivos();
        System.out.println(" ");
    }
}