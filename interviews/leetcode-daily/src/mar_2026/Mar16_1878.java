package interviews.leetcode

import java.util.TreeSet;

-daily.src.mar_2026;

public class Mar16_1878 {
    class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> st = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //Including single Point Rhombus
                st.add(grid[i][j]);

                //Using Rhombus Property From center to its Endpoint distance 
                //So Trying from a single Point what all Rhombus cna we make 
                for (int k = 1;; k++) {
                    if (i - k < 0 || i + k >= m || j - k < 0 || j + k >= n)
                        break;

                    int sum = 0;

                    //Starting with all four Points of Rhombus 
                    //Top most
                    int x = i - k, y = j;
                    for (int t = 0; t < k; t++)
                        sum += grid[x + t][y + t];

                    //Bottom Most
                    x = i + k;
                    y = j;
                    for (int t = 0; t < k; t++)
                        sum += grid[x - t][y - t];

                    //Left Most 
                    x = i;
                    y = j - k;
                    for (int t = 0; t < k; t++)
                        sum += grid[x - t][y + t];

                    //Right Most
                    x = i;
                    y = j + k;
                    for (int t = 0; t < k; t++)
                        sum += grid[x + t][y - t];

                    st.add(sum);
                }
            }
        }
        int size = Math.min(3, st.size());
        int[] ans = new int[size];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = st.pollLast();
        }
        return ans;
    }
}
}
