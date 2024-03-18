import java.util.EmptyStackException;

//Unit Testing
public class ResizableArrayStackTest {
    public static void main(String[] args) {
        testPushAndPeek();
        testPushAndPop();
        testIsEmpty();
        testClear();
        testPeekEmptyStack();
        testPopEmptyStack();
    }

    private static void testPushAndPeek() {
        ResizableArrayStack<Integer> stack = new ResizableArrayStack<>();
        stack.push(5);
        int peekResult = stack.peek();
        if (peekResult == 5) {
            System.out.println("testPushAndPeek PASSED");
        } else {
            System.out.println("testPushAndPeek FAILED");
        }
    }

    private static void testPushAndPop() {
        ResizableArrayStack<String> stack = new ResizableArrayStack<>();
        stack.push("Hello");
        stack.push("World");
        String popResult1 = stack.pop();
        String popResult2 = stack.pop();
        if (popResult1.equals("World") && popResult2.equals("Hello")) {
            System.out.println("testPushAndPop PASSED");
        } else {
            System.out.println("testPushAndPop FAILED");
        }
    }

    private static void testIsEmpty() {
        ResizableArrayStack<Double> stack = new ResizableArrayStack<>();
        boolean isEmptyResult = stack.isEmpty();
        if (isEmptyResult) {
            System.out.println("testIsEmpty PASSED");
        } else {
            System.out.println("testIsEmpty FAILED");
        }
    }

    private static void testClear() {
        ResizableArrayStack<Character> stack = new ResizableArrayStack<>();
        stack.push('a');
        stack.push('b');
        stack.clear();
        boolean isEmptyResult = stack.isEmpty();
        if (isEmptyResult) {
            System.out.println("testClear PASSED");
        } else {
            System.out.println("testClear FAILED");
        }
    }

    private static void testPeekEmptyStack() {
        ResizableArrayStack<Integer> stack = new ResizableArrayStack<>();
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
        ResizableArrayStack<String> stack = new ResizableArrayStack<>();
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
