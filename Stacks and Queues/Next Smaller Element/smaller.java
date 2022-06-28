import java.util.*;

public class smaller {
    // Function to get next smaller element
    // TC - O(N) SC - O(N)
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        // Initialize res array
        ArrayList<Integer> res = new ArrayList<Integer>();
        // Initialize stack
        Stack<Integer> stack = new Stack<>();

        // Traverse through the given array from left to right
        for (int i = n - 1; i >= 0; i--) {
            // If the stack is empty no smaller element present on right of current index so
            // add -1 to the res
            if (stack.isEmpty()) {
                res.add(0, -1);
            }
            // If the element present on top of stack is smaller than our current element,
            // then add the element on top of stack in the res array
            else if (stack.peek() < arr.get(i)) {
                res.add(0, stack.peek());
            }
            // If the element on top of stack is greater than our current element, then we
            // pop from the stack until the stack becomes empty or we find an element
            // smaller than our current element
            else if (!stack.isEmpty() && stack.peek() >= arr.get(i)) {
                while (!stack.isEmpty() && stack.peek() >= arr.get(i)) {
                    stack.pop();
                }

                // If stack becomes empty then no smaller element exists on the right so add -1
                // to res
                if (stack.isEmpty()) {
                    res.add(0, -1);
                }
                // Otherwise add the element on top of stack to the res
                else {
                    res.add(0, stack.peek());
                }
            }
            // Push the current element in the stafck before moving to next iteration
            stack.push(arr.get(i));
        }

        // return res array
        return res;
    }
}