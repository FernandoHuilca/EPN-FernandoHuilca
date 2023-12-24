public class Armario {

    private PrendaDeVestir[] prendasGuardadas;
    private int contadorPrendasVestir;

    public Armario() {
        prendasGuardadas = new PrendaDeVestir[1000];
        contadorPrendasVestir = 0;
    }
    public void guardar(PrendaDeVestir prendaDeVestir) {
        prendasGuardadas[contadorPrendasVestir++] = prendaDeVestir;
    }
}
