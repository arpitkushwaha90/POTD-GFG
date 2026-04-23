// Two Equal Sum Subarrays

class Solution {
    public boolean canSplit(int arr[]) {
        int n = arr.length;
        if (n < 2) return false;

        // 1. Calculate the total sum of the array
        // Use long for the sum to prevent overflow (10^5 * 10^6 = 10^11)
        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // 2. If the total sum is odd, it cannot be split into two equal integer sums
        if (totalSum % 2 != 0) {
            return false;
        }

        // 3. Find if any prefix sum equals exactly half of the total sum
        long target = totalSum / 2;
        long runningSum = 0;
        
        for (int num : arr) {
            runningSum += num;
            if (runningSum == target) {
                return true;
            }
            // Optimization: if we exceed target, we can't find a split 
            // (since all elements are positive)
            if (runningSum > target) {
                return false;
            }
        }

        return false;
    }
}
