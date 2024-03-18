public class CalculatorTest {
    public static void main(String[] args) {
        String postfix = Calculator.convertToPostfix("a*b/(c-a)+d*e");
        System.out.println("Infix Expression: " + "a*b/(c-a)+d*e");
        System.out.println("Postfix Expression: " + postfix);
        System.out.println();

        String postfixExpression = "23*42-/56*+";
        System.out.println("Postfix Expression: " + postfixExpression);
        double temp = Calculator.evaluatePostfix(postfixExpression);
        System.out.println("Result: " + temp);
        System.out.println();

        double res = Calculator.calculateExpression("2*3/(4-2)+5*6");
        System.out.println("Expression: 2*3/(4-2)+5*6");
        System.out.println("Solved expression: " + res);
    }
}
