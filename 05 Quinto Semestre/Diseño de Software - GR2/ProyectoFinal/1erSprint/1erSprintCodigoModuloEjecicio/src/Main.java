//Author: Fernando Huilca

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Entidades necesarias_______________________________________________
        Ejercicio ejercicio = new Ejercicio();
        Leccion leccion = new Leccion();
        int contador = 0 ;
        Scanner entrada = new Scanner(System.in);
        String enunciado = "Una clase bien escrita es:";
        PreguntaOpcionMultiple preguntaOpcionMultiple = new PreguntaOpcionMultiple(enunciado);
        preguntaOpcionMultiple.agergarOpcion(new Opcion("persona"));
        preguntaOpcionMultiple.agergarOpcion(new Opcion("Cuadrado"));
        //___________________________________________________________________
        leccion.agregarEjercicio(ejercicio);
        ejercicio.agregarPregunta(preguntaOpcionMultiple);
        //___________________________________________________________________



        while (true){
            System.out.println("Escoja un ejercicio de la leccion \nOpciones_____");
            for (int i = 0 ; i < leccion.getListEjercicios().size(); i++) {
                System.out.println("Ejercicio : " + i);
            }
            System.out.print("Opcion: ");
            int opcion = entrada.nextInt();
            Ejercicio ejercicioOpcion = leccion.getEjercicio(opcion);
            ejercicioOpcion.setEstado(ESTADO.ACTIVO);
            for (int i = 0 ; i < ejercicioOpcion.getNumPreguntas(); i++){
                System.out.println("Pregunta : " + i);
                Pregunta pregunta = ejercicioOpcion.getPregunta(i);
                System.out.println("La instruccion es: " + pregunta.getInstruccion());
                System.out.println("El enunciado es: " + pregunta.getEnunciado());
                System.out.println("Selecciones la correcta:");
                for (int j = 0 ; j < pregunta.getNumOpciones(); j++){
                    System.out.println("n" + j + " " + pregunta.getOpcion(j));
                }
                int opcion2 = entrada.nextInt();
            }

        }

    }
}