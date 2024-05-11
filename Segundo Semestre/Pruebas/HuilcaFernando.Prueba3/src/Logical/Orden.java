package Logical;

import java.util.ArrayList;
import java.util.Collections;

public class Orden {
    private ArrayList<Pizza> listPizzas;

    public Orden(ArrayList<Pizza> listPizzas) {
        this.listPizzas = listPizzas;
    }

    public double valorAPagar() {
        Collections.sort(listPizzas, new OrdenarPorPrecio());

        double total = 0;
        int pizzasCompradas = listPizzas.size();
        int pizzasConDescuento = pizzasCompradas / 2;

        for (int i = 0; i < pizzasCompradas; i++) {
            if (i < pizzasConDescuento) {
                total += listPizzas.get(i).getValorApagar() / 2;
            } else {
                total += listPizzas.get(i).getValorApagar();
            }
        }
        return total;

    }
}
