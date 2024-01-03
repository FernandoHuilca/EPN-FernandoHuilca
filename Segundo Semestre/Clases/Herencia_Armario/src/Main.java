// Autores: Fer alison Samira Mateo y Erick, Gregory también creo jeje
public class Main {
    public static void main(String[] args) {

        Armario armario = new Armario(8);


        System.out.println("\n\t\u001B[34m Caso 1. Crear varias prendas de vestir y prendas en especifico _______________\u001B[0m");
        PrendaDeVestir prendaDeVestir = new PrendaDeVestir("rojo", 3,5);
        PrendaDeVestir tanga = new Tanga("Rojo");
        //Camiseta camiseta = new Camiseta();




        prendaDeVestir.ponerPrenda();
        prendaDeVestir.sacarPrenda();
        armario.guardar(prendaDeVestir);
        armario.guardar(tanga);
        /*






        System.out.println("\n\t\u001B[34m Caso . Sacar una prenda_____________________________________________\u001B[0m");
        //armario.sacarPrenda(prendaDeVestir);    */





    
    }
}