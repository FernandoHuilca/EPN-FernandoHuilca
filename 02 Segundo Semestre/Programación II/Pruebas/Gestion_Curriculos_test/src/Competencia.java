public class Competencia {

    private String competencia;

    public Competencia(String competencia) {
        this.competencia = competencia;
    }

    @Override
    public String toString() {
        return "\n" + competencia + "\n\n " ;
    }
}
