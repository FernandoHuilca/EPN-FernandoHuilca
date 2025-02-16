package Logical;

import java.util.Comparator;

public class OrdenarPorNombre implements Comparator<Mascota> {
    @Override
    public int compare(Mascota mascota1, Mascota mascota2) {
        return mascota1.nombre.compareTo(mascota2.nombre);
    }
}
