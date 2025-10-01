public class FiltroDeLongitud extends FiltroMensaje {
    
    
@Override
public boolean filtrar(String mensaje){
    if (mensaje.length() > 10) {
        System.out.println("Error: Mensaje muy largo");
        return false;
    }
    else{
        System.out.println(" Mensaje Aprobado por longitud");
        return true;
    }
}    

}
