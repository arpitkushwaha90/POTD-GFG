// Longest Subarray Sum Divisible by K

class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        long sum = 0;
        int maxLen = 0;

        mp.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            int rem = (int) (((sum % k) + k) % k);

            if (mp.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - mp.get(rem));
            } else {
                mp.put(rem, i);
            }
        }

        return maxLen;
    }
}
