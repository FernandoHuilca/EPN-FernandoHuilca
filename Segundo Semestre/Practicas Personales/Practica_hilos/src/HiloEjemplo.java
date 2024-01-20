public class HiloEjemplo extends Thread{

    @Override
    public void run() { // Estamos sobreescribiendo este método de la clase padre "Thread"
        try {
            System.out.println("Fernando");
            Thread.sleep(5000);
            System.out.println("Adios Fernando");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
