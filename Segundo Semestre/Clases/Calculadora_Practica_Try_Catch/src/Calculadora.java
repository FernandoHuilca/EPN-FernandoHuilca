public class Calculadora {
    public int dividir(int a, int b) throws DividirPorCero{
        if (b == 0){
            throw new DividirPorCero();
        }

        return (a / b);
    }



}
