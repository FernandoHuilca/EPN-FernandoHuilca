// Auhor Fer alison Samira Mateo y Eri
public class Main {
    public static void main(String[] args) {

        System.out.println("\n\t\u001B[34m Caso 1. Crear armario_____________________________________________\u001B[0m");
        Armario armario = new Armario();



        System.out.println("\n\t\u001B[34m Caso 2. Crear prenda y guardar una prenda en armario_______________\u001B[0m");
        PrendaDeVestir prendaDeVestir = new PrendaDeVestir("rojo");
        PrendaDeVestir tanga = new Tanga("Rojo");


        Camiseta camiseta = new Camiseta();
        armario.guardar(prendaDeVestir);
        armario.guardar(tanga);


        System.out.println("\n\t\u001B[34m Caso . Sacar una prenda_____________________________________________\u001B[0m");
        //armario.sacarPrenda(prendaDeVestir);





    
    }
}