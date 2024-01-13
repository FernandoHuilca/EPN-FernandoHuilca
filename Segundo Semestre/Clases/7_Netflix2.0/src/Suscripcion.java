public enum Suscripcion {
    BASICO(1, 4.99),
    ESTANDAR(2, 7.99),
    PREMIUM(5, 10.99),
    SIN_PAGAR(0, 0.0);

    private int numeroMaximoDePerfiles;
    private double precio;

    Suscripcion(int numeroMaximoDePerfiles, double precio) {
        this.numeroMaximoDePerfiles = numeroMaximoDePerfiles;
        this.precio = precio;
    }

    public String getNombreDeSuscripcion() {
        switch (this) {
            case BASICO:
                return "Básico";
            case ESTANDAR:
                return "Estándar";
            case PREMIUM:
                return "Premium";
            case SIN_PAGAR:
                return "Sin Pagar";
            default:
                return "Desconocido";
        }
    }


    public double getPrecio() {
        return  precio;
    }

    public int numPerfiles() {
        return numeroMaximoDePerfiles;
    }
}