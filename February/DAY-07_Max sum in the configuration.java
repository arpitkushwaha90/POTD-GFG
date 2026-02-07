class Solution {
    int maxSum(int arr[]) {
        int n = arr.length;
        
        int sum = 0;
        int currentSum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            currentSum += i * arr[i];
        }
        
        int maxSum = currentSum;
        
        for (int i = 1; i < n; i++) {
            currentSum = currentSum + sum - n * arr[n - i];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
