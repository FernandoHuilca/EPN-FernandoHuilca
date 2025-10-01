import java.util.ArrayList;

public class PreguntaOpcionMultiple extends Pregunta {
    private ArrayList<Opcion> listOpciones;
    private boolean yaContestada;

    public PreguntaOpcionMultiple(String enunciado) {
        this.enunciado = enunciado;
        this.listOpciones = new ArrayList<>();
    }

    @Override
    public String getInstruccion() {
        return "Selecciones la opción correcta.";
    }


    @Override
    public int getNumOpciones() {
        return listOpciones.size();
    }

    @Override
    public Opcion getOpcion(int numOpcion) {
        return listOpciones.get(numOpcion);
    }

    public void agergarOpcion(Opcion opcion) {
        listOpciones.add(opcion);
    }
}
