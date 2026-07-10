class Solution {
    public int getCount(int n) {
        if(n==1) return 0;
        int ans=0;
        int i=1,j=1;
        int sum=1;
        while(j<n){
            if(sum==n) { ans++; sum+=++j; sum-=i++;}
            else if(sum<n) sum+=++j;
            else sum-=i++;
        }
        return ans;
    }
}
