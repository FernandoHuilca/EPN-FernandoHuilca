import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m"; // Código para resetear el color al original

        // Verificación de calificaciones
        System.out.println(ANSI_RED + " _______ CALIFICACIONES ERRONEAS Y SUS POSICIONES EN EL EXCEL: _______ " + ANSI_RESET);
        int erroresCalificaciones = verificarColumnaCalificaciones("src/calificacion.txt");
        System.out.println("!!!!!!! RESULTADO FINAL: Cantidad de errores en calificaciones: " + erroresCalificaciones);

        // Verificación de cédulas
        System.out.println(ANSI_RED + " _______ CEDULAS ERRONEAS Y SUS POSICIONES EN EL EXCEL: _______ " + ANSI_RESET);
        int erroresCedulas = verificarCedulaDeIdentidad("src/cedula.txt");
        System.out.println("!!!!!!! RESULTADO FINAL: Cantidad de errores en cédulas: " + erroresCedulas);

        // Verificación de teléfonos
        System.out.println(ANSI_RED + " _______ TELEFONOS ERRONEOS Y SUS POSICIONES EN EL EXCEL: _______ " + ANSI_RESET);
        int erroresTelefonos = verificarTelefonos("src/telefono.txt");
        System.out.println("!!!!!!! RESULTADO FINAL: Cantidad de errores en teléfonos: " + erroresTelefonos);

        // Verificación de fechas y edades
        System.out.println(ANSI_RED + " _______ FECHAS Y EDADES ERRONEAS: _______ " + ANSI_RESET);
        int erroresFechasEdades = verificarFechasYEdades("src/fechaNacimiento.txt", "src/edad.txt");
        System.out.println("!!!!!!! RESULTADO FINAL: Cantidad de errores en fechas y edades: " + erroresFechasEdades);

        // Verificación de nombres vacíos
        System.out.println(ANSI_RED + " _______ NOMBRES VACIOS Y SUS POSICIONES: _______ " + ANSI_RESET);
        int erroresNombres = verificarCamposVacios("src/Nombres.txt");
        System.out.println("!!!!!!! RESULTADO FINAL: Cantidad de errores en nombres vacíos: " + erroresNombres);

        // Verificación de apellidos vacíos
        System.out.println(ANSI_RED + " _______ APELLIDOS VACIOS Y SUS POSICIONES: _______ " + ANSI_RESET);
        int erroresApellidos = verificarCamposVacios("src/Apellidos.txt");
        System.out.println("!!!!!!! RESULTADO FINAL: Cantidad de errores en apellidos vacíos: " + erroresApellidos);

        // Verificación de correos electrónicos
        System.out.println(ANSI_RED + " _______ CORREOS INVALIDOS Y SUS POSICIONES: _______ " + ANSI_RESET);
        int erroresCorreos = verificarCorreos("src/Correos.txt");
        System.out.println("!!!!!!! RESULTADO FINAL: Cantidad de errores en correos: " + erroresCorreos);
    }

    private static int verificarCamposVacios(String archivo) {
        int contador = 1;
        int contadorDeErrores = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    System.out.println("Error: Campo vacío en la posición: " + contador);
                    contadorDeErrores++;
                }
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contadorDeErrores;
    }

    private static int verificarCorreos(String archivo) {
        int contador = 1;
        int contadorDeErrores = 0;
        String regexCorreo = "^[a-zA-Z]+\\.[a-zA-Z]+@universidad\\.edu\\.ec$"; // Formato: nombre.apellido@universidad.edu.ec

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (!linea.trim().matches(regexCorreo)) {
                    System.out.println("Error: Formato de correo incorrecto -> " + linea.trim() + " posición: " + contador);
                    contadorDeErrores++;
                }
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contadorDeErrores;
    }

    private static int verificarCedulaDeIdentidad(String archivo) {
        int contador = 1;
        int contadorDeErrores = 0;
        Set<String> cedulasRegistradas = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                contadorDeErrores += verificarCedula(linea.trim(), contador, cedulasRegistradas);
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contadorDeErrores;
    }

    private static int verificarCedula(String cedula, int posicion, Set<String> cedulasRegistradas) {
        int errores = 0;

        // 1) Verificar campos nulos
        if (cedula.isEmpty()) {
            System.out.println("Error: Campo de cédula vacío en la posición " + posicion);
            return 1;
        }

        // 2) Verificar duplicados
        if (!cedulasRegistradas.add(cedula)) {
            System.out.println("Error: Cédula duplicada -> " + cedula + " en la posición " + posicion);
            return 1;
        }

        // 3) Verificar longitud de la cédula
        if (cedula.length() == 9) {
            System.out.println("Error: Cédula incompleta (9 dígitos) -> " + cedula + " en la posición " + posicion);
            return 1;
        } else if (cedula.length() < 9) {
            System.out.println("Error: Cédula demasiado corta (menos de 9 dígitos) -> " + cedula + " en la posición " + posicion);
            return 1;
        } else if (cedula.length() > 10) {
            System.out.println("Error: Cédula demasiado larga (más de 10 dígitos) -> " + cedula + " en la posición " + posicion);
            return 1;
        }

        try {
            // Convertir a entero para verificar partes específicas de la cédula
            int provincia = Integer.parseInt(cedula.substring(0, 2));
            int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
            String consecutivos = cedula.substring(3, 9);
            int digitoVerificador = Integer.parseInt(cedula.substring(9));

            // 4) Validación de provincia
            if (provincia < 0 || provincia > 24) {
                System.out.println("Error: Provincia inválida en la cédula -> " + cedula + " en la posición " + posicion);
                errores++;
            }

            // Validación del tercer dígito
            if (tercerDigito < 0 || tercerDigito >= 6) {
                System.out.println("Error: Tercer dígito inválido en la cédula -> " + cedula + " en la posición " + posicion);
                errores++;
            }

            // Validación de los dígitos consecutivos
            if (!consecutivos.matches("\\d{6}")) {
                System.out.println("Error: Los dígitos consecutivos son inválidos en la cédula -> " + cedula + " en la posición " + posicion);
                errores++;
            }

            // Validación del dígito verificador usando el Módulo 10
            if (!verificarDigitoVerificador(cedula)) {
                System.out.println("Error: Dígito verificador incorrecto en la cédula -> " + cedula + " en la posición " + posicion);
                errores++;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: No es un número válido en la cédula -> " + cedula + " en la posición " + posicion);
            errores++;
        }

        return errores; // Retorna el número de errores encontrados
    }

    // Método para verificar el dígito verificador usando el Módulo 10
    private static boolean verificarDigitoVerificador(String cedula) {
        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int suma = 0;

        for (int i = 0; i < coeficientes.length; i++) {
            int valor = Character.getNumericValue(cedula.charAt(i)) * coeficientes[i];
            suma += (valor > 9) ? valor - 9 : valor; // Restar 9 si el resultado es mayor que 9
        }

        int digitoVerificador = Character.getNumericValue(cedula.charAt(9));
        int moduloDiez = 10 - (suma % 10);

        return (moduloDiez == 10 ? 0 : moduloDiez) == digitoVerificador;
    }
    private static int verificarColumnaCalificaciones(String archivo) {
        int contador = 1;
        int contadorDeErrores = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                contadorDeErrores += verificarCalificacion(linea.trim(), contador);
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contadorDeErrores;
    }

    private static int verificarCalificacion(String calificacion, int posicion) {
        int errores = 0;

        try {
            double nota = Double.parseDouble(calificacion);
            if (nota < 0 || nota > 20) {
                System.out.println("Calificación inválida (fuera de rango): " + calificacion + " en la posición " + posicion);
                errores++;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: No hay una calificación asignada -> " + calificacion + " posición: " + posicion);
            errores++;
        }

        return errores; // Retorna el número de errores encontrados
    }

    private static int verificarTelefonos(String archivo) {
        int contador = 1;
        int contadorDeErrores = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                contadorDeErrores += verificarTelefono(linea.trim(), contador);
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contadorDeErrores;
    }

    private static int verificarTelefono(String telefono, int posicion) {
        int errores = 0;

        // Verificar si el campo está vacío o nulo
        if (telefono.isEmpty()) {
            System.out.println("Error: Campo de teléfono vacío en la posición " + posicion);
            return 1;
        }

        // Verificar si el teléfono tiene 7 dígitos
        if (telefono.length() != 7) {
            System.out.println("Error: Teléfono inválido (debe tener 7 dígitos) -> " + telefono + " posición: " + posicion);
            errores++;
        } else if (!telefono.matches("\\d{7}")) {  // Verificar si el teléfono solo contiene dígitos
            System.out.println("Error: Teléfono inválido (solo debe contener dígitos) -> " + telefono + " posición: " + posicion);
            errores++;
        }

        return errores; // Retorna el número de errores encontrados
    }


    private static int verificarFechasYEdades(String archivoFechas, String archivoEdades) {
        int contadorErrores = 0;

        try (BufferedReader brFechas = new BufferedReader(new FileReader(archivoFechas));
             BufferedReader brEdades = new BufferedReader(new FileReader(archivoEdades))) {

            String fechaLinea;
            String edadLinea;
            int posicion = 1;

            while ((fechaLinea = brFechas.readLine()) != null && (edadLinea = brEdades.readLine()) != null) {
                contadorErrores += verificarFechaYEdad(fechaLinea.trim(), edadLinea.trim(), posicion);
                posicion++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer los archivos: " + e.getMessage());
        }

        return contadorErrores;
    }

    private static int verificarFechaYEdad(String fecha, String edadStr, int posicion) {
        int errores = 0;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate fechaLimite = LocalDate.of(2020, 1, 1); // Fecha hasta donde se verifica la edad

        // Verificación de campos nulos o vacíos
        if (fecha.isEmpty()) {
            System.out.println("Error: Campo de fecha vacío en la posición " + posicion);
            errores++;
            return errores;
        }
        if (edadStr.isEmpty()) {
            System.out.println("Error: Campo de edad vacío en la posición " + posicion);
            errores++;
            return errores;
        }

        try {
            LocalDate fechaNacimiento = LocalDate.parse(fecha, formatoFecha);
            int edadCalculada = (int) ChronoUnit.YEARS.between(fechaNacimiento, fechaLimite);

            int edadProporcionada = Integer.parseInt(edadStr);
            if (edadCalculada != edadProporcionada) {
                System.out.println("Error: Edad incorrecta para la fecha " + fecha + " (calculada: " + edadCalculada + ", proporcionada: " + edadProporcionada + ") en la posición: " + posicion);
                errores++;
            } else {
                // System.out.println("Fecha y edad válidas en posición: " + posicion);
            }
        } catch (Exception e) {
            System.out.println("Error: Formato de fecha o edad inválido en posición: " + posicion);
            errores++;
        }

        return errores;
    }
}

