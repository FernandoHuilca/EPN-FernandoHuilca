import java.awt.image.BandCombineOp;
import java.time.LocalDate;
import java.util.ArrayList;

// Author Fernando Huilca
public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        Título título1 = new Título(LocalDate.of(2000,5,25), "EPN", 1);
        Título título2 = new Título(LocalDate.of(2003,8,28), "ESPOL", 2);
        Título título3 = new Título(LocalDate.of(2006,11,30), "UCE", 3);

        Trabajo trabajo1 = new Trabajo(LocalDate.of(2000,1,10), LocalDate.of(2002, 3, 29), "Google");
        Trabajo trabajo2 = new Trabajo(LocalDate.of(2000,1,10), LocalDate.of(2002, 3, 29), "Google");
        Trabajo trabajo3 = new Trabajo(LocalDate.of(2000,1,10), LocalDate.of(2002, 3, 29), "Google");


        Competencia puntualidad = new Competencia("Puntualidad");
        Competencia paciencia = new Competencia("Paciencia");
        Competencia respeto = new Competencia("Respeto");
        Competencia trabajo = new Competencia("Trabajo");

        ArrayList<Competencia>listaCompetencias;
        listaCompetencias = new ArrayList<>();
        listaCompetencias.add(puntualidad);
        listaCompetencias.add(paciencia);
        listaCompetencias.add(respeto);
        listaCompetencias.add(trabajo);


        ArrayList<Título>listaTítulos;
        listaTítulos = new ArrayList<>();
        listaTítulos.add(título1);
        listaTítulos.add(título2);

        ArrayList<Trabajo>listaTrabajos;
        listaTrabajos = new ArrayList<>();
        listaTrabajos.add(trabajo1);
        listaTrabajos.add(trabajo2);

        CV cv1 = new CV(listaTítulos, listaTrabajos, listaCompetencias);




        Candidato fernandoH = new Candidato(cv1);

        fernandoH.getCompencias();



        Empresa.agregarCandidato(fernandoH);
        Candidato mateo = new Candidato(cv1);
        empresa.mostrarCandidatosPorTiempoDeExperiencia();



    }
}