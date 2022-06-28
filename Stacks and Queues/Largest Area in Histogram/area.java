import java.util.*;

public class Solution {
    static class Pair {
        int value;
        int index;

        Pair(int val, int idx) {
            this.value = val;
            this.index = idx;
        }
    }

    public static int largestRectangle(ArrayList<Integer> heights) {
        // We have to find NSL and NSR for each building .Then we calculate the width
        // upto which it can be extended and then we find the area
        // nsl[i] will hold the index of the next smallest element for ith building and
        // nsr[i] will hold index for next smallest building on right for ith index
        int[] nsl = new int[heights.size()];
        int[] nsr = new int[heights.size()];

        // We use this stack to find NSL and NSR
        Stack<Pair> stack = new Stack<Pair>();

        // First find the nsl of each building
        for (int i = 0; i < heights.size(); i++) {
            // If stack is empty we insert -1 as res
            if (stack.isEmpty()) {
                nsl[i] = -1;
            }
            // Else if the element on top is less than current element, we insert the top
            // element of stack as res
            else if (stack.peek().value < heights.get(i)) {
                nsl[i] = stack.peek().index;
            }
            // If the element on top of stack is greater than our current element
            else if (stack.peek().value >= heights.get(i)) {
                // We pop from the stack untill we find an element smaller than our current
                // element or stack becomes empty
                while (!stack.isEmpty() && stack.peek().value >= heights.get(i)) {
                    stack.pop();
                }

                // If stack becomes empty insert -1 as res
                if (stack.isEmpty()) {
                    nsl[i] = -1;
                }
                // else insert the top element of stack as res
                else {
                    nsl[i] = stack.peek().index;
                }
            }
            // add the current element onto the stack
            stack.push(new Pair(heights.get(i), i));
        }

        // clear the stack after finding the nsl
        stack.clear();

        // Now find the nsr of each building
        // Same process as above, we just travrse from right to left, and now when no
        // building exists that is smaller on right, then instead of -1 we insert length
        // of the array as res
        for (int i = heights.size() - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                nsr[i] = heights.size();
            } else if (stack.peek().value < heights.get(i)) {
                nsr[i] = stack.peek().index;
            } else if (stack.peek().value >= heights.get(i)) {
                while (!stack.isEmpty() && stack.peek().value >= heights.get(i)) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    nsr[i] = heights.size();
                } else {
                    nsr[i] = stack.peek().index;
                }
            }
            stack.push(new Pair(heights.get(i), i));
        }

        //initialize variable to hold the maxArea
        int maxArea = 0;
        //Traverse through the array
        for (int i = 0; i < heights.size(); i++) {
            //MaxArea from ith index will be the width to which it can be extended * height of the building
            maxArea = Math.max(maxArea, (nsr[i] - nsl[i] - 1) * heights.get(i));
        }

        //return maxArea
        return maxArea;
    }
}