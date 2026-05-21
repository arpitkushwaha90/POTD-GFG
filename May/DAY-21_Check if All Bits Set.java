// Check if All Bits Set


class Solution {
    public boolean isBitSet(int n) {
        // Edge case: 0 has no bits set
        if (n == 0) {
            return false;
        }
        
        // If all bits are set, (n & (n + 1)) will always be 0
        return (n & (n + 1)) == 0;
    }
}
