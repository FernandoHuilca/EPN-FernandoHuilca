package SegundoEjercicio;

public class EstadoNoCuarto implements Estado {
    //Necesitamos el contexto:
    private MaquinaDeChicles maquina;

    //En el constructor nos pasa el contexto:
    public EstadoNoCuarto(MaquinaDeChicles maquina) {
        this.maquina = maquina;
    }

    //Definimos qué pasa en cada estado:
    @Override
    public void insertarCuarto() {
        System.out.println("Insertó una moneda de 0.25 cts");
        maquina.setEstado(maquina.getEstadoTieneCuarto());
    }

    @Override
    public void expulsarCuarto() {
        System.out.println("No puedes expulsar 0.25$ porque no lo haz insertado aún.");
    }

    @Override
    public void girarManivela() {
        System.out.println("Giraste, pero no hay 0.25$");
    }

    @Override
    public void dispensar() {
        System.out.println("Primero debes pagar 0.25$");
    }
}
