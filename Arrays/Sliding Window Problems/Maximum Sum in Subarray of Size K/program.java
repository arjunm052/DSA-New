class Solution {
    // TC - O(N) SC - O(1)
    static long maximumSumSubarray(int k, ArrayList<Integer> arr, int N) {
        // Initialize the window pointers
        int i = 0, j = 0;

        // Initialize sum variable which will hold thevalue of sum of the current window
        long sum = 0;

        // Initialize max variable that will hold the max sum from all windows
        long max = 0;

        // We traverse through the array until the end of the window reaches the end of
        // the array
        while (j < N) {
            // Include the current element at index j in the sum
            sum += arr.get(j);

            // If current window size is smaller than required window size, then increase
            // the end pointer of the window
            if (j - i + 1 < k) {
                j++;
            }
            // Else if we have the required window size
            else if (j - i + 1 == k) {
                // Update the max variable with the Maximum of currentMax and the sum of current
                // window
                max = Math.max(max, sum);

                // Remove the first element from the window and slide the window to the right
                sum = sum - arr.get(i);
                i++;
                j++;
            }
        }

        // Return the final result
        return max;
    }
}