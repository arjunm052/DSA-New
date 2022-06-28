import java.util.*;

public class program {
    public static void main(String[] args) {

    }
}

// queue class implements the queue using array
class queue {
    int start;
    int end;
    int[] arr;
    int maxSize;
    int currSize;

    // Constructor to initialize all the attributes of the queue object
    // Initial capcity is passed as a parameter
    public queue(int capacity) {
        this.start = -1;
        this.end = -1;
        this.maxSize = capacity;
        this.currSize = 0;
        arr = new int[maxSize];
    }

    // Function to push an element in the queue
    public void push(int x) {
        // If the queue is full, print out a message and exit
        if (currSize == maxSize) {
            System.out.println("Queue is full");
            System.exit(1);
        }

        // If start == -1 or end == -1 then our queue is empty, then initialize our
        // start and end variables to 0
        if (start == -1 && end == -1) {
            start = 0;
            end = 0;
        }
        // otherwise just increment the end pointer
        else {
            end = (end + 1) % maxSize;
        }

        // Store the element at the end index
        arr[end] = x;
        // Increase the size of the queue
        currSize++;
    }

    public int pop() {
        // if queue has no element, print the message and exit
        if (currSize == 0) {
            System.out.println("Queue is empty");
            System.exit(1);
        }

        // Otherwise get the element at the start index of the queue
        int res = arr[start];

        // If size of queue is only 1, then after popping our queue becomes empty, so
        // set start and end pointers to -1 again
        if (currSize == 1) {
            start = -1;
            end = -1;
        }
        // else update our start pointer
        else {
            start = (start + 1) % maxSize;
        }

        // Decrease the size of the queue
        currSize--;

        // return the res
        return res;
    }

    // Function to get the element in front of the queue
    public int top() {
        // If queue is empty then return -1
        if (currSize == 0) {
            return -1;
        }

        // Else return the element in present at the start index
        return arr[start];
    }

    // Function to get size of the queue
    public int size() {
        // just return the currSize value
        return currSize;
    }
}
