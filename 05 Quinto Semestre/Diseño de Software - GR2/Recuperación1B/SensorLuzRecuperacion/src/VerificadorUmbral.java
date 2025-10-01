public abstract class VerificadorUmbral {
    protected double cantidadMax;
    protected double cantidadMin;

    abstract Boolean verificarMax(Double cantidad);
    abstract Boolean verificarMin(Double cantidad);
}
