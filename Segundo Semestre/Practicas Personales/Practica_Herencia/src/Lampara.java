public class Lampara extends Electrodomestico {
    private String modelo;

    public Lampara(String modelo, double precio, String marca){
        super(precio, marca);
        this.modelo = modelo;

    }
}
