public class Serie {
    private String genero;
    private String nombreSerie;
    private int numTemporada;
    private int numCapitulos;

    public Serie(String nombreSerie, String genero, int numTemporada, int numCapitulos) {
        this.numTemporada = numTemporada;
        this.numCapitulos = numCapitulos;
        this.nombreSerie = nombreSerie;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return
                "\n\tNombreSerie: " + nombreSerie
                        + "\n\tGenero: " + genero
                        + "\n\tTemporadas: " + numTemporada +
                "\n\tCapitulos: " + numCapitulos;
    }
}
