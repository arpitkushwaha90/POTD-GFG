class Solution {
    public int maxOnes(int arr[], int k) {
        int left = 0;
        int maxLen = 0;
        int zerosFlipped = 0;
        
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                zerosFlipped++;
            }
            
            while (zerosFlipped > k) {
                if (arr[left] == 0) {
                    zerosFlipped--;
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
