// Author : Fernando Huilca
public class Main {
    public static void main(String[] args) {

        MiClase objeto1 = new MiClase();
        MiClase objeto2 = new Hijo();

        objeto2.mensaje();
        objeto1.mensaje();
    }
}