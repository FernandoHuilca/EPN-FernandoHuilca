public class Competencia {
    private String nombre;
    public Competencia(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Competencia{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
