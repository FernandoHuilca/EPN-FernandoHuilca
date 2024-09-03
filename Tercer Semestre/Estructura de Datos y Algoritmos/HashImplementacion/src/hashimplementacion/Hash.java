package hashimplementacion;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Hash {

    private String[] arreglo;
    private int tamanio;

    public Hash(String a) {
        try {
            tamanio = Integer.parseInt(JOptionPane.showInputDialog("INGRESE EL NUMERO DE CLAVES QUE VAN A SER UBICADAS EN LA TABLA HASH"));
            this.arreglo = new String[tamanio];
            Arrays.fill(this.arreglo, "vacio");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "SOLO SE PUEDEN INGRESAR NUMEROS");
        }
    }

    public Hash(int tamanio) {
        this.tamanio = tamanio;
        this.arreglo = new String[tamanio];
        Arrays.fill(this.arreglo, "vacio");
    }

    public Hash() {
    }

    public String[] getVector() {
        return arreglo;
    }

    public void setVector(String[] vector) {
        this.arreglo = vector;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void ingresarClaves() {
        int i = 0;
        int opc;
        do {
            this.arreglo[i] = JOptionPane.showInputDialog("Ingrese una clave");
            opc = JOptionPane.showConfirmDialog(null, "Desea ingresar otra clave");
            i++;
        } while (opc == JOptionPane.YES_OPTION && i < this.arreglo.length);
        if (i >= this.arreglo.length) {
            JOptionPane.showMessageDialog(null, "No se puede ingresar más claves");
        }
    }

    /**
     * Método que implementa el hashing por el método del módulo
     * @param claves El objeto Hash que contiene las claves originales
     * @param nuevo El objeto Hash donde se almacenarán las claves hashed
     */
    public void hashModulo(Hash claves, Hash nuevo) {
        // Recorre todas las claves en el arreglo original
        for (int i = 0; i < claves.arreglo.length; i++) {
            String elemento = claves.arreglo[i];
            if (!elemento.equals("vacio")) {
                // Calcula el índice usando el método del módulo
                int indiceArreglo = Integer.parseInt(elemento) % claves.tamanio;
                // Maneja colisiones si el índice calculado ya está ocupado
                while (!nuevo.arreglo[indiceArreglo].equals("vacio")) {
                    JOptionPane.showMessageDialog(null, "Ocurrió una colisión en el índice " + indiceArreglo);
                    indiceArreglo = solucionarColision(indiceArreglo, nuevo, claves);
                }
                // Inserta el elemento en el índice calculado
                nuevo.arreglo[indiceArreglo] = elemento;
            }
        }
    }

    /**
     * Método que implementa el hashing por el método de los cuadrados
     * @param claves El objeto Hash que contiene las claves originales
     * @param nuevo El objeto Hash donde se almacenarán las claves hashed
     */
    public void hashCuadrado(Hash claves, Hash nuevo) {
        // Recorre todas las claves en el arreglo original
        for (int i = 0; i < claves.arreglo.length; i++) {
            String elemento = claves.arreglo[i];
            if (!elemento.equals("vacio")) {
                // Calcula el cuadrado del valor numérico de la clave
                String aux = String.valueOf((int) Math.pow(Integer.parseInt(elemento), 2));
                // Extrae la porción del medio del cuadrado
                int indiceArreglo = Integer.parseInt(aux.substring(aux.length() / 2 - 1, aux.length() / 2 + 1)) % claves.tamanio;
                // Maneja colisiones si el índice calculado ya está ocupado
                while (!nuevo.arreglo[indiceArreglo].equals("vacio")) {
                    JOptionPane.showMessageDialog(null, "Ocurrió una colisión en el índice " + indiceArreglo);
                    indiceArreglo = solucionarColision(indiceArreglo, nuevo, claves);
                }
                // Inserta el elemento en el índice calculado
                nuevo.arreglo[indiceArreglo] = elemento;
            }
        }
    }

    /**
     * Método que implementa el hashing por el método del plegamento
     * @param claves El objeto Hash que contiene las claves originales
     * @param nuevo El objeto Hash donde se almacenarán las claves hashed
     */
    public void hashPlegamento(Hash claves, Hash nuevo) {
        // Recorre todas las claves en el arreglo original
        for (int i = 0; i < claves.arreglo.length; i++) {
            String elemento = claves.arreglo[i];
            if (!elemento.equals("vacio")) {
                // Calcula el cuadrado del valor numérico de la clave
                String aux = String.valueOf((int) Math.pow(Integer.parseInt(elemento), 2));
                int sum = 0;
                // Suma los dígitos del cuadrado
                for (char c : aux.toCharArray()) {
                    sum += Character.getNumericValue(c);
                }
                // Calcula el índice usando la suma de los dígitos
                int indiceArreglo = sum % claves.tamanio;
                // Maneja colisiones si el índice calculado ya está ocupado
                while (!nuevo.arreglo[indiceArreglo].equals("vacio")) {
                    JOptionPane.showMessageDialog(null, "Ocurrió una colisión en el índice " + indiceArreglo);
                    indiceArreglo = solucionarColision(indiceArreglo, nuevo, claves);
                }
                // Inserta el elemento en el índice calculado
                nuevo.arreglo[indiceArreglo] = elemento;
            }
        }
    }

    /**
     * Método que implementa el hashing por el método del truncamiento
     * @param claves El objeto Hash que contiene las claves originales
     * @param nuevo El objeto Hash donde se almacenarán las claves hashed
     */
    public void hashTruncamiento(Hash claves, Hash nuevo) {
        // Recorre todas las claves en el arreglo original
        for (int i = 0; i < claves.arreglo.length; i++) {
            String elemento = claves.arreglo[i];
            if (!elemento.equals("vacio")) {
                // Elimina el primer y último carácter de la clave
                String aux = elemento.substring(1, elemento.length() - 1);
                // Calcula el índice usando el valor numérico del resultado truncado
                int indiceArreglo = Integer.parseInt(aux) % claves.tamanio;
                // Maneja colisiones si el índice calculado ya está ocupado
                while (!nuevo.arreglo[indiceArreglo].equals("vacio")) {
                    JOptionPane.showMessageDialog(null, "Ocurrió una colisión en el índice " + indiceArreglo);
                    indiceArreglo = solucionarColision(indiceArreglo, nuevo, claves);
                }
                // Inserta el elemento en el índice calculado
                nuevo.arreglo[indiceArreglo] = elemento;
            }
        }
    }

    /**
     * Método para solucionar colisiones en la tabla hash
     * @param anteriorIndice El índice anterior donde ocurrió la colisión
     * @param nuevo El objeto Hash donde se almacenarán las claves hashed
     * @param claves El objeto Hash que contiene las claves originales
     * @return El nuevo índice calculado para almacenar la clave
     */
    private int solucionarColision(int anteriorIndice, Hash nuevo, Hash claves) {
        int nuevoIndice = anteriorIndice;
        // Solicita al usuario seleccionar un método para solucionar la colisión
        int metodo = Integer.parseInt(JOptionPane.showInputDialog(
                "Seleccione método para solucionar la colisión\n 1. Prueba lineal\n 2. Prueba cuadrática\n 3. Doble hash\n 4. Arreglos anidados\n 5. Encadenamiento"));
        switch (metodo) {
            case 1:
                // Prueba lineal: busca el siguiente índice libre de forma lineal
                do {
                    nuevoIndice = (nuevoIndice + 1) % nuevo.tamanio;
                } while (!nuevo.arreglo[nuevoIndice].equals("vacio"));
                break;
            case 2:
                // Prueba cuadrática: busca el siguiente índice libre usando una secuencia cuadrática
                int i = 1;
                do {
                    nuevoIndice = (anteriorIndice + i * i) % nuevo.tamanio;
                    i++;
                } while (!nuevo.arreglo[nuevoIndice].equals("vacio"));
                break;
            case 3:
                // Doble hash: usa un segundo hash para encontrar el siguiente índice libre
                int hash2 = 7 - (anteriorIndice % 7);
                do {
                    nuevoIndice = (nuevoIndice + hash2) % nuevo.tamanio;
                } while (!nuevo.arreglo[nuevoIndice].equals("vacio"));
                break;
            case 4:
                // Arreglos anidados: crea una tabla de arreglos anidados para solucionar colisiones
                String[][] arregloAnidado = arreglosAnidados(claves);
                JOptionPane.showMessageDialog(null, salidaAnidados(arregloAnidado));
                System.exit(0);
                break;
            case 5:
                // Encadenamiento: crea una lista de encadenamiento para solucionar colisiones
                String[][] encadenamiento = encadenamiento(claves);
                JOptionPane.showMessageDialog(null, salidaEncadenamiento(encadenamiento));
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Método no válido");
                break;
        }
        return nuevoIndice;
    }

    /**
     * Método que implementa el manejo de colisiones mediante arreglos anidados
     * @param claves El objeto Hash que contiene las claves originales
     * @return Una matriz bidimensional representando las claves organizadas con arreglos anidados
     */
    public String[][] arreglosAnidados(Hash claves) {
        String[][] ma = new String[claves.tamanio][claves.tamanio];
        for (int i = 0; i < claves.tamanio; i++) {
            for (int j = 0; j < claves.tamanio; j++) {
                ma[i][j] = "vacio";
            }
        }
        for (int i = 0; i < claves.arreglo.length; i++) {
            String elemento = claves.arreglo[i];
            if (!elemento.equals("vacio")) {
                int indiceArreglo = Integer.parseInt(elemento) % claves.tamanio;
                for (int j = 0; j < claves.tamanio; j++) {
                    if (ma[indiceArreglo][j].equals("vacio")) {
                        ma[indiceArreglo][j] = elemento;
                        break;
                    }
                }
            }
        }
        return ma;
    }

    /**
     * Método que implementa el manejo de colisiones mediante encadenamiento
     * @param claves El objeto Hash que contiene las claves originales
     * @return Una matriz bidimensional representando las claves organizadas con encadenamiento
     */
    public String[][] encadenamiento(Hash claves) {
        String[][] ma = new String[claves.tamanio][claves.tamanio];
        for (int i = 0; i < claves.tamanio; i++) {
            for (int j = 0; j < claves.tamanio; j++) {
                ma[i][j] = "vacio";
            }
        }
        for (int i = 0; i < claves.arreglo.length; i++) {
            String elemento = claves.arreglo[i];
            if (!elemento.equals("vacio")) {
                int indiceArreglo = Integer.parseInt(elemento) % claves.tamanio;
                for (int j = 0; j < claves.tamanio; j++) {
                    if (ma[indiceArreglo][j].equals("vacio")) {
                        ma[indiceArreglo][j] = elemento;
                        break;
                    }
                }
            }
        }
        return ma;
    }

    /**
     * Método para mostrar la tabla hash generada
     * @param nuevo El objeto Hash donde se almacenarán las claves hashed
     * @return Una cadena con la representación de la tabla hash
     */
    public String salida(Hash nuevo) {
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < nuevo.arreglo.length; i++) {
            salida.append("Posicion: ").append(i).append(" Clave: ").append(nuevo.arreglo[i]).append("\n");
        }
        return salida.toString();
    }

    /**
     * Método para mostrar la tabla hash generada con arreglos anidados
     * @param nuevo La matriz bidimensional con las claves organizadas
     * @return Una cadena con la representación de la tabla hash con arreglos anidados
     */
    public String salidaAnidados(String[][] nuevo) {
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < nuevo.length; i++) {
            salida.append("Posicion: ").append(i).append("\n");
            for (int j = 0; j < nuevo.length; j++) {
                salida.append(" ").append(nuevo[i][j]).append("\n");
            }
        }
        return salida.toString();
    }

    /**
     * Método para mostrar la tabla hash generada con encadenamiento
     * @param nuevo La matriz bidimensional con las claves organizadas
     * @return Una cadena con la representación de la tabla hash con encadenamiento
     */
    public String salidaEncadenamiento(String[][] nuevo) {
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < nuevo.length; i++) {
            salida.append("Posicion: ").append(i).append("\n");
            for (int j = 0; j < nuevo.length; j++) {
                salida.append(" ").append(nuevo[i][j]).append("\n");
            }
        }
        return salida.toString();
    }
}
