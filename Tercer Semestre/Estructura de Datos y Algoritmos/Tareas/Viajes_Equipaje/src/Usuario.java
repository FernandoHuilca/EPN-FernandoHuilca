import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private ArrayList<Ropa> ropas;



    public Usuario(String nombre) {
    this.nombre = nombre;
    this.ropas = new ArrayList<>();
    }


    public void agregarRopa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escriba el nombre de la prenda que se va a agregar: ");
        String nombre = scanner.nextLine();

        System.out.println("Ahora escoja en qué tipo de clima es óptimo su utilización: ");
        System.out.println("1) Clima cálido");
        System.out.println("2) Clima frío");

        int opcion = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion == 1 || opcion == 2) {
                    entradaValida = true;
                } else {
                    System.out.println("Por favor, seleccione una opción válida (1 o 2).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }

        Ropa ropa = new Ropa(nombre, opcion);
        ropas.add(ropa);
    }

    public void mostrarListaRopa() {
        if (ropas.isEmpty()) {
            System.out.println("No hay prendas registradas.");
        } else {
            System.out.println("Lista de prendas registradas:");
            for (Ropa ropa : ropas) {
                System.out.println("Nombre: " + ropa.getNombre() + ", Clima: " + (ropa.getClima() == 1 ? "Cálido" : "Frío"));
            }
        }
    }

}
