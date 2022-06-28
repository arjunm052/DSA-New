import java.util.*;

class minStack {
    int minEle = 0;
    Stack<Integer> stack = new Stack<Integer>();

    /* returns min element from stack */
    int getMin() {
        // If stack is empty just return -1
        if (stack.isEmpty()) {
            return -1;
        }

        // Else return the current minEle
        return minEle;
    }

    /* returns poped element from stack */
    int pop() {
        // Declare res to store the element to be returned
        int res = 0;

        // If stack is empty return -1
        if (stack.isEmpty()) {
            return -1;
        }

        // If popped element is larger or equal to minEle then return the popped element
        // as it is
        else if (stack.peek() >= minEle) {
            return stack.pop();
        }
        // If popped element is smaller than minEle
        else {
            // The minEle will be returned
            res = minEle;
            // Update the new minEle as 2*minEle - poppedElement
            minEle = 2 * minEle - stack.pop();
        }

        // return the res
        return res;
    }

    /* push element x into the stack */
    void push(int x) {
        // If stack is empty push the element in the stack and set it as minEle
        if (stack.isEmpty()) {
            minEle = x;
            stack.push(x);
            return;
        }

        // If element to be inserted is greater than minELe just push it as it is
        if (x >= minEle) {
            stack.push(x);
            return;
        }

        // Else if element is less than curr minEle, we push 2*currElement - minElement
        // and set the minEle as new element
        else {
            stack.push(2 * x - minEle);
            minEle = x;
        }
    }
}