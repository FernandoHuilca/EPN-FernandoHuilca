package Logical;

import java.util.ArrayList;

public class Empresa {

    ArrayList<Orden> ordenes;

    public Empresa(){
        this.ordenes = new ArrayList<Orden>();
    }

    public void agregarOrden(Orden orden) {
        ordenes.add(orden);
    }

    public double valorAPagar(int numOrden) {
        if (ordenes.size() == 10 ){
            return 0.0;
        }else {
            return ordenes.get(numOrden).valorAPagar();
        }
    }


}
