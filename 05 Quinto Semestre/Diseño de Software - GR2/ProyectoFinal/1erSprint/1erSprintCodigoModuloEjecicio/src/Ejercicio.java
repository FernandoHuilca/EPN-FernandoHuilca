import java.util.ArrayList;

public class Ejercicio {
    ESTADO estado;
    ArrayList<Pregunta> listPreguntas;

    public Ejercicio() {
        estado = ESTADO.INACTIVO;
        listPreguntas = new ArrayList<>();
    }


    public ESTADO getEstado() {
    return estado;
    }
    public boolean setEstado(ESTADO estado) {
    this.estado = estado;
        return true;
    }

    public ArrayList<Pregunta> getListPreguntas() {
    return listPreguntas;
    }

    public int getNumPreguntas() {
        return listPreguntas.size();
    }

    public Pregunta getPregunta(int i) {
        return listPreguntas.get(i);
    }

    public void agregarPregunta(Pregunta nuevaPregunta) {
        listPreguntas.add(nuevaPregunta);
    }
}
