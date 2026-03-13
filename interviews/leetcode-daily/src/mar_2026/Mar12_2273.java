import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mar12_2273 {
    //https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/?envType=daily-question&envId=2026-03-10
    class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<words.length;i++){
            String curr =ans.get(ans.size()-1);
            if(curr.length() != words[i].length()){
                ans.add(words[i]);
            }
            else if (!areAnagrams(curr, words[i])){
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public boolean areAnagrams(String a, String b){
        int[] freqa = new int[26];
        int[] freqb = new int[26];
        for(int i=0;i<a.length();i++){
            freqa[(a.charAt(i)-'a')]++;
            freqb[(b.charAt(i)-'a')]++;
        }
        for(int i=0;i<26;i++)
            if(freqa[i]!=freqb[i])
                return false;

        return true;
    }
}
}
