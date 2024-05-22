package Logical;

public enum TipoPiza {
    PEQUENIA(2.0),
    MEDIANA(3.0),
    GRANDE(4.0);

    protected double precioPorIngredienteExtra;

    TipoPiza(double precio){
        this.precioPorIngredienteExtra = precio;
    }

}
