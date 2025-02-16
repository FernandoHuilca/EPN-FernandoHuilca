public class ListaTareas {
    private String nombreDeLaLista;
    private int numeroDeTareasMaximas; //TODO: preguntar a Carlos God si esta bien o puedo dispensar de esto
    private Tarea[] tareas;
    private int contadorTareas;

    public ListaTareas(String nombreDeLaLista, int numeroDeTareasMaximas) {
        this.nombreDeLaLista = nombreDeLaLista;
        this.numeroDeTareasMaximas = numeroDeTareasMaximas;
        tareas = new Tarea[numeroDeTareasMaximas];
        contadorTareas = 0;
    }

    public void agregarTarea(String descripcionTarea, String fecha, String estadoDeTarea) {
    Tarea nuevaTarea = new Tarea(descripcionTarea, fecha, estadoDeTarea);
    tareas[contadorTareas++] = nuevaTarea;
        System.out.println("\u001B[32mTarea agregada con exito!! \u001B[0m");
    }

    @Override
    public String toString() {
        return  nombreDeLaLista + "\nLas tareas de esta lista son: " + contadorTareas ;
    }

    public void imprimirTareasPendienes() {
        for (int i = 0; i < contadorTareas; i++){
            if (tareas[i].imprimirEstado() == "Pendiente"){
                System.out.println(tareas[i]);
            }
        }
    }
}
