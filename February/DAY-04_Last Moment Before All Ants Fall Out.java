class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int i,ans = 0;
        
        for(i=0;i<left.length;i++) {
            ans = Math.max(ans,left[i]);
        }
        
        for(i=0;i<right.length;i++) {
            ans = Math.max(ans,n-right[i]);
        }
        
        return ans;
    }
}
