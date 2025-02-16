// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//MVP -> Producto mínimo viable
        Camiseta camiseta = crearUnaCamiseta();
        usarCamisetaYSeEnsucia(camiseta);
        soloPoderUsarCamisetaLimpia(camiseta);
        seRompeCamisetaDespuesDe3Lavadas(camiseta);
        seDestruyeCamisetaDespuesDe5Arregladas(camiseta);
/****************************/


        Armario armario = new Armario(5);
        armario.guardar(camiseta); //no se puede, está cerrado
        armario.abrir();
        armario.guardar(camiseta); //no se puede, la camiseta está sucia o en mal estado
        armario.cerar();
        armario.abrir();
        //Camiseta camiseta3 = armario.sacar(1);


        System.out.println("\n\t\u001B[34m Caso 1. Crear prenda y guardar una prenda en armario_______________\u001B[0m");
        //PrendaDeVestir prendaDeVestir = new PrendaDeVestir("rojo");
        armario.guardar(camiseta);




    }







    private static void seDestruyeCamisetaDespuesDe5Arregladas(Camiseta camiseta) {
//5 Con cinco arreglos, se destruye, queda inservible
        camiseta.usar(); // no debería porque está en mal estado
        camiseta.arreglar();
        for (int arregladas = 0; arregladas < 4; arregladas++) {
            camiseta.arreglar(); //TODO: Consultar si esto es posible
            camiseta.usar();
            for (int lavadas = 0; lavadas < 3; lavadas++)
                camiseta.lavar();
            System.out.println(camiseta); // no se puede arreglar más después del 6to uso
        }
    }
    private static void seRompeCamisetaDespuesDe3Lavadas(Camiseta camiseta) {
//4 Con tres lavadas, se rompe
        camiseta.lavar();
        camiseta.lavar(); //TODO: Consultar si esto es posible
        System.out.println(camiseta);
        System.out.println("Requerimiento 4 atendido");
    }
    private static void soloPoderUsarCamisetaLimpia(Camiseta camiseta) {
//3 Solo se puede usar camisetas limpias/en buen estado
        camiseta.usar();//No se debería poder usar
        camiseta.lavar();
        camiseta.usar(); // ya debería dejar usar
        System.out.println("Requerimiento 3 atendido");
    }
    private static void usarCamisetaYSeEnsucia(Camiseta camiseta) {
//2 Usar una camiseta hace que se ensucie
        System.out.println(camiseta);
        camiseta.usar();
        System.out.println(camiseta);
        System.out.println("Requerimiento 2 atendido");
    }
    private static Camiseta crearUnaCamiseta() {
//1 Crear una camiseta
        Camiseta camiseta = new Camiseta();
        System.out.println("Requerimiento 1 atendido");
        return camiseta;
    }
}