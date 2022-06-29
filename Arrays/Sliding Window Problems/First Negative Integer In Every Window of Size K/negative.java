public class Solution {

    // Function that return first negative integer that occurs in every window of
    // size k in an array
    // TC - O(N) SC - O(N)
    public static ArrayList<Integer> firstNegativeInteger(ArrayList<Integer> arr, int k, int n) {
        // Initialize the result array
        ArrayList<Integer> res = new ArrayList<>();

        // Initialize the queue that will hold the index of negative integers in order
        // we find them
        Queue<Integer> q = new LinkedList<>();

        // Initialize the pointers for our sliding window
        int i = 0, j = 0;

        // While end of our sliding window doesn't reach the end of array
        while (j < n) {
            // If the current element is negative, push it's index in a queue
            if (arr.get(j) < 0) {
                q.add(j);
            }

            // If our window is smaller than required window then we increase the window
            // size
            if (j - i + 1 < k) {
                j++;
            }
            // If we have the required size window
            else if (j - i + 1 == k) {
                // First we pop out all the indexes of negative integers from the queue that are
                // outside our current window or we until the queue becomes empty
                while (!q.isEmpty() && (q.peek() < i || q.peek() > j)) {
                    q.poll();
                }

                // If the queue becomes empty then no negative integer lies in this window, so
                // set the res to -1
                if (q.isEmpty()) {
                    res.add(0);
                }
                // Else in front of the queue we will have index of the first integer that
                // appears first in our window, add the element at that index to our res
                else {
                    res.add(arr.get(q.peek()));
                }

                // Slide the window
                i++;
                j++;
            }
        }

        // Return the final res array
        return res;
    }
}