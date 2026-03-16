package mar_2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import questions.Tree.TreeTraversal.TreeNode;

public class Mar14_1415 {
    List<String> allStrings = new ArrayList<>();
    public String getHappyString(int n, int k) {
        
        generateAll(n, 0, "");
        Collections.sort(allStrings);
        System.out.println(allStrings.toString());
        return "";
        // return allStrings.get(k);
    }

    void generateAll(int n, int curr, String str) {
        System.out.println(n + "  "+curr +" "+str + " "+ allStrings.toString());
        if (curr == n) {
            allStrings.add(str);
            return ;
        }
        char[] chars = new char[] { 'a', 'b', 'c' };
        for (int i = 0; i < chars.length; i++) {
            if (str.isEmpty() || str == null)
                generateAll(n, curr + 1, str + chars[i]);
            if (str.length()>0 && str.charAt(str.length() - 1) != chars[i])
                generateAll(n, curr + 1, str + chars[i]);
        }
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return false;
        if(root.equals(subRoot))
            return true;
        return isSubtree(root.left,subRoot) ||  isSubtree(root.right,subRoot);
    }

}
