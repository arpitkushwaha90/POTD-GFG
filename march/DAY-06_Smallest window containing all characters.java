// Smallest window containing all characters

class Solution {
    public static String minWindow(String s, String p) {
        int n = s.length();
        int m = p.length();

        if (n < m) return "";

        // Frequency arrays for 'p' and the current window in 's'
        int[] hashP = new int[256];
        int[] hashS = new int[256];

        // Store frequency of characters in p
        for (int i = 0; i < m; i++) {
            hashP[p.charAt(i)]++;
        }

        int left = 0, startIdx = -1, minLen = Integer.MAX_VALUE;
        int count = 0; // Number of characters in window that match p's requirements

        for (int right = 0; right < n; right++) {
            char rChar = s.charAt(right);
            hashS[rChar]++;

            // If current char is in p and window frequency is <= p's requirement
            if (hashP[rChar] != 0 && hashS[rChar] <= hashP[rChar]) {
                count++;
            }

            // If all characters of p are found in the current window
            if (count == m) {
                // Try to shrink the window from the left
                while (hashS[s.charAt(left)] > hashP[s.charAt(left)] || hashP[s.charAt(left)] == 0) {
                    hashS[s.charAt(left)]--;
                    left++;
                }

                // Update minimum window size
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIdx = left;
                }
            }
        }

        // If no window was found
        if (startIdx == -1) return "";

        return s.substring(startIdx, startIdx + minLen);
    }
}
