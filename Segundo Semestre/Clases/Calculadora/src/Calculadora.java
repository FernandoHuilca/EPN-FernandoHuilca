public class Calculadora {
    public double realizarOperacion(Operacion operacion, SistemaNumerico valor1, SistemaNumerico valor2) {
    //public double realizarOperacion(Operacion operacion, double a, double b) {
        return operacion.realizarCalculo(valor1, valor2);
    }
}
