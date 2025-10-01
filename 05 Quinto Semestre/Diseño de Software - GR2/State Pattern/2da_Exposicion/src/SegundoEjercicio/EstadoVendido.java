package SegundoEjercicio;

public class EstadoVendido implements Estado {

    //Necesitamos el contexto:
    private MaquinaDeChicles maquina;


    //En el constructor nos pasa el contexto:
    public EstadoVendido(MaquinaDeChicles maquina) {
        this.maquina = maquina;
    }

    //Definimos qué pasa en cada estado:
    @Override
    public void insertarCuarto() {
        System.out.println("Por favor espere. Estamos vendiendo otro chicle.");
    }

    @Override
    public void expulsarCuarto() {
        System.out.println("Ya giraste la manivela, no se te devolverá tus 0.25$");
    }

    @Override
    public void girarManivela() {
        System.out.println("Girar dos veces no te dará otro chicle.");
    }
    // Este metodo es el complejo:
    @Override
    public void dispensar() {
        //System.out.println("Aquí tienes tu chicle.");
        maquina.liberarChicle();
        if (maquina.getContadorChicles() > 0) {
            maquina.setEstado(maquina.getEstadoNoCuarto());
        }
        else {
            System.out.println("Ups! Se agotaron los chicles.");
            maquina.setEstado(maquina.getEstadoAgotado());
        }
    }
}
