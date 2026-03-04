class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {

        int n = arr.length;
        int i = 0, j = 0;
        int sum = 0, ans = 0;
        while(j < n) {
            sum ^= arr[j];
            if (j-i+1 == k) {
                ans = (sum > ans) ? sum:ans;
                sum = sum ^ arr[i];
                i++;
            }
            
            j++;
        }
        
        return ans;
    }
}
