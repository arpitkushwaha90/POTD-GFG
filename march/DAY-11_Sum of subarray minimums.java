class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int i,n=arr.length,ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        
        Stack<Integer> stk = new Stack<>();
        
        for(i=n-1;i>=0;i--) {
            while(!stk.empty() && arr[i]<=arr[stk.peek()]) {
                stk.pop();
            }
            
            int lastIndex = stk.empty() ? n : stk.peek();
            stk.push(i);
            map.put(i,lastIndex);
        }
        
        stk.clear();
        
        for(i=0;i<n;i++) {
            while(!stk.empty() && arr[i]<arr[stk.peek()]) {
                stk.pop();
            }
            
            int firstIndex = stk.empty() ? -1 : stk.peek();
            int x = map.get(i)-i;
            int y = i - firstIndex;
            x--;
            y--;
            int z = x+y+1;
            z = (z*(z+1))/2;
            x = (x*(x+1))/2;
            y = (y*(y+1))/2;

            ans += (arr[i]*(z-(x+y)));

                       
            stk.push(i);
        }
        
        return ans;
    }
}
