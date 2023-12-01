public class Main {
    // Códigos ANSI para colores en la consola
    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String PURPURA = "\u001B[35m";
    public static final String CIAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";

    public static void main(String[] args) {
        // Ejemplo de cómo imprimir texto con colores
        System.out.println(ROJO + "Texto en rojo" + RESET);
        System.out.println(VERDE + "Texto en verde" + RESET);
        System.out.println(AMARILLO + "Texto en amarillo" + RESET);
        System.out.println(AZUL + "Texto en azul" + RESET);
        System.out.println(PURPURA + "Texto en púrpura" + RESET);
        System.out.println(CIAN + "Texto en cian" + RESET);
        System.out.println(BLANCO + "Texto en blanco" + RESET);
    }
}
