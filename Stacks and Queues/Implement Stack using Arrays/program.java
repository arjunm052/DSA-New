public class program {
    public static void main(String[] args) {

    }

}

// Stack class that implements stack using array
class Stack {
    int[] stack;
    int maxSize;
    int currSize;
    int top;

    // Constructor to initialize the stack object
    public Stack(int capacity) {
        this.maxSize = capacity;
        this.currSize = 0;
        this.stack = new int[capacity];
        this.top = -1;
    }

    // Function to push an element on top of stack
    public void push(int x) {
        // If the stack is full, element can't be inserted into the stack
        if (currSize == maxSize) {
            System.out.println("Stack is full");
            return;
        }
        // Else increment thetop pointer
        top++;
        // and insert the element at that index
        stack[top] = x;
    }

    // Function to pop an element from the stack
    public int pop() {
        // If stack is empty return -1
        if (currSize == 0) {
            return -1;
        }

        // Else get the element that is present at top index and decerement top pointer
        int res = stack[top];
        top--;

        // return the element popped
        return res;
    }

    // Function to return the element present at top of stack
    public int top() {
        // if stack is empty return -1
        if (currSize == 0) {
            return -1;
        }

        // Else return the element present on top
        return stack[top];
    }

    // Function to get size of the stack
    public int getSize() {
        // return the value of currSize
        return currSize;
    }
}