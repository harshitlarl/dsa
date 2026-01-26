package trie;

public class MaxXor {
    //https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/

    class Trie{
        TrieNode root;

        Trie(){
            this.root = new TrieNode();
        }

        public void insert( int num){
            for(int i=31;i>=0;i--){
                int currBit =
            }
        }

        class TrieNode{
            int left;
            int right;
        }
    }


    //Optimised O(NLOGN) with Trie + Bit Manipulation
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int num:nums){
            trie.insert(num);
        }
    }



    //Brute Force Approach
//    public int findMaximumXOR(int[] nums) {
//        int maxi=0;
//        for(int i=0;i<nums.length-1;i++){
//            for(int j=i+1;j<nums.length;j++){
//                maxi = Math.max(maxi , nums[i]^nums[j]);
//            }
//        }
//        return maxi;
//    }


}
