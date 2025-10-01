package SegundoEjercicio;

public class EstadoGanador implements Estado {

    //Necesitamos el contexto:
    private MaquinaDeChicles maquina;

    public EstadoGanador(MaquinaDeChicles maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarCuarto() {
        System.out.println("Error: Estado ganador insertar cuarto");
    }

    @Override
    public void expulsarCuarto() {
        System.out.println("Error: Estado ganador expulsar cuarto");

    }

    @Override
    public void girarManivela() {
        System.out.println("Error: Estado ganador girar manivela");
    }

    @Override
    public void dispensar() {
        System.out.println("Eres un ganador!! Tienes dos chicles por tu 0.25$");
        maquina.liberarChicle();
        if (maquina.getContadorChicles() == 0){
            maquina.setEstado(maquina.getEstadoAgotado());
        }else {
            maquina.liberarChicle();
            if(maquina.getContadorChicles() > 0){
                maquina.setEstado(maquina.getEstadoNoCuarto());
            }else{
                System.out.println("Oops!! la maquina se quedó sin chicles.");
                maquina.setEstado(maquina.getEstadoAgotado());
            }
        }
    }
}
