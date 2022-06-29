import java.util.*;

class Solution {

    // TC - O(N*K) SC - O(N)
    int search(String pat, String txt) {
        // HashMap to store the frequency of characters in the pattern
        HashMap<Character, Integer> pFreq = new HashMap<>();

        // Create the Frequency map of the pattern
        for (int i = 0; i < pat.length(); i++) {
            pFreq.put(pat.charAt(i), pFreq.getOrDefault(pat.charAt(i), 0) + 1);
        }

        // Initialize the pointers for our window
        int i = 0, j = 0;

        // Initialize res variable
        int res = 0;

        // Length of the pattern will be our window size
        int k = pat.length();

        // Initialize the map that will hold the frequency count of the current window
        HashMap<Character, Integer> wMap = new HashMap<>();

        while (j < txt.length()) {
            // Add the character at j index to the window frequency map
            wMap.put(txt.charAt(j), wMap.getOrDefault(txt.charAt(j), 0) + 1);

            // If the current length of substring is smaller than the length of pattern then
            // we just increase our window
            if (j - i + 1 < k) {
                j++;
            }
            // Wlse if the length of the current substring is equal to our pattern length
            else if (j - i + 1 == k) {
                // Compare the pattern frequency map to our window map
                // If both are equal then we have found an anagram of pattern in the givne
                // string
                if (pFreq.equals(wMap)) {
                    res++;
                }

                // Now we have to slide our window so we decrease the frequency of first
                // character of window
                // If it is 1 then we remove it from the map
                if (wMap.get(txt.charAt(i)) == 1) {
                    wMap.remove(txt.charAt(i));
                }
                // Else we decrement its frequency since its going out of the window
                else {
                    wMap.put(txt.charAt(i), wMap.get(txt.charAt(i)) - 1);
                }

                // Slide the window
                i++;
                j++;
            }
        }

        // Return the Result
        return res;

    }
}