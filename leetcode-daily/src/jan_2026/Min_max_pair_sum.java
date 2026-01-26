package jan_2026;

import java.util.Arrays;

public class Min_max_pair_sum {
    //https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/?envType=daily-question&envId=2026-01-26
    class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);
            int maxi=0;
            for(int i=0;i<nums.length/2;i++){
                maxi = Math.max(maxi,nums[i]+nums[nums.length-1-i]);
            }
            return maxi;
        }
    }
}
