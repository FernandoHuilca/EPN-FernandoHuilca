package PrimerEjercicio;

public class EstadoTieneCuarto implements Estado {

    //Necesitamos el contexto:
    private MaquinaDeChicles maquina;


    //En el constructor nos pasa el contexto:
    public EstadoTieneCuarto(MaquinaDeChicles maquina) {
        this.maquina = maquina;
    }

    //Definimos qué pasa en cada estado:
    @Override
    public void insertarCuarto() {
        System.out.println("Ya hay 0.25$, no puedes insertar otro cuarto.");
    }

    @Override
    public void expulsarCuarto() {
        System.out.println("Expulsando 0.25$.");
        maquina.setEstado(maquina.getEstadoNoCuarto());
    }

    @Override
    public void girarManivela() {
        System.out.println("Cumpliste requisitos.");
        maquina.setEstado(maquina.getEstadoVendido());
    }

    @Override
    public void dispensar() {
        System.out.println("Tiene cuarto pero no ha girado la manivela.");
    }
}




