class Solution {
    public int bitonic(int[] arr) {
        int n = arr.length;

        int[] inc = new int[n];
        int[] dec = new int[n];

        // Increasing part
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }

        // Decreasing part
        dec[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                dec[i] = dec[i + 1] + 1;
            } else {
                dec[i] = 1;
            }
        }

        int max = 1;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, inc[i] + dec[i] - 1);
        }

        return max;
    }
}
