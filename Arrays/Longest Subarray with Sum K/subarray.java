class subarray {

    // Function to find size of longest subarray with sum K
    // TC - O(N) SC - O(N)
    public static int lenOfLongSubarr(int arr[], int n, int k) {
        // Initialize a HashMap that stores (sum,index) value. It will store the sum of
        // the subarray starting from beginning upto a index
        // SUM -> INDEX means that starting from 0th index, the sum of all the elements
        // till the INDEX is SUM
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // res will hold the final maximum length of the subarray with the required sum
        int res = 0;

        // sum will hold the runningSum of the array
        int sum = 0;

        // We traverse the array from 0 to n-1
        for (int i = 0; i < n; i++) {
            // First add the new element to the running sum
            sum += arr[i];

            // If our sum is equal to targetSum, we store the length of the subarray that
            // will be i+1 as the result
            if (sum == k) {
                res = Math.max(res, i + 1);
            }

            // If the map doesn't contain this sum, then add it to the map with its value as
            // the current index
            // It will denote the sum ending at this index starting from the 0th index
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // *****IMPORTANT*****
            // Now we check whether sum-k exists in the array, mean we look for the INDEX
            // upto which the sum is sum-k
            // If we find such an index, that means from that INDEX+1 upto our current index
            // the summ will be k, so we have found another subarray with total sum equal to
            // K
            if (map.containsKey(sum - k)) {
                // Get the length of the subarray starting from INDEX+1 to Current Index
                // This will be equal to currentIndex - INDEX
                int length = i - map.get(sum - k);
                res = Math.max(res, length);
            }
        }

        // return the final result
        return res;
    }

}
