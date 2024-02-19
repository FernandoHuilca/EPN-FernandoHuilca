// Author Fernando Huilca
// Prueba 2. Ing Carlos Anchundia
// 18 02 2024

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Empresa empresa = new Empresa();
        //----------------------------------Títulos-------------------------
        ArrayList<Título> títulos;
        títulos = new ArrayList<Título>();
        títulos.add(new Título(LocalDate.of(2000,1,15), "EPN", 1));

        ArrayList<Título> títulos2;
        títulos2 = new ArrayList<Título>();
        títulos2.add(new Título(LocalDate.of(2000,1,15), "ESPE", 3));



        //----------------------------------Trabajos-------------------------
        ArrayList<Trabajo> trabajos;
        trabajos = new ArrayList<Trabajo>();
        trabajos.add(new Trabajo(LocalDate.of(2000,1,15),LocalDate.of(2002,1,15), "Google"));


        //----------------------------------Competencias-------------------------
        ArrayList<Competencia> compretencias;
        compretencias = new ArrayList<Competencia>();
        compretencias.add(new Competencia("Paciencia"));


        ArrayList<Competencia> compretencias2;
        compretencias2 = new ArrayList<Competencia>();
        compretencias2.add(new Competencia("Paciencia"));
        compretencias2.add(new Competencia("Trabajo en Equipo"));
        compretencias2.add(new Competencia("Carisma"));

        //----------------------------------CVs-------------------------

        CV cv2 = new CV("Carlos Anchundia", títulos2, trabajos, compretencias);
        CV cv1 = new CV("Fernando Huilca",títulos,trabajos, compretencias2);

        empresa.addCV(cv1);
        empresa.addCV(cv2);
        //----------------------------------CASOS-------------------------
        System.out.println("\n\t\u001B[34m Caso 1. Presentar Currículos ordenado por cantidad de Competencias  ______________________\u001B[0m");

        empresa.ordenarPorCompetencias();
        empresa.imprimirCVs();


        System.out.println("\n\t\u001B[34m Caso 1. Presentar Currículos ordenado por grado de titulación        ______________________\u001B[0m");
        empresa.ordenarPorNivelDeTitulación();
        empresa.imprimirCVs();


        System.out.println("\n\t\u001B[34m Caso 1. Presentar Currículos ordenado por experiencia Laboral        ______________________\u001B[0m");
        empresa.ordenarPorTiempoExperienciaLaboral();
        empresa.imprimirCVs();



    }
}