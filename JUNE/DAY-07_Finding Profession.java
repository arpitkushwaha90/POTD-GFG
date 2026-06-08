public class Solution {
    public String profession(int level, int pos) { //MyCode
        if(pos==1) return "Engineer";
        boolean ans=true; //Engineer
        int l=(int)Math.pow(2,(int)(Math.log(pos-1)/Math.log(2)));
        while(l>0){
            if(pos>l){
                pos-=l;
                ans=!ans;
            }
            l/=2;
        }
        if(ans) return "Engineer";
        else return "Doctor";
    }

    public String profession1(int level, int pos) { //Bit Method
        int n=pos-1; //Starting with 0-indexed
        int c = 0;
        while (n > 0) {
            n &= (n - 1); 
            c++;
        }
        return (c % 2 == 1) ? "Doctor" : "Engineer";
    }
}
