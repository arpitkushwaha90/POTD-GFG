class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
        int i,j,ans=0,n=arr.length,c=0;
        Queue<Integer> Q = new LinkedList<>();
        
        for(i=0;i<n;i++) {
            if(!Q.isEmpty()) {
                int b = Q.peek();
                if((b+k)<=i) {
                    Q.remove();
                    c--;
                }
            }
            int a = c%2;
            arr[i] = arr[i] ^ a;
  
            if(arr[i]==0 && (i+k)<=n) {
                Q.add(i);
                c++;
                ans++;
                arr[i]=1;
            }
        }
        
        for(i=0;i<n;i++) {
            if(arr[i]==0)
                return -1;
        }
        
        return ans;
    }
}
