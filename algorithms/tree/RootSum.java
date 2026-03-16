package tree;

import questions.Tree.TreeTraversal;

import java.util.*;

public class RootSum{
    public static void main(String[] args){
        System.out.println("Hello World");
    }

    class Solution {
        int ans=0;
        public int sumNumbers(TreeNode root) {
            findTillRoot(root,"");
            return ans;
        }

        public void findTillRoot(TreeNode root, String curr){
            if(root.left==null && root.right==null)
                ans+=Integer.valueOf(curr);
            curr =curr+String.valueOf(root.val);
            findTillRoot(root.left,curr);
            findTillRoot(root.right,curr);
        }
    }
}

