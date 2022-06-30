class Solution {
    // TC - O(M + N) SC - O(N)
    // The idea is to first create a frequency map of the given pattern. Then we
    // start processing the element from the jth index
    // As we find characters that are present in our pattern, we decrement their
    // frequency in the frequency map.
    // If in our current window, if all the characters of our pattern are present
    // then the frequency of each elment in the map will be 0.
    // Example - S = ""ADOBECODEBANC" P = "ABC"
    // If our current window is "ADOBEC" then we have all the characters in the
    // pattern present in our substring with their exact frequency. If we have an
    // extra character in our substring that is in the frequency map, then it's
    // frequency will go in negative, meaning we have 1 extra character that we
    // don't want....
    // We first slide our window to find a potential candidate, and after a
    // potential candidate has been found then we start decreasing the size of the
    // window to minimize the length until the window becomes invalid

    public String minWindow(String s, String t) {
        // Initialize HashMap to create frequency map of patttern
        HashMap<Character, Integer> map = new HashMap<>();

        // Create the frequency map of pattern
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Initialize count as the total no. of distinct characters in the pattern
        int count = map.size();

        // Initialize window pointers
        int i = 0, j = 0;

        // minLen will hold length of the minimum length subarray found that contains
        // all the characters of pattern including the duplicates
        int minLen = Integer.MAX_VALUE;

        // start and end will hold the indexes of the minimum length subarray fulfilling
        // all the conditions
        int start = 0, end = 0;

        // Start traversing the array
        while (i < s.length() && j < s.length()) {

            // Get the character on jth index to be processed
            char c = s.charAt(j);

            // If we have that character in the pattern frequency map
            if (map.containsKey(c)) {
                // Decrement its count
                map.put(c, map.get(c) - 1);

                // If frequency of this character after updating has become zero, then we have
                // found the required no. of this character in current window, so decrement the
                // count by 1, as we have found all the instances of this character that we need
                if (map.get(c) == 0) {
                    count--;
                }
            }

            // If in our current window we have all the needed characters, then we start to
            // decrease our window size
            if (count == 0) {

                // While we have a valid window
                while (count == 0) {

                    // Store the result if current window length is smaller than our previous result
                    if (j - i + 1 < minLen) {
                        // Store the length of the current window
                        minLen = Math.min(minLen, j - i + 1);
                        // Also store the start and end index
                        start = i;
                        end = j + 1;
                    }

                    // Now we start to decrease the size of our window by removing characters from
                    // the beginning

                    // Get the character at the starting index
                    char startChar = s.charAt(i);

                    // If that character is in our map
                    if (map.containsKey(startChar)) {
                        // Then increment it's frequency count
                        map.put(startChar, map.get(startChar) + 1);

                        // If it's frequency count has become more than zero, so now we need 1 more
                        // instance of this character to make our window valid. So increase the count by
                        // 1 as we still have 1 more character we need to find
                        if (map.get(startChar) > 0) {
                            count++;
                        }
                    }

                    // After processing the ith element, make the window size smaller by
                    // incrementing the ith index
                    i++;
                }
            }

            // Increase the size of our current window by increasing jth index
            j++;
        }

        // If minLen is still MAX_VALUE after processing the coplete string, then return
        // empty string
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        // Else return the substring from main string using starting and ending index of
        // the resultant subarray that we stored earlier
        return s.substring(start, end);
    }
}