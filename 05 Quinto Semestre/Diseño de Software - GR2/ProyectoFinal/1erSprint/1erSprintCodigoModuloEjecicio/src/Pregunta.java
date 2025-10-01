public abstract class Pregunta {
    protected String enunciado;
    public abstract String getInstruccion();

    public String getEnunciado(){
        return enunciado;
    };

    public abstract int getNumOpciones();

    public abstract Opcion getOpcion(int numOpcion);
}
