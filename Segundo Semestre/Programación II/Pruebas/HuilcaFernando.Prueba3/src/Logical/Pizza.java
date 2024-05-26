package Logical;

import java.util.ArrayList;

public class Pizza {


    private TipoPiza tipoPiza;
    private ArrayList<Ingrediente> listIngredientes;

    public Pizza(TipoPiza tipoPiza, ArrayList<Ingrediente> listIngredientes) {
        this.tipoPiza = tipoPiza;
        this.listIngredientes = listIngredientes;
    }

    public double getValorApagar() {
        return tipoPiza.precioPorIngredienteExtra * listIngredientes.size();
    }
}
