import java.io.*;


public class Main {
    public static void main(String[] args) {
        // Nombre del archivo
        String nombreArchivo = "Nombres.txt";
        // Contenido que se va a escribir en el archivo
        String contenido = "Hola, este es el contenido del archivo.";

        // Usamos try-with-resources para asegurar que los recursos se cierren automáticamente
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribimos el contenido en el archivo
            writer.write(contenido);
            // Podemos añadir más líneas utilizando writer.newLine() para cambiar de línea
            writer.newLine();
            writer.write("Esta es una nueva línea en el archivo.");
            System.out.println("Escritura en el archivo completada.");
        } catch (IOException e) {
            // Manejamos cualquier excepción que pueda ocurrir durante la escritura del archivo
            System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }


        // Usamos try-with-resources para asegurar que los recursos se cierren automáticamente
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            // Leemos línea por línea hasta que no haya más líneas (readLine() retorna null)
            while ((linea = reader.readLine()) != null) {
                // Imprimimos cada línea leída en la consola
                System.out.println(linea);
            }
            System.out.println("Lectura del archivo completada.");
        } catch (IOException e) {
            // Manejamos cualquier excepción que pueda ocurrir durante la lectura del archivo
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }


    }
}