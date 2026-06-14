
public class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        return r(0,0,mat,true);
    }
    private List<Integer> r(int i, int j, int[][]mat, boolean dir){
        if(dir){
            while(j<mat[0].length){
                if(mat[i][j]==1) {
                    mat[i][j]=0;
                    return u(i+1,j,mat,false);
                }
                j++;
            }
            return Arrays.asList(i,mat[0].length-1);
        }
        else{
            while(j>=0){
                if(mat[i][j]==1) {
                    mat[i][j]=0;
                    return u(i-1,j,mat,true);
                }
                j--;
            }
            return Arrays.asList(i,0);
        }
    }
    private List<Integer> u(int i, int j, int[][]mat, boolean dir){
        if(dir){
            while(i>=0){
                if(mat[i][j]==1) {
                    mat[i][j]=0;
                    return r(i,j+1,mat,true);
                }
                i--;
            }
            return Arrays.asList(0,j);
        }
        else{
            while(i<mat.length){
                if(mat[i][j]==1) {
                    mat[i][j]=0;
                    return r(i,j-1,mat,false);
                }
                i++;
            }
            return Arrays.asList(mat.length-1,j);
        }
    }
}
