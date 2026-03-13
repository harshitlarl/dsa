

public class Mar4_1758 {
    // https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string
    class Solution {
        public int minOperations(String s) {
            int repOne = 0, repZero = 0;
            // Two Possible Outcome
            // 01010101 -> ALternate 01
            // 10101010 -> ALternate 10
            // Count if we can make both combos and min operation Needed
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


         //https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/solutions/7625775/draft-by-la_castille-z9kb/?envType=daily-question&envId=2026-03-05
        public int minOperations1(String s) {
            int n = s.length();
            int ans = 0;
            //For each Index we calculate If its correct 0101 sequence
            //Count of bits where its not we have to flip those bits 
            //for 101010v -> Opposite count Revrse Like tota;l - 010101 mismatch
            for (int i = 0; i < n; i++) {
                ans += ((s.charAt(i) - '0') ^ (i & 1));
            }
            return Math.min(ans, n - ans);
        }
    }
}
