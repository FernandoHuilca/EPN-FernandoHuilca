package Logical;
import java.util.ArrayList;
import java.util.Collections;

public class Empresa {
    ArrayList<CV> cvs;

    public Empresa(){
        cvs = new ArrayList<CV>();
    }


    public void addCV(CV cv) {
        cvs.add(cv);
    }


    public void ordenarPorNivelDeTitulación() {
        Collections.sort(cvs, new OrdenarPorTitulación());
    }

    public void ordenarPorTiempoExperienciaLaboral() {
        Collections.sort(cvs,new OrdenarPorExperiencia());
    }

    public void ordenarPorCompetencias() {
        Collections.sort(cvs, new OrdenarPorCompetencias());
    }

    public void imprimirCVs() {
        for (CV magia : cvs){
            System.out.println(magia);
        }
    }

    public ArrayList<CV> getCVs() {
    return cvs;
    }
}
