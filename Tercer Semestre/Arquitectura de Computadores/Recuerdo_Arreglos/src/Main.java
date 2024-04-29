import java.util.Arrays;

// Author: Fernando Huilca
// Date: 28/04/2024
public class Main {
    public static void main(String[] args) {
        //Esto es un repaso para recordar de que se trataban los arreglos en Java y cómo ocuparlos
        // Pues es un tema que mi profesor de Arquitectura nos pidió que repasemos para la siguiente clase

        // Un arreglo es una estructura de datos que no brinda la facilidad de almacenar en una sola variable
        // valores o elementos de un mismo tipo
        // Ejm:

        int[] numeros = new int[5];
        // Asignación de valores
        numeros[0] = 22;
        numeros[1] = 35;
        numeros[2] = 44;
        numeros[3] = 56;
        numeros[4] = 28;

        System.out.println("El tamanio del arreglo es: " + numeros.length + ".");

        int contador;
        contador = 0;
        System.out.println("Los números del arreglo son: ");
        for ( int magia: numeros){
            System.out.println( magia + " índice: " + contador++ + "."
            );
        }

        Estudiante estudiante0;
        estudiante0 = new Estudiante("Fernando");

        Estudiante[] estudiantes = new Estudiante[50];

        estudiantes[0] = estudiante0;
        estudiantes[1] = new Estudiante("Mateo");
        estudiantes[2] = new Estudiante("Juan");
        estudiantes[3] = new Estudiante("Pepe");
        estudiantes[4] = new Estudiante("Messi");



        System.out.println("El estudiante " + estudiante0.name + " está reprobado ");
        System.out.println("El estudiante " + estudiantes[1].name + " está aprobado ");


        System.out.println("Los estudiantes del arreglo son: ");
        for ( Estudiante magia: estudiantes){
            try {
                System.out.println(magia.name);
            } catch(NullPointerException e){
                //System.out.println("ERROR: el estudiante es nulo");
                break;
            }
        }


        Estudiante[] arregloEstudiantesCopiaDelAnterior = estudiantes.clone();

        System.out.println("Los estudiantes del arreglo clonado son: ");
        for ( Estudiante magia: arregloEstudiantesCopiaDelAnterior){
            try {
                System.out.println(magia.name);
            } catch(NullPointerException e){
                //System.out.println("ERROR: el estudiante es nulo");
                break;
            }
        }


        System.out.println(Arrays.toString(numeros));



        /*
        * length: Esta es una propiedad de solo lectura que te da la longitud del arreglo, es decir, el número de elementos que contiene.
java
Copy code
int[] numeros = {10, 20, 30, 40, 50};
int longitud = numeros.length; // Devuelve 5
clone(): Esta función crea y devuelve una copia superficial del arreglo.
java
Copy code
int[] numeros = {10, 20, 30, 40, 50};
int[] copiaNumeros = numeros.clone();
toString(): Esta función devuelve una representación de cadena del arreglo.
java
Copy code
int[] numeros = {10, 20, 30, 40, 50};
String cadenaNumeros = Arrays.toString(numeros); // Devuelve "[10, 20, 30, 40, 50]"
sort(): Esta función ordena los elementos del arreglo en orden ascendente.
java
Copy code
int[] numeros = {30, 10, 50, 20, 40};
Arrays.sort(numeros); // Ahora 'numeros' está ordenado: [10, 20, 30, 40, 50]
binarySearch(): Esta función busca un elemento específico en el arreglo. El arreglo debe estar ordenado previamente para que esta función funcione correctamente.
java
Copy code
int[] numeros = {10, 20, 30, 40, 50};
int indice = Arrays.binarySearch(numeros, 30); // Devuelve 2
fill(): Esta función llena el arreglo con un valor específico.
java
Copy code
int[] numeros = new int[5];
Arrays.fill(numeros, 100); // Llena 'numeros' con el valor 100 en todas las posiciones
copyOf(): Esta función crea una copia del arreglo con una longitud específica.
java
Copy code
int[] numeros = {10, 20, 30, 40, 50};
int[] copiaNumeros = Arrays.copyOf(numeros, 3); // Crea una copia con los primero tres numeros
        * */



    }
}