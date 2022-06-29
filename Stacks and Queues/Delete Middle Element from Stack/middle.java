import java.util.*;

public class middle {
    // Size of stack is N+1
    public static void deleteMiddle(Stack<Integer> inputStack, int N) {
        // If stack has odd no. of element we delete the N+1/2 element
        if (N % 2 == 0) {
            deleteElement(inputStack, ((N + 1) / 2) + 1);
        }
        // Else we delete the N+1/2 - 1 th element
        else {
            deleteElement(inputStack, ((N + 1) / 2));
        }
    }

    public static void deleteElement(Stack<Integer> stack, int middle) {
        // If we are just above the middle element then pop that element and return
        if (stack.size() == middle) {
            stack.pop();
            return;
        }

        // else take out the current element
        int temp = stack.pop();
        // recursively delete the middle element
        deleteElement(stack, middle);
        // push back the popped element
        stack.push(temp);
    }
}