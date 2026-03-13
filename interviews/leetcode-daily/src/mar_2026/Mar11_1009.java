public class Mar11_1009 {
    class Solution {
    public int bitwiseComplement(int n) {
        // a + a' = 2^n-1
        // Number + its compelment = 2^power-1
        int twoPower = 1;
        while (twoPower<n) {
            twoPower=twoPower*2+1; // it Gives always 11111
        }
        return twoPower^n;

    }
}
}
