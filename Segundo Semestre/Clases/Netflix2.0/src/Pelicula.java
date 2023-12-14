public class Pelicula {
    private String genero;
    private String nombrePeli;

    public Pelicula(String nombrePeli, String genero) {
    this.nombrePeli = nombrePeli;
    this.genero = genero;
    }



    @Override
    public String toString() {
        return
                "\n\tNombrePelicula: " + nombrePeli
                        + "\n\tGenero: " + genero;
    }

}
