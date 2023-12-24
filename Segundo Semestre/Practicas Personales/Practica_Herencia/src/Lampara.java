public class Lampara extends Electrodomestico {
    private String modelo;

    public Lampara(String modelo, double precio, String marca, String nombre){
        super(precio, marca, nombre);
        this.modelo = modelo;

    }
}
