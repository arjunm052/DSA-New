import java.util.*;

public class stackSort {

    // Function to sort a stack recursively
    // TC - O(N^2) SC - O(N)
    public static void sortStack(Stack<Integer> stack) {
        // If the size of the stack is one, then the stack will be already sorted so we
        // just return
        if (stack.size() == 1) {
            return;
        }

        // Else pop an element from the stack
        int pop = stack.pop();
        // Sort the rest of the stack
        sortStack(stack);
        // Then insert this popped element in its correct position
        insertSorted(stack, pop);
    }

    // Function to insert an element at its correct position in a sorted stack
    public static void insertSorted(Stack<Integer> stack, int val) {
        // If stack is empty or the element on top of stack is smaller than our val,
        // then we just push our val on top of stack and return
        if (stack.isEmpty() || stack.peek() < val) {
            stack.push(val);
            return;
        }

        // Else pop a value from stack
        int temp = stack.pop();
        // Recursively call insertSorted function again with our val
        insertSorted(stack, val);
        // And then push back the popped element on top of stack
        stack.push(temp);
    }

}