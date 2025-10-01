public class UmbralLuz extends VerificadorUmbral {

    public UmbralLuz() {
        this.cantidadMax = 400;
        this.cantidadMin = 200;
    }

    @Override
    Boolean verificarMax(Double cantidad) {
        return cantidad >= this.cantidadMax;
    }

    @Override
    Boolean verificarMin(Double cantidad) {
        return cantidad <= this.cantidadMin;
    }
}
