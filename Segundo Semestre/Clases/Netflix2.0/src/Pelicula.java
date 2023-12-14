public class Pelicula {
    private String genero;
    private String nombrePeli;

    public Pelicula(String nombrePeli, String genero) {
    this.nombrePeli = nombrePeli;
    this.genero = genero;
    }

    public String getNombre() {
        return nombrePeli;
    }

    public String getGenero() {
        return genero;
    }
}
