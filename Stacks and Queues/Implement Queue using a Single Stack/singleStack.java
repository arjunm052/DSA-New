import java.util.*;

public class singleStack {
    // Declare the stack to be used
    // Top of the stack will be front of the queue and bototm of the stack will be
    // end of queue, we use the function call stack in this approach
    Stack<Integer> stack;

    // Constructor to initialize the stack
    singleStack() {
        stack = new Stack<Integer>();
    }

    // Function to insert an element in the queue
    void enQueue(int val) {
        // If stack is empty we push the element in the stack and return;
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }

        // Otherwise get the element on top
        int temp = stack.pop();
        // call the enqueue method with the value that we need to add
        enQueue(val);
        // and again push back the temp value that we popped earlier
        stack.push(temp);

        return;
    }

    // Function to poll an element from the queue
    int deQueue() {
        // If queue is empty return -1;
        if (stack.isEmpty()) {
            return -1;
        }
        // Otherwise return the element on top of the stack
        return stack.pop();
    }

    // Function to get the element present in front of the queue
    int peek() {
        // if stack is empty return -1
        if (stack.isEmpty()) {
            return -1;
        }
        // otherwise return the element on the top
        return stack.peek();
    }

    // Function to check whether the queue is empty
    boolean isEmpty() {
        // If stack is empty return true
        if (stack.isEmpty()) {
            return true;
        }

        // else return false
        return false;
    }
}