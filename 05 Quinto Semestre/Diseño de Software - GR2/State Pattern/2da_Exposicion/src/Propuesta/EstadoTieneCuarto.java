package Propuesta;

import java.util.Random;

public class EstadoTieneCuarto extends Estado {

    // Para la nueva regla ______________________________________
    Random ganadorRandom = new Random(System.currentTimeMillis());
    // __________________________________________________________



    //En el constructor nos pasa el contexto:
    public EstadoTieneCuarto(MaquinaDeChicles maquina) {
        super(maquina);
    }

    //Definimos qué pasa en cada estado:
    @Override
    public void insertarCuarto() {
        System.out.println("Ya hay 0.25$, no puedes insertar otro cuarto.");
    }

    @Override
    public void expulsarCuarto() {
        System.out.println("Expulsando 0.25$.");
        maquina.setEstado(new EstadoNoCuarto(maquina));
    }

    @Override
    public void girarManivela() {
        //________________________________
        int ganador = ganadorRandom.nextInt(10);
        if (ganador == 0 && (maquina.getContadorChicles() > 1)) {
        maquina.setEstado(new EstadoGanador(maquina));
        //________________________________
        }else {
            System.out.println("Cumpliste requisitos.");
            maquina.setEstado(new EstadoVendido(maquina));
        }
    }

    @Override
    public void dispensar() {
        System.out.println("Tiene cuarto pero no ha girado la manivela.");
    }
}
