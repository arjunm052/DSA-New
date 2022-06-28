import java.util.ArrayList;
import java.util.Stack;

public class stock {

    static class Pair {
        int value;
        int index;

        Pair(int val, int idx) {
            this.value = val;
            this.index = idx;
        }
    }

    // TC - O(N) SC - O(N)
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Resultant array
        ArrayList<Integer> res = new ArrayList<>();
        // Stack we use to find Next Greatest element on left for the given array
        Stack<Pair> stack = new Stack<>();

        // Traverse through the array from left to right
        for (int i = 0; i < price.size(); i++) {
            // If stack is empty then add -1 to the result
            if (stack.isEmpty()) {
                res.add(-1);
            }
            // If the element present on top of stack is greater than current element, add
            // the index of top element of stack to res
            else if (stack.peek().value > price.get(i)) {
                res.add(stack.peek().index);
            }
            // If the element on top of stack is smaller than our current element
            else if (stack.peek().value <= price.get(i)) {
                // We keep popping from the stack until we find a larger element or stack
                // becomes empty
                while (!stack.isEmpty() && stack.peek().value <= price.get(i)) {
                    stack.pop();
                }

                // If stack became empty then add -1 to the result
                if (stack.isEmpty()) {
                    res.add(-1);
                }
                // If we found an element then add its index to the result
                else {
                    res.add(stack.peek().index);
                }
            }

            // Add our current element on top of stack
            stack.add(new Pair(price.get(i), i));
        }

        //Traverse through the array and for every index i, calculate the stock span
        //stock span for i index would be i-res[i]
        for (int i = 0; i < price.size(); i++) {
            res.set(i, i - res.get(i));
        }

        //return the final result
        return res;
    }
}