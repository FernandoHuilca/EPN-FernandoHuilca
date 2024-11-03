public class FormatoFilas {

    public static void main(String[] args) {
        String numeros = "2,6,7,10,11,13,17,20,24,26,31,32,37,41,44,51,59,61,72,73,77,80,87,95,98,102,110,124,125,128,134,139,141,150,151,152,153,157,158,159,161,164,165,166,177,178,186,209,213,220,223,224,230,242,245,246,261,270,275,278,279,280,281,286,287,298,302,304,306,326,330,332,335,338,346,350,372,378,386,388,408,410,411,412,413,424,433,434,435,446,450,454,455,461,463,468,469,470,473,477,481,482,483,490,503,509,512,516,520,533,538,548,555,556,564,570,573,574,578,601,617,618,626,646,650,654,667";
        // Ejemplo: sumar 1 a cada número
        imprimirFormatoFilas(numeros, 1);
    }

    public static void imprimirFormatoFilas(String numeros, int suma) {
        // Divide el String en números individuales
        String[] listaNumeros = numeros.split(",");

        // Construye el formato deseado
        StringBuilder resultado = new StringBuilder();
        for (String numeroStr : listaNumeros) {
            int numero = Integer.parseInt(numeroStr.trim());
            // Suma el valor que se pasa y agrega al resultado
            int resultadoSuma = numero + suma;
            resultado.append("FILA()=").append(resultadoSuma);
            resultado.append(", ");
        }

        // Eliminar la última coma y espacio
        if (resultado.length() > 0) {
            resultado.setLength(resultado.length() - 2); // Eliminar ", "
        }

        // Imprime el resultado
        System.out.println(resultado.toString());
    }
}
