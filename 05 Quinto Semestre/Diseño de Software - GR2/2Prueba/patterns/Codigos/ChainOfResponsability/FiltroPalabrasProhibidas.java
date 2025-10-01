
public class FiltroPalabrasProhibidas extends FiltroMensaje {
    @Override
    public boolean filtrar(String mensaje) {
        if (mensaje.contains("puto")) {
            System.out.println("Mensaje prohibido: " + mensaje);
            return false;
        } else{
           System.out.println(" Paso filtro de palabras prohibidas");
            return true; 
        }
    }
}
