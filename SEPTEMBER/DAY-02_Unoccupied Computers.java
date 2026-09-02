class Solution {
    public int solve(int n, String s) {
        // code here
        HashSet<Character> occupied=new HashSet<>();
        HashSet<Character> unOccupied=new HashSet<>();
        int count=n;
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            if(unOccupied.contains(a)){
                continue;
            }
            else if(occupied.contains(a)){
                count++;
                occupied.remove(a);
            }else if(!occupied.contains(a)&&count!=0){
                occupied.add(a);
                count--;
            }
            else{
                unOccupied.add(a);
            }
        }
        return unOccupied.size();
    }
}
