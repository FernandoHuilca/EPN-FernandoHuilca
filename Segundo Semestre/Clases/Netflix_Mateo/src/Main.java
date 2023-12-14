public class Main {
    public static void main(String[] args) {
        Netflix netflix = new Netflix();

        //caso 1
        System.out.println("Caso 1, validar dinero... ");
        CuentaNetflix cuentaNetflix2 = netflix.registrar("juan.quisilema@epn.edu.ec", Suscripcion.BASICO, 2);

        //caso 2
        System.out.println("Caso 2, todo correcto");
        CuentaNetflix cuentaNetflix1 = netflix.registrar("juan.quisilema@epn.edu.ec", Suscripcion.BASICO, 4.99);

        //caso 3
        netflix.reproducirPelicula(0,1);


}
}