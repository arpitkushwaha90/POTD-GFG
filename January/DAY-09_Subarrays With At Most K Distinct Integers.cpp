
class Solution {
  public:
    int countAtMostK(vector<int> &arr, int k) {
        int n = arr.size();
        unordered_map<int, int> mp; // Stores frequency of elements in current window
        
        int i = 0; // Left pointer
        int j = 0; // Right pointer
        
        int result = 0; // Total count of subarrays
        
        while(j < n) {
            
            // Add current element to window
            mp[arr[j]]++;
            
            // If window has more than k distinct elements, shrink from left
            while(mp.size() > k) {
                mp[arr[i]]--;
                if(mp[arr[i]] == 0) {
                    mp.erase(arr[i]); // Remove element completely if count becomes 0
                }
                i++; // Move left pointer forward
            }
            
            // All subarrays ending at j starting from i to j are valid
            // Number of such subarrays = length of window
            result += (j - i + 1);
            
            j++; // Move right pointer forward
        }
        return result;
    }
};

