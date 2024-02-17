public class CancelarVuelo extends Exception {
    public CancelarVuelo() {
        super("No puedes cancelar un ticket si no lo has comprado");
    }
}
