
public class Solution {
    int maxPeopleDefeated(int p) {
        int k=0;
        while(p>=0){
            k++;
            p-=k*k;
        }
        return k-1;
    }
}
