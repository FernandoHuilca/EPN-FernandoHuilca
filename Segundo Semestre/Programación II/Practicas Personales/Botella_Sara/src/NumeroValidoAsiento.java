public class NumeroValidoAsiento extends Exception {
    public NumeroValidoAsiento() {
        super("No existen los asientos negativos, ceros o mayores a los disponibles");
    }
}
