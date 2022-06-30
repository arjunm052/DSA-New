import java.util.*;

class repeating {
    // TC - O(N) SC - O(N)
    public int lengthOfLongestSubstring(String s) {
        // Initialize the HashMap to store the freq of characters
        HashMap<Character, Integer> map = new HashMap<>();
        // Initialize result
        int res = 0;

        // Initialize window pointers
        int i = 0, j = 0;

        // While our window doesn't reach the end of the array
        while (i < s.length() && j < s.length()) {
            // Update the freq of character at jth index in frequency map
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            // If frequency of that character is 1, then all the characters present in our
            // map will have freq 1
            if (map.get(s.charAt(j)) == 1) {
                // update the result
                res = Math.max(res, map.size());
                // Increase the window size
                j++;
            }
            // If the updated frequency of current character becomes 2
            else if (map.get(s.charAt(j)) == 2) {
                // we start shortening the window by removing characters from the starting of
                // window until the frequency of character at jth index becomes 1 again
                while (map.get(s.charAt(j)) != 1) {
                    // get char at ith index
                    char c = s.charAt(i);
                    // if it's frequency is 1 then remove it from map
                    if (map.get(c) == 1) {
                        map.remove(c);
                    }
                    // else decrement its frequency
                    else {
                        map.put(c, map.get(c) - 1);
                    }
                    // Shorten the window
                    i++;
                }

                // If potential candidate found then update the result
                res = Math.max(res, map.size());
                // Increase the size of the window
                j++;
            }
        }

        // return final result
        return res;
    }
}