package BusinessLogic.ContenidoMultimedia;

import BusinessLogic.ContenidoMultimedia.Pelicula;
import BusinessLogic.ContenidoMultimedia.Serie;

import java.util.ArrayList;

public class Perfil {
    private String nombreDelPerfil;
    private ArrayList <Pelicula> miListPelis;
    private ArrayList <Serie>  miListSeries;

    public Perfil(String nombreDelPerfil) {

        this.nombreDelPerfil = nombreDelPerfil;
        miListPelis = new ArrayList<Pelicula>();
        miListSeries = new ArrayList<Serie>();
    }

    @Override
    public String toString() {
        return
                "\n\tNombre Perfil: " + nombreDelPerfil
                        + "\n\tList de Películas: " + miListPelis.size()
                        + "\n\tList de Series: " + miListSeries.size();
    }

    public void agregarPeliAList(Pelicula pelicula) {
        miListPelis.add(pelicula);
        System.out.println("Película agregada a MiList con ÉXITO!!" + pelicula);
    }
    public void agregarSerieAList(Serie serie) {
        miListSeries.add(serie);
        System.out.println("Serie agregada a MiList con ÉXITO!!" + serie);
    }
}
