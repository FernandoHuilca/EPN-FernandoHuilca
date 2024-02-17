import java.util.ArrayList;

public class Candidato {
   private CV cv;
   private double experienciaLaboral;

    public Candidato(CV cv) {
        this.cv = cv;
        experienciaLaboral = cv.experienciaLaboral();
    }
    public double getExperienciaLaboral(){
        return experienciaLaboral;
    }

    public void getCompencias() {
        cv.getCompencias();
    }
}
