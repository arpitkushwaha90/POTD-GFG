class Solution {
    static final int MOD = 1_000_000_007;
    
    public int countSubsets(int[] arr) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        
        // mask for every number (1..30)
        int[] mask = new int[31];
        boolean[] valid = new boolean[31];
        
        valid[1] = true;
        mask[1] = 0;
        
        for (int num = 2; num <= 30; num++) {
            int m = 0;
            boolean ok = true;
            
            for (int i = 0; i < primes.length; i++) {
                int p = primes[i];
                
                if (num % (p * p) == 0) {
                    ok = false;
                    break;
                }
                
                if (num % p == 0) {
                    m |= (1 << i);
                }
            }
            
            valid[num] = ok;
            mask[num] = m;
        }
        
        int ones = 0;
        long[] dp = new long[1 << 10];
        dp[0] = 1;
        
        for (int x : arr) {
            if (x == 1) {
                ones++;
                continue;
            }
            
            if (!valid[x]) continue;
            
            int m = mask[x];
            
            for (int state = (1 << 10) - 1; state >= 0; state--) {
                if ((state & m) == 0) {
                    dp[state | m] = (dp[state | m] + dp[state]) % MOD;
                }
            }
        }
        
        long ans = 0;
        for (int state = 1; state < (1 << 10); state++) {
            ans = (ans + dp[state]) % MOD;
        }
        
        long pow = 1;
        for (int i = 0; i < ones; i++) {
            pow = (pow * 2) % MOD;
        }
        
        ans = (ans * pow) % MOD;
        return (int) ans;
    }
}
