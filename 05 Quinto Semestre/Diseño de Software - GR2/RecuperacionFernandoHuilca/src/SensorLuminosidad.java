import java.util.ArrayList;

public class SensorLuminosidad implements Sensor{
    private VerificadorUmbral umbralLuz;
    private ArrayList<Foco> listaFocosAsignados;

    public SensorLuminosidad() {
        listaFocosAsignados = new ArrayList<>();
        umbralLuz = new UmbralLuz();
    }

    @Override
    public void actualizar(Double cantidadLuminosidad) {
        if (umbralLuz.verificarMax(cantidadLuminosidad)) {
            for (Foco foco : listaFocosAsignados) {
                foco.apagar();
                System.out.println(" Luminosidad muy alta:  Apagué foco");
            }

        }
        if (umbralLuz.verificarMin(cantidadLuminosidad)) {
            for (Foco foco : listaFocosAsignados) {
                foco.prender();
                System.out.println("Luminosidad muy baja: Encendí foco");
            }
        }
    }
    public void agregarFocoAsignado(Foco foco) {
        listaFocosAsignados.add(foco);
    }
}
