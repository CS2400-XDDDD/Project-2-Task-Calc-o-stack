import java.util.HashMap;

public class Calculator<T>
{
    public static String convertToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        LinkedStack<Character> stack = new LinkedStack<>();
        HashMap<Character, Integer> precedenceMap = new HashMap<>();
        precedenceMap.put('+', 1);
        precedenceMap.put('-', 1);
        precedenceMap.put('*', 2);
        precedenceMap.put('/', 2);
        precedenceMap.put('^', 3); // Add precedence for exponentiation
    
        for (char c : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Pop '('
            } else {
                while (!stack.isEmpty() && precedenceMap.getOrDefault(c, 0) <= precedenceMap.getOrDefault(stack.peek(), 0)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
    
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
    
        return postfix.toString();
    }    
    
    public static double evaluatePostfix(String postfix) {
        ResizableArrayStack<Double> valueStack = new ResizableArrayStack<>();
        
        for (char nextCharacter : postfix.toCharArray()) {
            if (Character.isDigit(nextCharacter)) {
                valueStack.push((double)(nextCharacter - '0')); // Convert char to double and push to stack
            } 
            else if (isOperator(nextCharacter)) {
                double operandTwo = valueStack.pop();
                double operandOne = valueStack.pop();
                double result = performOperation(operandOne, operandTwo, nextCharacter);
                valueStack.push(result);
            }
        }
        return valueStack.peek();
    }
    
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
    
    private static double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) throw new ArithmeticException("Division by zero!");
                return operand1 / operand2;
            case '^':
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static double calculateExpression(String expression){
        String postfix = convertToPostfix(expression);
        return evaluatePostfix(postfix);
    }
}
