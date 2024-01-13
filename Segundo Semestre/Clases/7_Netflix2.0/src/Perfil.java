import java.util.Arrays;

public class Perfil {
    private String nombreDelPerfil;
    private Pelicula[] miListPelis;
    private int contadorPeliculasEnList;
    private Serie[] miListSeries;
    private int contadorSeriesEnList;

    public Perfil(String nombreDelPerfil) {

        this.nombreDelPerfil = nombreDelPerfil;
        miListPelis = new Pelicula[100];
        contadorPeliculasEnList = 0;
        miListSeries = new Serie[100];
        contadorSeriesEnList = 0;
    }

    @Override
    public String toString() {
        return
                "\n\tNombre Perfil: " + nombreDelPerfil
                        + "\n\tList de Peliculas: " + contadorPeliculasEnList
                        + "\n\tList de Series: " + contadorSeriesEnList;
    }

    public void agregarPeliAList(Pelicula pelicula) {
        miListPelis[contadorPeliculasEnList] = pelicula;
        System.out.println("Pelicula agregada a MiList con EXITO!!" + miListPelis[contadorPeliculasEnList++]);
    }
}
