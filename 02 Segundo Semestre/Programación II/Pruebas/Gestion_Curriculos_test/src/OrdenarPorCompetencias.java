import java.util.Comparator;

public class OrdenarPorCompetencias implements Comparator <CV> {
    @Override
    public int compare(CV o1, CV o2) {
        return o1.getCantidadDeCompetencias() - o2.getCantidadDeCompetencias();
    }
}
