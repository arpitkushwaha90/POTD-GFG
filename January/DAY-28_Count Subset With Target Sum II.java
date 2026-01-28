import java.util.*;

class Solution {
    public int countSubset(int[] arr, int k) {
        int n = arr.length;
        int mid = n / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        List<Long> leftSums = new ArrayList<>();
        List<Long> rightSums = new ArrayList<>();

        generateSums(left, 0, 0, leftSums);
        generateSums(right, 0, 0, rightSums);

        Collections.sort(rightSums);

        int count = 0;
        for (long s : leftSums) {
            long target = k - s;
            count += upperBound(rightSums, target)
                   - lowerBound(rightSums, target);
        }

        return count;
    }

    private void generateSums(int[] arr, int idx, long sum, List<Long> res) {
        if (idx == arr.length) {
            res.add(sum);
            return;
        }
        generateSums(arr, idx + 1, sum, res);
        generateSums(arr, idx + 1, sum + arr[idx], res);
    }

    private int lowerBound(List<Long> list, long target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    private int upperBound(List<Long> list, long target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
