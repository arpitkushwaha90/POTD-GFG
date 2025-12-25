class Solution {
  public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        // maximum of all element will always satisfy the condition
        int max_val=INT_MIN,max_i=-1,max_j=-1;
        for(int i=0;i<mat.size();i++){
            for(int j=0;j<mat[i].size();j++){
                if(mat[i][j]>max_val){
                    max_val=mat[i][j];
                    max_i=i;
                    max_j=j;
                }
            }
        }
        return {max_i,max_j};
    }
};
