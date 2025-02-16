
public class Raton {

    //Atributos
    private String marca;
    private int DPI;
    private boolean clic_Derecho;
    private boolean clic_Izquierdo;
    private boolean rueda;
    private String color;

    //Metodos
    // Metodo constructor
    public Raton(String marca, int DPI, boolean clic_Derecho, boolean clic_Izquierdo, boolean rueda, String color) {
        this.marca = marca;
        this.DPI = DPI;
        this.clic_Derecho = clic_Derecho;
        this.clic_Izquierdo = clic_Izquierdo;
        this.rueda = rueda;
        this.color = color;
    }


    public String getMarca() {
        return marca;
    }
}
