// Author: Fernando E. Huilca
// Date: 30/04/2024
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Usuario fernando = new Usuario("Fernando Huilca");


        boolean ok = true;
        while (ok){
            switch (menuPrincipal()){
                case 1: {
                    switch (menuRopa()){
                        case 1:
                            fernando.agregarRopa();
                            break;
                        case 2:
                            eliminarRopa();
                            break;
                        case 3:
                            fernando.mostrarListaRopa();
                            break;
                        case 0:
                            break;

                    }
                    break;
                }
                case 2: {
                    switch (menuDestino()){
                        case 1:
                            agregarDestino();
                            break;
                        case 2:
                            eliminarDestino();
                            break;
                        case 3:
                            mostrarListaDestino();
                            break;
                        case 0:
                            break;
                    }
                    break;
                }
                case 3: {

                    break;
                }
                case 0: {
                    ok = false;
                    break;
                }

            }
        }
    }

    public static int menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" _________ Viajes Inteligentes __________");
            System.out.println("| Escoja una opción marcando un número:  |");
            System.out.println("| 1) Ropa                                |");
            System.out.println("| 2) Destino                             |");
            System.out.println("| 3) Actividad                           |");
            System.out.println("| 0) Salir                               |");
            System.out.println("|________________________________________|");
            int opcion = scanner.nextInt();
            if (opcion >= 0 && opcion <= 3) {
                return opcion;
            } else {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static int menuRopa() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" _________ Menú Ropa __________");
            System.out.println("| Escoja una opción:           |");
            System.out.println("| 1) Agregar ropa              |");
            System.out.println("| 2) Eliminar ropa             |");
            System.out.println("| 3) Mostrar lista de ropa     |");
            System.out.println("| 0) Volver al menú principal  |");
            System.out.println("|______________________________|");
            int opcion = scanner.nextInt();
            if (opcion >= 0 && opcion <= 3) {
                return opcion;
            } else {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static int menuDestino() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" _________ Menú Destino __________");
            System.out.println("| Escoja una opción:               |");
            System.out.println("| 1) Agregar destino              |");
            System.out.println("| 2) Eliminar destino             |");
            System.out.println("| 3) Mostrar lista de destinos    |");
            System.out.println("| 0) Volver al menú principal     |");
            System.out.println("|__________________________________|");
            int opcion = scanner.nextInt();
            if (opcion >= 0 && opcion <= 3) {
                return opcion;
            } else {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void agregarRopa() {
    }

    public static void eliminarRopa() {
        // Lógica para eliminar ropa
        System.out.println("Eliminar ropa...");
    }

    public static void mostrarListaRopa() {
        // Lógica para mostrar lista de ropa
        System.out.println("Mostrar lista de ropa...");
    }

    public static void agregarDestino() {
        // Lógica para agregar destino
        System.out.println("Agregar destino...");
    }

    public static void eliminarDestino() {
        // Lógica para eliminar destino
        System.out.println("Eliminar destino...");
    }

    public static void mostrarListaDestino() {
        // Lógica para mostrar lista de destinos
        System.out.println("Mostrar lista de destinos...");
    }
}
