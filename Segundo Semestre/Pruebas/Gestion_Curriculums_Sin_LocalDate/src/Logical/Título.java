package Logical;

public class Título {
    private int año;
    private int mes;
    private int día;
    private String universidad;
    private int nivelTítulo;

    public Título(int año, int mes, int día, String universidad, int nivelTítulo) {
        this.año = año;
        this.mes = mes;
        this.día = día;
        this.universidad = universidad;
        this.nivelTítulo = nivelTítulo;
    }

    public int nivelTitulo() {
        return 0;
    }
}
