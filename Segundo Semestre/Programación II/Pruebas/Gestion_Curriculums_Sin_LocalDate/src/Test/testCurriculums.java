package Test;

import Logical.*;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class testCurriculums {
    //Dado:
    //Cuando:
    //Entonces:
    //--------------------------------------------------
    Empresa empresa = new Empresa();


    @Test
    public void curriculumsOrdenadosPorCanCompetencias() {
        //Dado: (que existe)
        inicializarCVs();

        //Cuando:
        empresa.ordenarPorCompetencias();
        //empresa.imprimirCVs();

        // Entonces: Verificar que la lista esté ordenada por cantidad de competencias
        ArrayList<CV> listaOrdenada = empresa.getCVs();
        for (int i = 1; i < listaOrdenada.size(); i++) {
            int competenciasAnterior = listaOrdenada.get(i - 1).getCompetencias().size();
            int competenciasActual = listaOrdenada.get(i).getCompetencias().size();
            // La cantidad de competencias debe ser igual o mayor para los elementos subsiguientes
            assertTrue(competenciasActual >= competenciasAnterior);
        }

    }


    @Test
    public void curriculumsOrdenadosPorNivelTítulo() {
        //Dado: (que existe)
        inicializarCVs();

        //Cuando:
        empresa.ordenarPorNivelDeTitulación();
        //empresa.imprimirCVs();

        // Entonces: Verificar que la lista esté ordenada por nivel de titulación
        ArrayList<CV> listaOrdenada = empresa.getCVs();

        for (int i = 1; i < listaOrdenada.size(); i++) {
            int nivelAnterior = listaOrdenada.get(i - 1).elMayorNivelDeTítulo();
            int nivelActual = listaOrdenada.get(i).elMayorNivelDeTítulo();
            // La cantidad de competencias debe ser igual o mayor para los elementos subsiguientes
            assertTrue(nivelActual >= nivelAnterior);
        }

    }


    @Test
    public void otraManera() {
        for (int i = 1; i < empresa.getCVs().size(); i++) {
            assertTrue(empresa.getCVs().get(i).elMayorNivelDeTítulo() >= empresa.getCVs().get(i - 1).elMayorNivelDeTítulo());
        }
    }


    @Test
    public void curriculumsOrdenadosPorExperienciaLaboral() {
        //Dado: (que existe)
        inicializarCVs();

        //Cuando:
        empresa.ordenarPorTiempoExperienciaLaboral();
        //empresa.imprimirCVs();

        // Entonces: Verificar que la lista esté ordenada por nivel de titulación
        ArrayList<CV> listaOrdenada = empresa.getCVs();

        for (int i = 1; i < listaOrdenada.size(); i++) {
            int experienciaAnterior = listaOrdenada.get(i - 1).getExperienciaLaboral();
            int experienciaActual = listaOrdenada.get(i).getExperienciaLaboral();
            // La cantidad de competencias debe ser igual o mayor para los elementos subsiguientes
            assertTrue(experienciaActual >= experienciaAnterior);
        }

    }

    @Test
    public void controlarIngresodDeFechaInicialAntesQueFinalTrabajo() {
        //Dado: (que existe)
        String aux = " ";
        try {
            Trabajo trabajo = new Trabajo(LocalDate.of(2020, 1, 1), LocalDate.of(2000, 1, 1), "Amazon");
        } catch (FechaInicialYFinalIncorrectas e) {
            aux = e.getMessage();
        }

        //Cuando:

        // Entonces: Verificar mensaje de error: no se me ocurre otra manera ahora haha
        assertEquals("ERROR: al ingresar la fecha", aux);

    }

    @Test
    public void crearTrabajoConFechaInicialPosteriorAFechaFinal3() {
        // Verificar que se lance la excepción FechaInicialYFinalIncorrectas
        assertThrows(FechaInicialYFinalIncorrectas.class, () -> {
            new Trabajo(LocalDate.of(2020, 1, 1), LocalDate.of(2000, 1, 1), "Amazon");
        });
    }


    //-----------------------------------------------------------------------------
    private void inicializarCVs() {
        //--------------- Títulos ---------------------------------------------------
        ArrayList<Título> títulos1;
        títulos1 = new ArrayList<>();
        ArrayList<Título> títulos2;
        títulos2 = new ArrayList<>();

        Título título1 = new Título(2022, 2, 4, "EPN", 3);
        Título título2 = new Título(2020, 2, 4, "ESPE", 1);
        Título título3 = new Título(2022, 2, 4, "EPN", 2);
        Título título4 = new Título(2020, 2, 4, "ESPE", 4);

        títulos1.add(título1);
        títulos1.add(título2);
        títulos2.add(título3);
        títulos2.add(título4);

        //--------------- Trabajos ---------------------------------------------------
        ArrayList<Trabajo> trabajos;
        trabajos = new ArrayList<>();
        ArrayList<Trabajo> trabajos2;
        trabajos2 = new ArrayList<>();


        Trabajo trabajo1 = null;
        try {
            trabajo1 = new Trabajo(LocalDate.of(2000, 1, 15), LocalDate.of(2002, 1, 15), "Google");
        } catch (FechaInicialYFinalIncorrectas e) {
            System.out.println(e.getMessage());
        }
        Trabajo trabajo2 = null;
        try {
            trabajo2 = new Trabajo(LocalDate.of(2001, 1, 15), LocalDate.of(2004, 1, 15), "Google");
        } catch (FechaInicialYFinalIncorrectas e) {
            System.out.println(e.getMessage());
        }
        Trabajo trabajo3 = null;
        try {
            trabajo3 = new Trabajo(LocalDate.of(2002, 1, 15), LocalDate.of(2006, 1, 15), "Google");
        } catch (FechaInicialYFinalIncorrectas e) {
            System.out.println(e.getMessage());
        }

        trabajos.add(trabajo1);
        trabajos.add(trabajo2);
        trabajos2.add(trabajo3);

        //--------------- Competencias ---------------------------------------------------
        ArrayList<Competencia> compretencias;
        compretencias = new ArrayList<Competencia>();
        compretencias.add(new Competencia("Extremadamente Guapo :3")); //Esta es mi competencia haha


        ArrayList<Competencia> compretencias2;
        compretencias2 = new ArrayList<Competencia>();
        compretencias2.add(new Competencia("Paciencia"));
        compretencias2.add(new Competencia("Trabajo en Equipo"));
        compretencias2.add(new Competencia("Carisma"));

        //--------------------- Agregar CVs a la empresa ------------------------------------
        empresa.addCV(new CV("Fernando Huilca", títulos1, trabajos, compretencias));
        empresa.addCV(new CV("Carlos Anchundia", títulos2, trabajos2, compretencias2));
    }
}
