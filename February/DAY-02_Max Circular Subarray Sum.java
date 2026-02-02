class Solution {
    public int maxCircularSum(int arr[]) {
        int n = arr.length;
        
        int maxKadane = kadaneMax(arr);
        
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i];
        }
        
        int minKadane = kadaneMax(arr);
        int maxCircular = totalSum + minKadane;
        
        if (maxCircular == 0) {
            return maxKadane;
        }
        
        return Math.max(maxKadane, maxCircular);
    }
    
    private int kadaneMax(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
