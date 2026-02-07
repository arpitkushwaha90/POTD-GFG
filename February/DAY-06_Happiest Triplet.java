class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);
        java.util.Arrays.sort(c);
        
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[3];
        
        int i = 0, j = 0, k = 0;
        int n = a.length;
        
        while (i < n && j < n && k < n) {
            int maxVal = Math.max(a[i], Math.max(b[j], c[k]));
            int minVal = Math.min(a[i], Math.min(b[j], c[k]));
            int diff = maxVal - minVal;
            int sum = a[i] + b[j] + c[k];
            
            if (diff < minDiff || (diff == minDiff && sum < minSum)) {
                minDiff = diff;
                minSum = sum;
                result[0] = a[i];
                result[1] = b[j];
                result[2] = c[k];
            }
            
            if (a[i] == minVal) {
                i++;
            } else if (b[j] == minVal) {
                j++;
            } else {
                k++;
            }
        }
        
        java.util.Arrays.sort(result);
        int temp = result[0];
        result[0] = result[2];
        result[2] = temp;
        
        return result;
    }
}
