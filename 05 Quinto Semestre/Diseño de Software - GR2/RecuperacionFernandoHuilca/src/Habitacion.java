import java.util.ArrayList;

public class Habitacion {
    private Luminosidad luminosidad;
    private ArrayList<Foco> listFocos;
    private ArrayList<Sensor> listSensores;

    public Habitacion() {
        listFocos = new ArrayList<Foco>();
        luminosidad = new Luminosidad();
        listSensores = new ArrayList<Sensor>();
    }

    public void agregarFoco(Foco foco) {
        listFocos.add(foco);
    }

    public void prenderFocos() {
        for (Foco foco : listFocos) {
            foco.prender();
            luminosidad.sumarLumenes(foco.getlumenesEmitidos()) ;
            System.out.println("Luminosidad habitación: " + luminosidad.getCantidadLuminosidad());
        }
        luminosidad.notificar(luminosidad.getCantidadLuminosidad());
    }


    public void agregarSensor(Sensor sensor) {
        listSensores.add(sensor);
        luminosidad.agregarSensor(sensor);
    }
}
