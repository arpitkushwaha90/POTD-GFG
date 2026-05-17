// Make the array beautiful



class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        // code here
    List<Integer> result = new ArrayList<>();

        for (int x : arr) {
            // If the stack (list) is empty, simply add the element
            if (result.isEmpty()) {
                result.add(x);
            } else {
                // Get the top element of our stack
                int top = result.get(result.size() - 1);

                // Check if 'top' and 'x' have opposite signs
                // Case 1: top is non-negative and x is negative
                // Case 2: top is negative and x is non-negative
                if ((top >= 0 && x < 0) || (top < 0 && x >= 0)) {
                    // Opposite signs found: remove the adjacent element
                    result.remove(result.size() - 1);
                } else {
                    // Same signs: push 'x' onto the stack
                    result.add(x);
                }
            }
        }

        return result;    
    }
}
