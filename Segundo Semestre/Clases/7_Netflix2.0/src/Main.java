import java.sql.SQLOutput;

//Author Fernando Huilca
public class Main {
    public static void main(String[] args) {
        Animacion logo = new Animacion();

        System.out.println("\n\tCaso 1. Crear Netflix y una cuenta___________________________________________");
        Netflix netflix = new Netflix();
        logo.presentar();
        Cuenta cuentaFernando = netflix.crearCuenta("Fernando Huilca", "1234", Suscripcion.PREMIUM, 10.99);





        System.out.println("\n\tCaso 2. Crear una cuenta con dinero insuficiente o en exceso______________________");
        Cuenta cuentaEdgar = netflix.crearCuenta("Edgar Poe", "1234", Suscripcion.PREMIUM, 7.99);
        Cuenta cuentaGabriel = netflix.crearCuenta("Gabriel Garcia", "1234", Suscripcion.PREMIUM, 11.99);




        System.out.println("\n\tCaso 3. Agregar una peli a netflix____________________________________________");
        netflix.agregarPelicula("Interestelar", "Ciencia Ficcion");




        System.out.println("\n\tCaso 4. Agregar una serie a netflix____________________________________________");
        netflix.agregarSerie("Blue Eyes Samurai", "Anime", 1, 8);




        System.out.println("\n\tCaso 5. Ver pelicula y serie__________________________________________________");
        netflix.reproducirPelicula(cuentaFernando, 0);
        netflix.reproducirSerie(cuentaFernando, 0, 1,8);


        System.out.println("\n\tCaso 6. Ver pelicula y serie desde una cuenta sin acceso______________________");
        Cuenta cuentaOscar = netflix.crearCuenta("Oscar Wilde", "1234", Suscripcion.SIN_PAGAR, 0.0);
        netflix.reproducirPelicula(cuentaOscar, 0);
        netflix.reproducirSerie(cuentaOscar, 0, 1,8);

        System.out.println("\n\tCaso 7. Intentar ver Peli  o serie que no este en el catalogo___________________");
        netflix.reproducirPelicula(cuentaFernando, 1);
        netflix.reproducirSerie(cuentaFernando, 1, 1,8);



        System.out.println("\n\tCaso 8. Crear un perfil en una cuenta con suscripcion de pago___________________");
        Perfil perfilFranz = cuentaFernando.crearPerfil("Franz Kafka");



        System.out.println("\n\tCaso 9. Agregar una Peli a la lista de un perfil valido__________________________");
        //perfilFranz.agregarPeliAList(0);
        perfilFranz.agregarPeliAList(netflix.regresarPeli(0));

        System.out.println(perfilFranz);


        System.out.println("\n\tCaso 10. Imprimir Info de Netflix_________________________________________________");
        System.out.println(netflix);

    }
}