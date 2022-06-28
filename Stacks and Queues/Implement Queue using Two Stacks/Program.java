import java.util.*;

class Program {
    // Declare two stacks. s1 will be our queue and we will s2 as a temp stack.
    // Front of the queue will be top of stack s1
    Stack<Integer> s1;
    Stack<Integer> s2;

    // Constructor to initialize the stacks
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    // Function to Push an Element in the Queue
    // This will be O(N) operation
    public void push(int x) {
        // If the s1 stack is empty then our queue is empty, push the element directly
        // in the stack and return
        if (s1.isEmpty()) {
            s1.push(x);
            return;
        }

        // Otherwise Transfer all the elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Add the element to S1
        s1.push(x);

        // Transfer all the element back from s2 to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Function to pop an element from the queue
    public int pop() {
        // If queue is empty return -1;
        if (s1.isEmpty()) {
            return -1;
        }

        // Otherwise return the element on top of s1
        return s1.pop();
    }

    // Function to peek at element in front of the queue
    public int peek() {
        // If queue is empty return -1;
        if (s1.isEmpty()) {
            return -1;
        }

        // Else return the element present on top of s1
        return s1.peek();
    }

    // Function to check whether the queue is empty
    public boolean empty() {
        // If queue is empty return true
        if (s1.isEmpty()) {
            return true;
        }

        // Else return false
        return false;
    }
}
