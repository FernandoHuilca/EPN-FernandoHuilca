import ProductosVenta.CompararPorCantidadStock;
import ProductosVenta.ProductoDeVenta;

import java.util.ArrayList;
import java.util.Collections;

// Author Fernando Huilca
public class Main {
    public static void main(String[] args) {
        /* *
         *
         * En Java, existen diferentes formas de ordenar y guardar datos, las llamamos colecciones, vamos a
         * revisar las siguientes: Arreglo estático, arreglo dinámico y hasMap
         *
         */

        ProductoDeVenta producto1 = new ProductoDeVenta("Caja de arena para gatos", 4);
        ProductoDeVenta producto2 = new ProductoDeVenta("Teclado Mecánico", 10);
        ProductoDeVenta producto3 = new ProductoDeVenta("bicicleta", 2);
        ProductoDeVenta producto4 = new ProductoDeVenta("televisión", 8);

        System.out.println("\n\t\u001B[34m Arreglos estáticos _____________________________________________\u001B[0m");
        //------------------ Arreglos estáticos ------------------------------
        ProductoDeVenta[] productos;
        productos = new ProductoDeVenta[4]; //Hay que especificar cuál es el número de elementos por guardar
        //ahora, para guardar algún dato tenemos muchas maneras una de estas es:
        productos[0] = producto1;
        productos[1] = producto2;
        productos[2] = producto3;
        productos[3] = producto4;
        //Ahora, si queremos imprimir estos datos:
        System.out.println(productos); //Esto no me va a imprimir el contenido uno por uno, si una dirección del arreglo
        //Podemos crear un método que me sirva para imprimir el contenido interno:
        imprimirArreglo(productos);
        //¿Podemos ordenar este arreglo? Sí, pero su implementación va a ser más compleja


        System.out.println("\n\t\u001B[34m Arreglos dinámicos _____________________________________________\u001B[0m");
        //------------------ Arreglos dinámicos ------------------------------
        ArrayList<ProductoDeVenta> productosAD;
        productosAD = new ArrayList<>();
        // Para guardar datos lo hacemos de la siguiente manera:
        productosAD.add(producto1);
        productosAD.add(producto2);
        productosAD.add(producto3);
        productosAD.add(producto4);
        //Ahora, si queremos imprimir estos datos:
        System.out.println(productosAD);// Si tiene el toString, si se imprime la información
        //La utilización de ArrayList va muy enfocada a la facilidad que esta nos brinda al momento de ordenar elementos
        Collections.sort(productosAD);
        System.out.println("YA ORDENADO POR NOMBRE:");
        System.out.println(productosAD); //Definiendo en la clase ProductosVenta el comparar con qué
        Collections.sort(productosAD, new CompararPorCantidadStock());

        System.out.println("YA ORDENADO POR CANTIDAD EN STOCK:");
        System.out.println(productosAD);
        System.out.println("MAYOR A MENOR:");
        Collections.reverse(productosAD);
        System.out.println(productosAD);

    }


    //______________________ Métodos de ayuda, no son tan relevantes ________________________
    private static void imprimirArreglo(ProductoDeVenta[] productos) {
        for (ProductoDeVenta magia : productos) { //Usamos un for mejorado
            System.out.println(magia);
        }
    }
}