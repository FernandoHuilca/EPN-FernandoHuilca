package Propuesta;

public abstract class Estado {
    protected MaquinaDeChicles maquina;
    public Estado(MaquinaDeChicles maquina) {
        this.maquina = maquina;
    }
    public abstract void insertarCuarto();
    public abstract void expulsarCuarto();
    public abstract void girarManivela();
    public abstract void dispensar();
}
