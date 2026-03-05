package mar_2026;

public class Mar4_1758 {
    //https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string
    class Solution {
        public int minOperations(String s) {
            int repOne = 0, repZero = 0;
            //Two Possible Outcome 
            //01010101 -> ALternate 01
            //10101010 -> ALternate 10
            //Count if we can make both combos and min operation Needed 
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    if (s.charAt(i) == '0')
                        repOne++;
                    else
                        repZero++;
                } else {
                    if (s.charAt(i) == '0')
                        repZero++;
                    else
                        repOne++;

                }
            }
            return Math.min(repOne, repZero);
        }
    }
}
