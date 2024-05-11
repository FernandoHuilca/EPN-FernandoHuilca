package Testing;

import Logical.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MascotasTest {
    //------------------------------------------------
    Empresa empresa = new Empresa();

    //------------------ Mascotas ------------------------------
    Mascota mascota1 = new Mascota("Apolo", "Chihuahua", 2, "Fernando Huilca");
    Mascota mascota2 = new Mascota("Ragnar", "Chihuahua", 4, "Carlos Anchundia");
    Mascota mascota3 = new Mascota("Zeus", "Bulldog", 1, "Edgar Poe");
    Mascota mascota4 = new Mascota("Kronos", "Pastor Alemán", 1, "Gabriela Mistral");


    @Test
    public void ordenarMascotasPorNombre() {
        //Dado:
        añadirMascotasALaEmpresa();
        //Cuando:
        empresa.ordenarMascotasPorNombre();
        //Entonces:
        ArrayList<Mascota> nuevaListaOrdenada = empresa.getListaMascotas();
        for (int i = 0; i < (nuevaListaOrdenada.size() - 1); i++) {
            String nombreActual = nuevaListaOrdenada.get(i).getNombre();
            String nombreSiguiente = nuevaListaOrdenada.get(i+1).getNombre();
            assertTrue(nombreActual.compareTo(nombreSiguiente) <= 0);
        }

    }






    public void inicializarTodo() {

    }


    //------------------------------------------------------------------
    private void añadirMascotasALaEmpresa() {
        empresa.addMascota(mascota1);
        empresa.addMascota(mascota2);
        empresa.addMascota(mascota3);
        empresa.addMascota(mascota4);
    }


}
