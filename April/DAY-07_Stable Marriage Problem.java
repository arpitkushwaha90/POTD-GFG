class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        // code here
        int i,n=men.length, freecnt = n;
        
        int[] mPartner = new int[n];
        int[] wPartner = new int[n];
        int[] next = new int[n]; 
        boolean[] freeMan = new boolean[n];
        
        Arrays.fill(mPartner, -1);
        Arrays.fill(wPartner, -1);
        Arrays.fill(next, 0);
        Arrays.fill(freeMan, true);
        
        while(freecnt>0) {
            int m=0;
            while(m<n) {
                if(freeMan[m])
                    break;
                m++;
            }
            
            int a = men[m][next[m]];
            next[m]++;
            
            if(wPartner[a]==-1) {
                wPartner[a] = m;
                mPartner[m] = a;
                freeMan[m] = false;
                freecnt--;
            } else {
                int mm = wPartner[a];
                
                int f=0;
                for(i=0;i<n;i++) {
                    if(women[a][i] == m) {
                        break;
                    }
                    if(women[a][i]==mm) {
                        f=1;
                        break;
                    }
                }
                
                if(f==0) {
                    wPartner[a] = m;
                    mPartner[m] = a;

                    freeMan[m] = false;
                    freeMan[mm] = true;
                }
            }
            
        }
        
        return mPartner;
        
    }
}
