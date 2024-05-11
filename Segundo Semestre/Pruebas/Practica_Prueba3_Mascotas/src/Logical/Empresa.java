package Logical;

import java.util.ArrayList;
import java.util.Collections;

public class Empresa {

    ArrayList<Mascota> mascotas;

    public Empresa(){
        mascotas = new ArrayList<>();
    }

    public void addMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public void ordenarMascotasPorNombre() {
        Collections.sort(mascotas, new OrdenarPorNombre());
    }

    public ArrayList<Mascota> getListaMascotas() {
        return mascotas;
    }
}
