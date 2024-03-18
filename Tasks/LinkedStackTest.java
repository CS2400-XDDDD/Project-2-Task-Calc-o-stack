import java.util.EmptyStackException;

//Unit testing
public class LinkedStackTest {
    public static void main(String[] args) {
        testPushAndPeek();
        testPushAndPop();
        testIsEmpty();
        testClear();
        testPeekEmptyStack();
        testPopEmptyStack();
    }

    private static void testPushAndPeek() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(5);
        if (stack.peek() == 5) {
            System.out.println("testPushAndPeek PASSED");
        } else {
            System.out.println("testPushAndPeek FAILED");
        }
    }

    private static void testPushAndPop() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("Hello");
        stack.push("World");
        if (stack.pop().equals("World") && stack.pop().equals("Hello")) {
            System.out.println("testPushAndPop PASSED");
        } else {
            System.out.println("testPushAndPop FAILED");
        }
    }

    private static void testIsEmpty() {
        LinkedStack<Double> stack = new LinkedStack<>();
        if (stack.isEmpty()) {
            System.out.println("testIsEmpty PASSED");
        } else {
            System.out.println("testIsEmpty FAILED");
        }
    }

    private static void testClear() {
        LinkedStack<Character> stack = new LinkedStack<>();
        stack.push('a');
        stack.push('b');
        stack.clear();
        if (stack.isEmpty()) {
            System.out.println("testClear PASSED");
        } else {
            System.out.println("testClear FAILED");
        }
    }

    private static void testPeekEmptyStack() {
        LinkedStack<Integer> stack = new LinkedStack<>();
        boolean exceptionThrown = false;
        try {
            stack.peek();
        } catch (EmptyStackException e) {
            exceptionThrown = true;
        }
        if (exceptionThrown) {
            System.out.println("testPeekEmptyStack PASSED");
        } else {
            System.out.println("testPeekEmptyStack FAILED");
        }
    }

    private static void testPopEmptyStack() {
        LinkedStack<String> stack = new LinkedStack<>();
        boolean exceptionThrown = false;
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            exceptionThrown = true;
        }
        if (exceptionThrown) {
            System.out.println("testPopEmptyStack PASSED");
        } else {
            System.out.println("testPopEmptyStack FAILED");
        }
    }
}
