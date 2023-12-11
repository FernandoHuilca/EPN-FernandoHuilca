public class Tarea {
    private String estadoDeTarea;
    private String fecha;
    private String  descripcion;

    public Tarea(String descripcionTarea, String fecha, String estadoDeTarea) {
    this.descripcion = descripcionTarea;
    this.fecha = fecha;
    this.estadoDeTarea = estadoDeTarea;
    }

    public String imprimirEstado() {
        return estadoDeTarea;
    }

    @Override
    public String toString() {
        return "Tarea__________" + "\n" + descripcion + "\n" + fecha + "\n"+ estadoDeTarea;
    }
}
