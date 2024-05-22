import java.util.Scanner;
import java.util.Stack;

public class Main {

    // Función para verificar si un carácter es un operador
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Función para obtener la precedencia de un operador
    static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        else if (c == '*' || c == '/') return 2;
        return 0;
    }

    // Función para convertir expresión infija a expresión prefija
    static String infixToPrefix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                result.insert(0, c);
            } else if (c == '(') {
                char next = stack.pop();
                while (next != ')') {
                    result.insert(0, next);
                    next = stack.pop();
                }
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(c)) {
                    result.insert(0, stack.pop());
                }
                stack.push(c);
            } else if (c == ')') {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    // Función para evaluar una expresión prefija
    static double evaluatePrefix(String expression) {
        Stack<Double> operands = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                operands.push((double) (c - '0'));
            } else if (isOperator(c)) {
                double op1 = operands.pop();
                double op2 = operands.pop();
                switch (c) {
                    case '+':
                        operands.push(op1 + op2);
                        break;
                    case '-':
                        operands.push(op1 - op2);
                        break;
                    case '*':
                        operands.push(op1 * op2);
                        break;
                    case '/':
                        operands.push(op1 / op2);
                        break;
                }
            }
        }

        return operands.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la expresión infija:");
        String infixExpression = scanner.nextLine();

        // Convertir la expresión infija a prefija
        String prefixExpression = infixToPrefix(infixExpression);

        // Calcular el resultado de la expresión prefija
        double result = evaluatePrefix(prefixExpression);

        // Mostrar la expresión prefija y el resultado
        System.out.println("\nExpresión prefija: " + prefixExpression);
        System.out.println("Resultado: " + result);
    }
}
