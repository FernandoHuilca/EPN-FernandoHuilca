import java.util.ArrayList;
import java.util.Collections;

// Author Fernando Huilca
public class Main {
    public static void main(String[] args) {
       /* ************ ARREGLO ESTÁTICO ************
     int[] a; //Declaro
     a = new int[5]; //Instancia
        //manipulacion
        a[3] = 10;
        System.out.println(a);
        System.out.println(a[3]);
        imprimir1(a);

        imprimir2(a);
        //************* ARREGLO DINÁMICO Genérico *************
        ArrayList ad;
        ad = new ArrayList();
        ad.add(10);
        ad.add(9);
        ad.add(30);
        ad.add(8);
        ad.add("Hola");
        ad.add(5);
        ad.remove(3);
        System.out.println(ad);
        System.out.println(ad.get(2));
        //************* ARREGLO DINÁMICO Específico *************
        ArrayList <String> adg;
        adg = new ArrayList<String>();
        adg.add("Fernando");
        adg.add("Eliceo");
        imprimir3(adg);

        //Uso de Collections
        Collections.sort(adg);
        imprimir3(adg);
        System.out.println(Collections.max(adg));
        System.out.println(Collections.min(adg));      */

        ArrayList<Estudiante> ad;
        ad = new ArrayList<Estudiante>();
        

    }






    private static void imprimir1(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++){
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
    private static void imprimir2(int[] arreglo) {
        for (int magia : arreglo){
            System.out.print(magia + " ");
        }
        System.out.println();
    }
    private static void imprimir3(ArrayList<String> x) {
        for (String magia : x){
            System.out.print(magia + " ");
        }
        System.out.println();
    }

}