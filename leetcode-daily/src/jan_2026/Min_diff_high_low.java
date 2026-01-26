package jan_2026;

import java.util.Arrays;

public class Min_diff_high_low {
//    https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/?envType=daily-question&envId=2026-01-26

    class Solution {
        public int minimumDifference(int[] nums, int k) {
            Arrays.sort(nums);
            int ans = Integer.MAX_VALUE;
            for(int i=0;i+k<=nums.length;i++){
                ans = Math.min(ans,nums[i+k-1]-nums[i]);
            }
            return ans==Integer.MAX_VALUE ? 0: ans;
        }
    }
}
