package Cliente;

import java.io.Serializable;

public class Cliente implements Serializable {
    String nombre = "Daniel Noboa";
    public Cliente() {

    }
    public String getNombre(){
        return nombre;
    }
}
