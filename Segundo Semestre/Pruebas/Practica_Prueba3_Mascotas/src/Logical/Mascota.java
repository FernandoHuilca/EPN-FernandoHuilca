package Logical;

public class Mascota {
    protected String nombre;
    private String especie;
    private int edad;
    private String dueño;

    public Mascota(String nombre, String especie, int edad, String dueño) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.dueño = dueño;
    }

    public String getNombre() {
        return nombre;
    }
}
