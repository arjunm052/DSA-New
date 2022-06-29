import java.util.*;

class maximum {
    static class Pair {
        int value;
        int index;

        Pair(int val, int idx) {
            this.value = val;
            this.index = idx;
        }
    }

    //TC - O(Nlogk)  SC - O(N)
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Initialize the result array
        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        // Create a MaxHeap that sorts for Pair class that sorts based on the object's
        // value
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.value, a.value));

        // Initialize pointers for our window
        int i = 0, j = 0;

        // Now we traverse through the array wntil our window reaches the end of the
        // array
        while (j < nums.length) {
            // Add the element at index j to the Max Heap
            maxHeap.add(new Pair(nums[j], j));

            // If current window size is smaller than required window size, then increase
            // current window size
            if (j - i + 1 < k) {
                j++;
            }
            // Else if current window size is equal to required window size
            else {
                // Keep popping from the Max If the index of the value of root is outside our
                // current window
                while (maxHeap.peek().index < i) {
                    maxHeap.poll();
                }

                // Store the element at root of maxheap as the result as it will be the max
                // element in our current window
                res[idx++] = maxHeap.peek().value;

                // Slide the window
                i++;
                j++;
            }
        }

        // return the result array
        return res;
    }
}