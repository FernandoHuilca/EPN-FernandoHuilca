public class Ropa {
    private final String nombre;
    private final int climaDeUsoOptimo;

    public Ropa(String nombre, int climaDeUsoOptimo) {
        this.nombre = nombre;
        this.climaDeUsoOptimo = climaDeUsoOptimo;

    }

    @Override
    public String toString() {
        return "Ropa{" +
                "string='" + nombre + '\'' +
                ", climaDeUsoOptimo=" + climaDeUsoOptimo +
                '}';
    }

    public String getNombre() {
    return nombre;
    }

    public int getClima() {
        return climaDeUsoOptimo;
    }
}
