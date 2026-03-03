// Longest subarray with Atmost two distinct integers

import java.util.HashMap;

class Solution {
    public int totalElements(int[] arr) {
        int n = arr.length;
        if (n <= 2) return n;

        // Map to store frequency of elements in the current window
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            // Add the current element to the window
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // If we have more than 2 distinct integers, shrink from the left
            while (map.size() > 2) {
                int leftElement = arr[left];
                map.put(leftElement, map.get(leftElement) - 1);
                
                // If frequency becomes 0, remove it to reduce map size
                if (map.get(leftElement) == 0) {
                    map.remove(leftElement);
                }
                left++;
            }

            // Calculate the length of the current valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
