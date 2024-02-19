import java.util.Collections;
import java.util.Comparator;

public class OrdenarPorTitulación implements Comparator<CV> {
    @Override
    public int compare(CV o1, CV o2) {
        return o1.getNivelDelTitulo() - o2.getNivelDelTitulo();
    }
}
