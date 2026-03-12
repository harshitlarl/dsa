package jan_2026;

import java.util.*;

public class Min_abs_difference {
    //https://leetcode.com/problems/minimum-absolute-difference/?envType=daily-question&envId=2026-01-26

    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            int minDifference=Integer.MAX_VALUE;
            Arrays.sort(arr);
            for(int i =0;i<arr.length-1;i++){
                minDifference=Math.min(minDifference,arr[i+1]-arr[i]);
            }
            List<List<Integer>> ans = new ArrayList<>();
            for(int i=0;i<arr.length-1;i++){
                if(arr[i+1]-arr[i]==minDifference){
                    ans.add(Arrays.asList(arr[i],arr[i+1]));
                }
            }
            return ans;
        }
    }
}
