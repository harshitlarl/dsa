package questions;

import java.util.*;

public class PrimeNumberFileRepresentation {
    public static void main(String[] args) {
        System.out.println(binaryGap(5));
    }

    public int countPrimeSetBits(int left, int right) {
        int num = (int)Math.pow(2, 20)-1,cnt=0;
        List<Integer> primeArr = Arrays.asList(2,3,5,7,11,13,17,19);
        for(int i=left;i<=right;i++){
            if(primeArr.contains(Integer.bitCount(i&num))){
                cnt++;
            }
        }
        return cnt;

    }

    public static int binaryGap(int n) {
        int ans = 0, start=-1,bitcnt=0;
        while(n>0){
            bitcnt++;
            int rem = n%2;
            if(rem==1){
                if(start!=-1)
                    ans =Math.max(ans,bitcnt-start);
                start=bitcnt;
            }
            n/=2;
        }
        return ans;
    }

    public int[] sortByBits(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ans.add(i);
        }
        Collections.sort(ans,(a,b)->{
            int cmp = Integer.bitCount(a)-Integer.bitCount(b);
            return cmp!=0 ? cmp : 0;
        });
        for (int i = 0; i < arr.length; i++) 
            arr[i] = ans.get(i);
        return arr;
        
    }

     class Solution {
 public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int cnt=0;
        while(sb.length()>0){
            int itr = sb.length()-1;
            if(sb.charAt(itr)=='0'){  
                sb.deleteCharAt(itr);
            }
            else{
                addOne(sb);
            }
            cnt++;
        }
        return cnt;
        
    }

    public void addOne(StringBuilder sb){
        int n = sb.length()-1;
        while(n>=0 &&sb.charAt(n)=='1'){
            sb.setCharAt(n, '0');
            n--; 
        }
        if(n<0)
            sb.insert(0,'1');
        else
            sb.setCharAt(n, '1');
            
    }

    public boolean areSentencesSimilar(String s1, String s2) {
        int p1=0,p2=0,cc=0;

        //Case1 
        while(p1<s1.length() &&p2<s2.length()){
            if(s1.charAt(p1)==s2.charAt(p2)){
                p1++;
                p2++;
            }
            else if(s1.length()==p1 || s2.length()==p2){
                return true;
            }
            else{
                if(s1.length()>s2.length())
                  {

                  }
            }
        }
        if(s1.length()==p1 || s2.length()==p2)
            return true;
        
        return false;
    }




}
  

}
