import java.util.*;

public class Mar7_1980 {
    //https://leetcode.com/problems/find-unique-binary-string/
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findDifferentBinaryString(new String[]{"111","011","001"}));
    }

    static class Solution {
    public String findDifferentBinaryString(String[] nums) {
        List<String> arr= Arrays.stream(nums).toList();
        return helper(arr,0,new StringBuilder(arr.get(0)));
    }

    //Starting WIth Initaial and FLipping all the Bits and checkinbg if it contains or not
    public String helper(List<String>nums, int ind, StringBuilder curr){
        if(!nums.contains(curr.toString()))
            return curr.toString();
        for(int i=ind;i<curr.length();i++){
            if(curr.charAt(i)=='1')curr.setCharAt(i, '0');
            else curr.setCharAt(i, '1');
            return helper(nums,i+1,curr);
        }
        return curr.toString();
    }

    //3 states -> nums, index, curr 
}
    
}
