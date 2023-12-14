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
    }
}
