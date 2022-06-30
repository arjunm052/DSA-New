class substring {
    // TC - O(N) SC - O(N)
    public int longestkSubstr(String s, int k) {
        // Declare a HashMap to store frequency of characters in current window
        HashMap<Character, Integer> freq = new HashMap<>();
        // Initialize result to -1
        int res = -1;

        // Initialize the window pointers
        int i = 0, j = 0;

        // While our window doesn't reach the end of the array
        while (j < s.length()) {
            // We update the frequency of current character at index j in freq map
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);

            // If size of frequency map is less than k than increase the size of window
            if (freq.size() < k) {
                j++;
            }
            // If size of frequency map is equal to required size then update our final
            // result and then increase the window
            else if (freq.size() == k) {
                res = Math.max(res, j - i + 1);
                j++;
            }
            // Else if map size is greater than the required size then we start shortening
            // our window by removing character at ith index from our freq map
            else if (freq.size() > k) {
                // Keep removing characters until the map size is bigger than required size
                while (freq.size() > k && i < j) {
                    // Get the character at ith index
                    char c = s.charAt(i);

                    // If its frequency is 1 in map, then remove it
                    if (freq.get(c) == 1) {
                        freq.remove(c);
                    }
                    // Otherwise decrement its frequency
                    else {
                        freq.put(c, freq.get(c) - 1);
                    }
                    // Shorten the window size
                    i++;
                }

                // After coming out of the loop if we have found a potential candidate then
                // update result
                if (freq.size() == k) {
                    res = Math.max(res, j - i + 1);
                }

                // increment window size
                j++;
            }

        }

        // return final result
        return res;
    }
}