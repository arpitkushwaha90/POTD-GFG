// Common in 3 Sorted Arrays

import java.util.*;

class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int n1 = a.length, n2 = b.length, n3 = c.length;

        while (i < n1 && j < n2 && k < n3) {
            // Case 1: All three elements match
            if (a[i] == b[j] && b[j] == c[k]) {
                result.add(a[i]);
                int commonVal = a[i];
                
                // Skip duplicates in all three arrays
                while (i < n1 && a[i] == commonVal) i++;
                while (j < n2 && b[j] == commonVal) j++;
                while (k < n3 && c[k] == commonVal) k++;
            }
            // Case 2: Move the pointer pointing to the smallest element
            else if (a[i] < b[j]) {
                i++;
            } else if (b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }

        return result;
    }
}
