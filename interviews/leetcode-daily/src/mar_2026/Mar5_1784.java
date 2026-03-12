package mar_2026;

public class Mar5_1784 {
    //https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones
    class Solution {
        public boolean checkOnesSegment(String s) {
            //countif we encouneter any 1 after 0 occured
            int cnt = 0, zc = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    if (zc == 0)
                        cnt = 1;
                    else
                        cnt++;
                } else
                    zc++;
            }
            return cnt == 1;
        }
    }
}
