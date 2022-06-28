import java.util.*;

public class customStack {
    Queue<Integer> q;

    public customStack() {
        q = new LinkedList<Integer>();
    }

    // Function to get size of the stack
    public int getSize() {
        // return the queue size
        return q.size();
    }

    // Function to check whether stack is empty or not
    public boolean isEmpty() {
        // If queue is empty return true
        if (q.isEmpty()) {
            return true;
        }

        // Else return false
        return false;
    }

    // Function to push an element on top of stack
    public void push(int element) {
        // Add the element in the queue
        q.add(element);
        // Now since the element is added at end of queue, we need it to bring it to
        // front
        // So we pop an element from the queue and push it back in again until we get
        // our desired element to front
        for (int i = 0; i < q.size() - 1; i++) {
            int temp = q.poll();
            q.add(temp);
        }
    }

    // Function to pop an element from the stack
    public int pop() {
        // If Stack is empty return -1
        if (q.isEmpty()) {
            return -1;
        }
        // Else pop the element from top and return it
        return q.poll();
    }

    // Function to get the top element from the stack
    public int top() {
        // if stack is empty return -1
        if (q.isEmpty()) {
            return -1;
        }

        // else return the element on top
        return q.peek();
    }
}
