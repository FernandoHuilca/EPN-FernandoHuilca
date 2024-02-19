import java.util.Comparator;

public class OrdenarPorExperiencia implements Comparator<CV> {
    @Override
    public int compare(CV o1, CV o2) {
        return o1.getExperienciaLaboral() - o2.getExperienciaLaboral() ;
    }
}
