public class Suma extends Operacion {

    double realizarCalculo(SistemaNumerico valor1, SistemaNumerico valor2){
        return valor1.cambiarADecimal() + valor2.cambiarADecimal();
    }
}
