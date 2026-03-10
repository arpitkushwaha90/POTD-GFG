class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        Stack <Integer> stk = new Stack<Integer>();
        int ans=0,n=arr.length,i,a;
        
        for(i=n-1;i>=0;i--) {
            while(!stk.empty() && arr[i]<=arr[stk.peek()]) {
                stk.pop();
            }
            
            a = stk.empty() ? n : stk.peek();
            
            ans += (a-i);
            stk.push(i);
        }
        
        return ans;
    }
}
