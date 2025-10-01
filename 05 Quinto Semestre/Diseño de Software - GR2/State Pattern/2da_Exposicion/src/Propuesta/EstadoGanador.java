package Propuesta;

public class EstadoGanador extends Estado {


    public EstadoGanador(MaquinaDeChicles maquina) {
        super(maquina);
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
            maquina.setEstado(new EstadoAgotado(maquina));
        }else {
            maquina.liberarChicle();
            if(maquina.getContadorChicles() > 0){
                maquina.setEstado(new EstadoNoCuarto(maquina));
            }else{
                System.out.println("Oops!! la maquina se quedó sin chicles.");
                maquina.setEstado(new EstadoAgotado(maquina));
            }
        }
    }
}
