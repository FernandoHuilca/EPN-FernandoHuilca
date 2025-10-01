
public class FiltroEnlace extends FiltroMensaje {

    @Override
    public boolean filtrar(String mensaje){
        System.out.println("Filtrado de enlaces siempre aprueba");
        return true;
    }
}