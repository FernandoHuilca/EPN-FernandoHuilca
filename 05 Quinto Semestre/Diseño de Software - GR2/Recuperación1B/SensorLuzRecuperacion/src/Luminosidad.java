import java.util.ArrayList;

public class Luminosidad {
    private ArrayList<Sensor> listSensoresEscuchadores;
    private double cantidadLuminosidad;

    public Luminosidad() {
        listSensoresEscuchadores = new ArrayList<Sensor>();
        cantidadLuminosidad = 0.0;
    }

    public void sumarLumenes(double lumenes) {
        cantidadLuminosidad += lumenes;
    }

    public Double getCantidadLuminosidad() {
        return cantidadLuminosidad;
    }

    public void agregarSensor(Sensor sensor){
        listSensoresEscuchadores.add(sensor);
    }

    public void eliminarSensor(Sensor sensor){
        listSensoresEscuchadores.remove(sensor);
    }

    public void notificar(Double cantidadLuminosidad) {
        for (Sensor sensor : listSensoresEscuchadores) {
            sensor.actualizar(cantidadLuminosidad);
        }
    }
}
