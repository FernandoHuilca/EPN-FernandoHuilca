package Propuesta;

public class EstadoAgotado extends Estado {
    //En el constructor nos pasa el contexto:
    public EstadoAgotado(MaquinaDeChicles maquina) {
        super(maquina);
    }

    //Definimos qué pasa en cada estado:
    @Override
    public void insertarCuarto() {
        System.out.println("No hay chicles disponibles.");
    }

    @Override
    public void expulsarCuarto() {
        System.out.println("No hay chicles disponibles.");
    }

    @Override
    public void girarManivela() {
        System.out.println("No hay chicles disponibles.");
    }

    @Override
    public void dispensar() {
        System.out.println("No hay chicles disponibles.");
    }
}
