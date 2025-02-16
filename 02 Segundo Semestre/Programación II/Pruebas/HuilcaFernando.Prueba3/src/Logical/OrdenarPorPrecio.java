package Logical;

import java.util.Comparator;

public class OrdenarPorPrecio implements Comparator<Pizza> {

    @Override
    public int compare(Pizza o1, Pizza o2) {
        return (int) (o1.getValorApagar() - o2.getValorApagar());
    }
}
