import Calculadora.Calculadora;
import Calculadora.*;

// Fernando Huilca
public class Main {
    public static void main(String[] args) {
        Calculadora policalculadora = new Calculadora();

        métodoProblemático();
        métodoProblemático3();
        try {
            métodoProblemático3();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            métodoProblemático2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {

            System.out.println(args[0]);
            ejecutarUnMétodoRecursivo();
            policalculadora.dividir(8, 0);
        } catch (DividirPorCero e) {
            System.out.println(e.getMessage() );
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Intentó acceder a un índice fuera de los límites!! : "+ e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }



    }

    public static void métodoProblemático(){
        try {
            throw new DividirPorCero();
        } catch (DividirPorCero e) {
            System.out.println(e.getMessage());
        }
    }
    public static void métodoProblemático2() throws Exception{
        throw new Exception("Auxilio!!! soy un error");
    }



    /*********************************************************/
    public static void métodoProblemático3() throws NullPointerException{
        throw new NullPointerException("ERROR: NULOOOO!!");  //TODO: Preguntar porque no me manda a corregir en el main
    }
    /*********************************************************/



    private static void ejecutarUnMétodoRecursivo() {
        ejecutarUnMétodoRecursivo();
    }

}
