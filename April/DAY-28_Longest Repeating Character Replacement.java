// Longest Repeating Character Replacement

class Solution {
    public int longestSubstr(String s, int k) {
        int n = s.length();
        int[] freq = new int[26]; // To store frequency of 'A'-'Z'
        
        int left = 0;
        int maxCount = 0; // Most frequent character count in the current window
        int maxLength = 0;
        
        for (int right = 0; right < n; right++) {
            // Add current character to window
            char current = s.charAt(right);
            freq[current - 'A']++;
            
            // Update maxCount for the current window
            maxCount = Math.max(maxCount, freq[current - 'A']);
            
            // Number of replacements needed = (window size - maxCount)
            // If replacements needed > k, shrink window from left
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                // Note: We don't strictly need to update maxCount when shrinking 
                // because a smaller maxCount won't help us find a longer maxLength.
            }
            
            // Current window is valid, update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
