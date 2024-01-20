// Author: Fernando Huilca
public class Main {
    public static void main(String[] args) {

        HiloEjemplo hiloEjemplo = new HiloEjemplo();
        EjecutableEjemplo ejecutableEjemplo = new EjecutableEjemplo();

        System.out.println("Primero se ejecuta esta linea");

        hiloEjemplo.start(); // hace que el hilo se inicie en segundo plano

        Thread thread = new Thread(ejecutableEjemplo); //Le paso una clase que implementa run()
        thread.start();
        System.out.println("Acabo con esta, pero a continuación se ejecuta en segundo plano los hilos");



    }
}