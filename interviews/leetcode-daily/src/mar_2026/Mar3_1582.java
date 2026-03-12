package mar_2026;

public class Mar3_1582 {
   
   
    class Solution {
        //Brute Force TC O(N^3) SC O(1)
        public int numSpecial(int[][] mat) {
            int ans=0;
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[i].length;j++){
                    if(mat[i][j]==1 && isSpecial(mat,i,j))
                        ans++;
                }
            }
            return ans;
        }

        public boolean isSpecial(int[][]mat,int x,int y){
            for(int i=0;i<mat[x].length;i++){
                if(mat[x][i]==1 && i!=y)
                    return false;
            }

            for(int i=0;i<mat.length;i++){
                if(mat[i][y]==1 && i!=x)
                    return false;
            }
            return true;

        }
    }



    class Solution2 {
        //Optimiseed Approach  TC O(N^2) SC O(N)
        //Precomputing the frequency and checking it at time of traversla again 
        public int numSpecial(int[][] mat) {
            int[]rowcnt = new int[mat.length];
            int [] colcnt = new int[mat[0].length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    rowcnt[i]+=mat[i][j];
                    colcnt[j]+=mat[i][j];
                }
                
            }

            int ans = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if(mat[i][j]==1 && rowcnt[i]==1 && colcnt[j]==1)
                        ans++;
                }
            }
            return ans;
        }
    }
}
