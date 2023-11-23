public class Main {
    public static void main(String[] args) {

        Camiseta camiseta = new Camiseta("Negro", "XL");
        Camiseta camiseta2 = new Camiseta("Blanco", "XL");
        Camiseta camiseta3 = new Camiseta("Rojo", "XL");

        System.out.println("CASO DE PRUEBA 1: ");
        //Prueba para verificar si no puede ocupar una camiseta sucia
        camiseta.poner();
        camiseta.imprimirEstadoDeUso(); // SI esta en uso
        camiseta.sacar();
        camiseta.poner();
        camiseta.imprimirEstadoDeUso(); // NO esta en uso --> porque esta sucia
        camiseta.lavar();
        camiseta.poner();
        camiseta.imprimirEstadoDeUso(); // Si esta en uso --> Ya la lavamos esta limpia


        System.out.println("CASO DE PRUEBA 2: ");
        //Prueba para verificar que No se puede poner una camiseta daniada, se dania cuando se lava tres veces
        for (int i = 0; i < 3; i++) {
            camiseta2.poner();
            camiseta2.imprimirEstadoDeUso(); // SI esta en uso X3
            camiseta2.sacar();
            camiseta2.lavar();
        }
        camiseta2.poner();
        camiseta2.imprimirEstadoDeUso(); // No esta en uso --> porque esta daniada


        System.out.println("CASO DE PRUEBA 3: ");
        //Prueba para verificar que NO la puedo usar en caso de arreglarla 5 veces porque se dania definitivamente
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                camiseta3.poner();
                camiseta3.imprimirEstadoDeUso(); // Si esta en uso X15
                camiseta3.sacar();
                camiseta3.lavar();
            }
            camiseta3.arreglar();
        }
        camiseta3.poner();
        camiseta3.imprimirEstadoDeUso(); // NO esta en uso --> Por que esta daniada definitivamente

    }
}