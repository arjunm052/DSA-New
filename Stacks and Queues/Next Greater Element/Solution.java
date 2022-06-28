import java.util.*;

public class Solution {

    // Function to find the next greater element in an array
    // TC - O(N) SC - O(N)
    public static int[] nextGreater(int[] arr, int n) {
        // Initialize Stack. This stack will denote the right side of the array for a
        // given index
        Stack<Integer> stack = new Stack<>();
        // Initialize res array
        int[] res = new int[n];

        // Traverse through the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If the stack is Empty, no greater element exists on the right side of this
            // index, set the res to -1
            if (stack.isEmpty()) {
                res[i] = -1;
            }
            // If the element present on top of stack is greater than the current element
            // then we store the top element as res
            else if (stack.peek() > arr[i]) {
                res[i] = stack.peek();
            }
            // If the number on top of stack is smaller, than our current element, then we
            // keep popping from the stack until we find a larger element, or the stack
            // becomes empty
            else if (stack.peek() <= arr[i]) {
                // Pop elements until find a larger element or stack becomes empty
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }

                // if the stack becomes empty, no larger element exists on the right for current
                // index, set res to -1
                if (stack.isEmpty()) {
                    res[i] = -1;
                }
                // Else store the element on top of stack as res for this index
                else {
                    res[i] = stack.peek();
                }
            }

            // Don't forget to push the current element in the stack
            stack.push(arr[i]);
        }

        // return res array;
        return res;

    }

}
