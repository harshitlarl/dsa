package questions.Heaps;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.*;

public class Heaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Min Heap 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
         System.out.println("Please enter the Number of Elements");
        int size = sc.nextInt();
       
        while ((size--)>0) {
            int num = sc.nextInt();
            minHeap.add(num);
        }


        System.out.println("Added all the elements into the queue");
        System.out.println("Top Element is : " + minHeap.peek());
        System.out.println("MinHeap Size is : "+ minHeap.size());
        System.out.println("Extracting Elements one by one out of MinHeap ");
        while(minHeap.size()>0){
            System.out.println("polled Element : " + minHeap.poll());
        }




        //max Heap 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return (a%3)>(b%3) ? 1: 0;
        });
        
               pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(5);
        pq.add(20);
    }

    public int minSwaps(int[][] grid) {
        int[] zeroConFreq = new int[grid.length];
        for(int i=0;i<grid.length;i++){
            //Finding Consecutive Zeros in a row from Last
            for(int j=grid[i].length-1 ;j>=0 && grid[i][j]==0;j-- ){
                    zeroConFreq[i]++;
            }
        }
        int ans = 0;
        int n = zeroConFreq.length;
        for(int i=0;i<n;i++){
            int start =i;
            //Finding the Index where we are satisiying the condition 
            //Condition: where we find an elemeent whoise zero count is atlleast Greater then what is needed
            // tHat is needed is n-i-1 as it will gradually decrease the condition
            while(start<n && zeroConFreq[start]<n-i-1)
                    start++;
            if(start==n)
                return -1;
            ans+=start-i;
            //Swapping the Numbers
            while(start>i){
                int temp = zeroConFreq[start];
                zeroConFreq[start]=zeroConFreq[start-1];
                zeroConFreq[start-1]=temp;
                start--;
            }
        }
        return ans;
    }


    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b)->{
            if(a[0]==b[0])
                return a[1]<b[1] ? 1:0;
            else
                return a[0]<b[0] ? 1:0;
        });
        int attend=0, curr=events[0][0];
        for(int i=1;i<events.length;i++){
            if(curr<events[i][0]){
                curr=Math.min(curr+1,events[i][0]);
                attend++;
            }
        }
        return attend;
        
    }
    public class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a=a;
            this.b=b;
        }
    }

        public String[] findRelativeRanks(int[] score) {
        int[] temp = score;
        Arrays.sort(score, Collections.reverseOrder());
        Arrays.sort(temp,Collections.reverseOrder());
        return null;
    }


    public int numSpecial(int[][] mat) {
        int ans=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1 && isSpecial(mat,i,j))
                    ans++;
            }
        }
        return ans;
    }

    public boolean isSpecial(int[][]mat,int x,int y){
        for(int i=0;i<mat[x].length;i++){
            if(mat[x][i]==1 && i!=y)
                return false;
        }

        for(int i=0;i<mat.length;i++){
            if(mat[i][y]==1 && i!=x)
                return false;
        }
        return true;

    }


}
