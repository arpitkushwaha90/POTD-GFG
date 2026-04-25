// Opposite Sign Pair Reduction


import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int current : arr) {
            boolean currentDestroyed = false;

            // While there are opposite signs, resolve the reduction
            while (!stack.isEmpty() && isOppositeSign(stack.peek(), current)) {
                int top = stack.peek();
                int absTop = Math.abs(top);
                int absCurrent = Math.abs(current);

                if (absTop > absCurrent) {
                    // Current is smaller, it gets consumed
                    currentDestroyed = true;
                    break;
                } else if (absTop < absCurrent) {
                    // Top is smaller, it gets consumed, keep checking current
                    stack.pop();
                } else {
                    // Both are equal absolute value, both destroyed
                    stack.pop();
                    currentDestroyed = true;
                    break;
                }
            }

            // If current survived all reductions, add it to the stack
            if (!currentDestroyed) {
                stack.push(current);
            }
        }

        return new ArrayList<>(stack);
    }

    private boolean isOppositeSign(int a, int b) {
        // Return true if one is positive and the other is negative
        return (a > 0 && b < 0) || (a < 0 && b > 0);
    }
}
