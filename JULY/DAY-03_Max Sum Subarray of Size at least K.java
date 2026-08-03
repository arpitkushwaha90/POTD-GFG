class Solution {
    public int maxSumWithK(int[] arr, int k) {
        int n = arr.length;

        int[] maxEndHere = new int[n];
        maxEndHere[0] = arr[0];

        for (int i = 1; i < n; i++) {
            maxEndHere[i] = Math.max(arr[i], maxEndHere[i - 1] + arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int ans = sum;

        for (int i = k; i < n; i++) {
            sum += arr[i];
            sum -= arr[i - k];

            ans = Math.max(ans, sum);

            if (maxEndHere[i - k] > 0) {
                ans = Math.max(ans, sum + maxEndHere[i - k]);
            }
        }

        return ans;
    }
}
