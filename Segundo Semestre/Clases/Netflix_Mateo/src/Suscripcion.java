public enum Suscripcion {
    BASICO(1, 4.99),
    ESTANDAR(2, 7.99),
    PREMIUM(5, 10.99),
    SIN_PAGAR(0, 0.0);

    private int numeroMaximoDeUsuarios;
    private double precio;

    Suscripcion(int numeroMaxDeUsuario, double precio) {
        this.numeroMaximoDeUsuarios = numeroMaxDeUsuario;
        this.precio = precio;
    }

    public int getNumeroMaximoDeUsuarios() {
        return numeroMaximoDeUsuarios;
    }

    public double getprecio() {
        return precio;
    }
}