// Autores: Fer alison Samira Mateo y Erick, Gregory también creo jeje
public class Main {
    public static void main(String[] args) {

        Armario armario = new Armario(8);


        System.out.println("\n\t\u001B[34m Caso 1. Crear varias prendas de vestir y prendas en especifico _______________\u001B[0m");

        PrendaDeVestir prendaDeVestir = new PrendaDeVestir("rojo", 3,5);
        PrendaDeVestir tanga = new Tanga("Rojo");
        PrendaDeVestir camiseta = new Camiseta("Azul");
        PrendaDeVestir pantalon = new Pantalon("Negro");



        System.out.println("\n\t\u001B[34m Caso 2. Guardar en el armario las prendas creadas _______________\u001B[0m");
        prendaDeVestir.ponerPrenda();
        prendaDeVestir.sacarPrenda();
        armario.guardar(prendaDeVestir); //ERROR: porque la prenda esta sucia porque se acaba de usar
        armario.guardar(tanga);
        tanga.ponerPrenda();
        armario.guardar(tanga); //ERROR: porque la prenda se esta usando y no la puedes guardar
        camiseta.ponerPrenda();
        armario.guardar(camiseta); //ERROR: porque la camiseta estaw en uso

    
    }
}