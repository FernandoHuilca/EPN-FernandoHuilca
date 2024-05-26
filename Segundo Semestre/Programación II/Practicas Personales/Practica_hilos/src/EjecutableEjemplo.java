public class EjecutableEjemplo implements Runnable {
    @Override
    public void run() {

        try {
            System.out.println("Eliceo");
            Thread.sleep(4000);
            System.out.println("Adios Eliceo");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
