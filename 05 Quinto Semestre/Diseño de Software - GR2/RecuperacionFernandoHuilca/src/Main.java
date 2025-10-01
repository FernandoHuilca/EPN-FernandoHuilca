
public class Main {
    public static void main(String[] args) {
        Foco foco = new Foco();
        SensorLuminosidad sensorLuminosidad = new SensorLuminosidad();
        Habitacion habitacion = new Habitacion();

        habitacion.agregarSensor(sensorLuminosidad);
        sensorLuminosidad.agregarFocoAsignado(foco);

        habitacion.agregarFoco(foco);
        habitacion.agregarFoco(new Foco());
        habitacion.agregarFoco(new Foco());
        habitacion.agregarFoco(new Foco());
        habitacion.prenderFocos();


    }
}