// Author Fernando Huilca
public class Main {
    public static void main(String[] args) {

        Calculadora poliCalculadora = new Calculadora();

        System.out.println("CASO DE PRUEBA 1");

        System.out.println(poliCalculadora.realizarOperacion(new Suma(), new Decimal(5), new Decimal(15))); // 5 + 15 = 20
        System.out.println(poliCalculadora.realizarOperacion(new Suma(), new Binario(11), new Binario(10))); // 3 + 2 = 5
        System.out.println(poliCalculadora.realizarOperacion(new Suma(), new Romano("VII"), new Romano("X"))); //7 + 5 = 12
        System.out.println(poliCalculadora.realizarOperacion(new Suma(), new Hexadecimal("C"), new Hexadecimal("E"))); // 12 + 14 = 26
        System.out.println(poliCalculadora.realizarOperacion(new Suma(), new Octal(17), new Octal(2))); // 15 + 2 = 17

        System.out.println("CASO DE PRUEBA 2");
        System.out.println(poliCalculadora.realizarOperacion(new Suma(), new Decimal(5.5), new Decimal(15))); // 5.5 + 15 = 20.5

        System.out.println("CASO DE PRUEBA 3");
        System.out.println(poliCalculadora.realizarOperacion(new Suma(), new Binario(11), new Octal(17))); // 3 +  15 = 18
        System.out.println(poliCalculadora.realizarOperacion(new Resta(), new Binario(11), new Octal(17))); // 3 -  15 = -12
        System.out.println(poliCalculadora.realizarOperacion(new Multiplicacion(), new Binario(11), new Octal(17))); // 3 *  15 = 45
        System.out.println(poliCalculadora.realizarOperacion(new Division(), new Octal(17), new Binario(11))); // 15 /  3 = 5


    }
}