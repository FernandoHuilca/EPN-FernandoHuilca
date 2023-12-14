public class Animacion {
    private String COLOR_Rojo;
    private String COLOR_Blanco;
    public Animacion(){
        COLOR_Rojo = "\u001B[31m";
        COLOR_Blanco = "\u001B[0m";
    }
    public void presentar() {
        System.out.println(COLOR_Rojo);
        System.out.println("███╗   ██╗");
        System.out.println("████╗  ██║");
        System.out.println("██╔██╗ ██║");
        System.out.println("██║╚██╗██║");
        System.out.println("██║ ╚████║");
        System.out.println("╚═╝  ╚═══╝");
        System.out.println(COLOR_Blanco);
        //limpiarConsola();
    }

    private void limpiarConsola() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para sistemas operativos tipo Unix (Linux, macOS)
                System.out.print("\u001b[H\u001b[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Manejar excepciones si ocurren
            e.printStackTrace();
        }

    }
}
