// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Camiseta camiseta = new Camiseta("negra", "XL");

        camiseta.ponerse();
        camiseta.imprimirEstadoDeUso();// Si esta en uso
        camiseta.sacarse();
        camiseta.imprimirEstadoDeUso();// No esta en uso
        camiseta.ponerse();
        camiseta.imprimirEstadoDeUso();// NO ESTA EN USO --> ERROR porque esta sucia
        camiseta.sacarse();
        camiseta.lavar(); // ya esta lavada una vez
        camiseta.ponerse();
        camiseta.imprimirEstadoDeUso(); // si esta en uso


        camiseta.sacarse();
        camiseta.lavar();
        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); // ya esta lavado 3 veces debe estar daniada
        camiseta.ponerse();
        camiseta.imprimirEstadoDeUso(); // NO ESTA EN USO --> porque esta daniada daniada 1 una vez
        camiseta.sacarse();
        camiseta.lavar(); //lavado una vez


        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); // 2
        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); //3 esta da;anda
        camiseta.arreglar(); //arrelago 2 veces

        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); // 1
        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); //2
        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); //3
        camiseta.arreglar(); //arrelago 3 veces

        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); // 1
        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); //2
        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); //3
        camiseta.arreglar(); //arrelago 4 veces


        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); // 1
        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); //2
        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); //3
        camiseta.arreglar(); //arrelago 5 veces YA ESTA ROTA NO LA PUEDO PONER NUNCA MAS

        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); // 1
        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); //2
        camiseta.ponerse();
        camiseta.sacarse();
        camiseta.lavar(); //3
        camiseta.arreglar();

        camiseta.ponerse();
        camiseta.imprimirEstadoDeUso(); // NO ES POSIBLEEE



    }
}