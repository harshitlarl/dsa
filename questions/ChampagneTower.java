package questions;

public class ChampagneTower {
    public static void main(String[] args) {
        System.out.println();
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[100][100];
        dp[0][0]=poured;
        for(int i=0;i<100;i++){
            for(int j=0;j<=i;j++){
                if(dp[i][j]>=1){
                    dp[i+1][j]+=(dp[i][j] - 1) / 2.0;
                    dp[i+1][j+1]+=(dp[i][j] - 1) / 2.0;
                }
            }
        }

        return dp[query_row][query_glass];
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int p1=a.length()-1,p2=b.length()-1, carry =0;
        while(p1>=0&& p2>=0){
            int currBit = ((a.charAt(p1)-'0') + (b.charAt(p2)-'0')+ carry)%2;
            carry = ((a.charAt(p1)-'0') + (b.charAt(p2)-'0')+ carry)/2;
            sb.appe
        }
        while(p1>=0){
            sb.append()
        }
        while(p2>=0){

        }

        return sb.toString();
    }
}
