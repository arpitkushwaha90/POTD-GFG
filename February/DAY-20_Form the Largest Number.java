class Solution {
    public String findLargest(int[] arr) {
        // code here
        int i,n=arr.length;
        String[] arr2 = new String[n];
        
        for(i=0;i<n;i++) {
            arr2[i] = Integer.toString(arr[i]);
        }
        
        Arrays.sort(arr2,(s1,s2) -> (s1+s2).compareTo(s2+s1) > 0? -1 : 1);
        
        if(arr2[0].equals("0"))
            return "0";
            
        StringBuilder res = new StringBuilder();
        
        for(i=0;i<n;i++)
            res.append(arr2[i]);
            
        return res.toString();
    }
}
