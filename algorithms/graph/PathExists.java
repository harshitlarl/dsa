//package graph;
//
//import java.util.*;
//
//public class PathExists {
//
//        public long minMoves(int[] balance) {
//        // Case for -1
//        long netSum=0;
//        for(int num:balance)
//            netSum+=num;
//        if(netSum<0)
//            return -1;
//
//        int negIndex=0, negvalue=0, n = balance.length,itr=1;
//        long ans=0;
//        for(int i=0;i<balance.length;i++){
//            if(balance[i]<0){
//                negIndex=i;
//                negvalue=balance[i];
//                break;
//            }
//        }
//
//        while(balance[negIndex]<0){
//            int leftindex = (n + negIndex-itr)%n;
//            int rightIndex = (n + negIndex+itr)%n;
//            if(balance[negIndex]+balance[leftindex]<0){
//                ans+=((long)balance[leftindex]*(itr));
//                balance[negIndex]+=balance[leftindex];
//            }
//            else{
//                ans+=Math.abs(((long)balance[negIndex])*(itr));
//                balance[negIndex]=0;
//            }
//
//            if(balance[negIndex]+balance[rightIndex]<0){
//                ans+=(long)((long)balance[rightIndex]*itr);
//                balance[negIndex]+=balance[rightIndex];
//            }
//            else{
//                ans+=Math.abs((long)balance[negIndex])*itr;
//                balance[negIndex]=0;
//            }
//
//            itr++;
//
//        }
//
//
//        return ans;
//
//    }
//
//    public long minMoves(int[] balance) {
//        // Case for -1
//        int netSum=0;
//        for(int num:balance)
//            netSum+=num;
//        if(netSum<0)
//            return -1;
//
//        int negIndex=0, negvalue=0,ans=0, n = balance.length,itr=1;
//        for(int i=0;i<balance.length;i++){
//            if(balance[i]<0){
//                negIndex=i;
//                negvalue=balance[i];
//                break;
//            }
//        }
//
//        while(negvalue<0){
//            int leftindex = (n + negIndex-itr)%n;
//            int rightIndex = (n + negIndex+itr)%n;
//            if(balance[negIndex]+balance[leftindex]<0){
//                ans+=balance[leftindex];
//            }
//            else{
//                ans+=Math.abs(balance[negIndex]);
//            }
//
//            if(balance[negIndex]+balance[rightIndex]<0){
//                ans+=balance[rightIndex];
//            }
//            else{
//                ans+=Math.abs(balance[rightIndex]);
//            }
//
//            itr++;
//
//        }
//
//
//        return ans;
//
//    }
//
//
//
//
//    public String reverseWords(String s) {
//        String[]words = s.split(" ");
//        int wc = countVowel(words[0]);
//        StringBuilder sb = new StringBuilder(words[0] );
//        for(String st : words){
//            sb.append(" ");
//            int nwc = countVowel(st);
//            if(nwc==wc){
//                String reversed = new StringBuilder(st).reverse().toString();
//                sb.append(reversed );
//            }
//            else{
//                sb.append(st);
//            }
//        }
//        return sb.toString();
//    }
//
//    int countVowel(String str){
//        String chr = "aeiou";
//        int cnt=0;
//        // char[] chr = new char[]{'a','e','i','o','u'};
//        for(char ch: str.toCharArray()){
//            if(chr.contains(""+ch))
//                cnt++;
//        }
//        return cnt;
//    }
//
//
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> ans = new HashMap<>();
//
//        for(String str: strs){
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String sortedWord = new String(chars);
//
//            if(ans.containsKey(sortedWord)){
//                ans.get(sortedWord).add(str);
//            }
//            else{
//                ans.put(sortedWord, new ArrayList<>());
//                ans.get(sortedWord).add(str);
//            }
//        }
//
//        return new ArrayList<>(ans.values());
//    }
//
//    public String getCharNum(String str){
//        StringBuilder sb = new StringBuilder("0".repeat(26));
//        for(int i=0;i<str.length();i++){
//            sb.put((str.charAt(i)-'a'),sb);
//        }
//    }
//
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer,Integer> mp = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            if(mp.containsKey(target-nums[i])){
//                return new int[]{i,mp.get(target-nums[i])};
//            }
//            else
//                mp.put(nums[i],i);
//        }
//        return new int[]{-1,-1};
//    }
//
//
//
//    public boolean isAnagram(String s, String t) {
//        Map<Character,Integer> mp = new HashMap<>();
//        for(Character ch: s.toCharArray()){
//            mp.put(ch,mp.getOrDefault(mp, 0)+1);
//        }
//        for(Character ch : t.toCharArray()){
//            if(mp.containsKey(ch) && mp.get(ch)>0){
//                mp.put(ch,mp.get(ch)-1);
//            }
//            else{
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//public boolean containsDuplicate(int[] nums) {
//       Map <Integer,Integer> mp = new HashMap<>();
//       for(int num:nums){
//            if(mp.get(num)==null)
//                return true;
//            mp.put(num,1);
//       }
//
//       return false;
//    }
//
//
//
//    public int minJumps(int[] arr) {
//        ArrayList<ArrayList<Integer>> gph = new ArrayList<>();
//        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
//        for(int i=0;i<arr.length;i++){
//            if(mp.get(arr[i])!=null){
//                mp.put(arr[i],new ArrayList<>(Arrays.asList(i)));
//            }
//            else{
//                mp.get(arr[i]).add(i);
//            }
//        }
//
//        Queue<Integer> pq = new LinkedList<>();
//        pq.add(0);
//        Set<Integer> vis = new HashSet<>();
//
//        int ans=0;
//        while(pq.isEmpty()){
//            List<Integer> next = new ArrayList<>();
//            for(int node:pq){
//                if(node ==arr.length-1)
//                    return ans;
//
//
//
//            }
//            ans++;
//
//        }
//
//        return ans;
//    }
//
//
//
//
//
//
//    public int[] processQueries(int c, int[][] connections, int[][] queries) {
//        ArrayList<ArrayList<Integer>> arr =new ArrayList<>();
//        ArrayList<Integer> ans = new ArrayList<>();
//        boolean [] vis = new boolean[c+1];
//        Arrays.fill(vis, true);
//        for(int i=0;i<c+1;i++){
//            arr.add(new ArrayList<>());
//        }
//        for(int i=0;i<connections.length;i++){
//            arr.get(connections[i][0]).add(connections[i][1]);
//            arr.get(connections[i][1]).add(connections[i][0]);
//        }
//
//        for (int i = 0; i < queries.length; i++) {
//            if(queries[i][0]==2){
//                vis[i]=false;
//            }
//            else{
//                ans.add(findNext(arr, vis, queries[i][1]));
//            }
//        }
//        return ans.stream().mapToInt(Integer:: intValue).toArray();
//
//
//    }
//
//    public int findNext( ArrayList<ArrayList<Integer>> arr, boolean [] vis, int node){
//        Queue<Integer
//        return 0;
//    }
//
//    static class Pair{
//        int x;
//        int y;
//        public Pair(int x , int y){
//            this.x =x;
//            this.y =y;
//        }
//    }
//
//    static final int[] row ={-1,0,1,0};
//    static final int [] col = {0,1,0,-1};
//
//     boolean isValid(int x, int y, int ROW, int COL, int[][] vis){
//        return (x>=0 &&y>=0 && x <ROW && y< COL && vis[x][y]==1);
//    }
//
//
//    public int findCircleNum(int[][] isConnected) {
//        int ans=0;
//        for(int i=0;i<isConnected.length;i++){
//            for(int j=0;j<isConnected.length;j++){
//                if(isConnected[i][j]==1){
//                    ans++;
//                    bfs(isConnected,i,j);
//                }
//            }
//        }
//        return ans;
//
//    }
//
//    public void bfs(int[][] gph , int x , int y){
//        int ROW = gph.length;
//        int COL = gph[0].length;
//        Queue<Pair> q = new LinkedList<>();
//
//        q.offer(new Pair(x, y));
//        q.offer(new Pair(y, x));
//        gph[x][y]=2;
//        gph[y][x]=2;
//
//        while(!q.isEmpty()){
//            Pair pr = q.poll();
//            int prx = pr.x;
//            int pry =pr.y;
//            for(int i=0;i<4;i++){
//                if(isValid(prx+ row[i], pry+ col[i], ROW, COL, gph)){
//                    System.out.println((prx+ row[i]) + "    " +(pry+ col[i]));
//                    System.out.println( (pry+ col[i]) + "     " +(prx+ row[i]) );
//                    gph[prx+ row[i]][pry+ col[i]]=2;
//                    gph[prx+ col[i]][pry+ row[i]]=2;
//                    q.offer(new Pair(prx+ row[i], pry+ col[i]));
//                    q.offer(new Pair(pry+ col[i],prx+ row[i]));
//                }
//            }
//        }
//    }
//
//
//
//
//
//
//    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        boolean [] vis = new boolean[rooms.size()];
//        dfs(0,rooms,vis);
//        for(int i=0;i<vis.length;i++){
//            if (!vis[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void dfs(int curr , List<List<Integer>> rooms, boolean[] vis){
//        if(vis[curr])
//            return ;
//        vis[curr]=true;
//        for(int n : rooms.get(curr)){
//            if(!vis[n]){
//                dfs(curr, rooms, vis);
//            }
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public int minCost(String s, int[] neededTime) {
//        int ans =0;
//        for(int i=0;i<s.length();i++){
//            int maxi=neededTime[i];
//            int local=neededTime[i];
//            while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
//                local+=neededTime[i+1];
//                maxi = Math.max(maxi,neededTime[i+1]);
//                i++;
//            }
//
//            ans+= (local-maxi);
//        }
//        return ans;
//    }
//
//    public int minCost1(String s, int[] neededTime) {
//        int ans =0;
//        for(int i=0;i<s.length()-1;i++){
//          if(s.charAt(i)==s.charAt(i+1)){
//            ans+=Math.min(neededTime[i], neededTime[i+1]);
//            neededTime[i+1]=Math.max(neededTime[i], neededTime[i+1]);
//          }
//        }
//        return ans;
//    }
//
//    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
//
//
//        return 0;
//    }
//
//    public static void main(String[] args) {
//
//    }
//    boolean yes =false;
//    public boolean validPath(int n, int[][] edges, int source, int destination){
//        ArrayList<ArrayList<Integer>> gph = new ArrayList<>();
//       boolean [] vis = new boolean[n];
//        for(int i=0;i<n;i++){
//            gph.add(new ArrayList<>());
//        }
//        for(int i=0;i<edges.length;i++){
//            gph.get(edges[i][0]).add(edges[i][1]);
//            gph.get(edges[i][1]).add(edges[i][0]);
//        }
//
//        dfs(source, destination,gph,vis);
//        return yes;
//
//    }
//
//    public void dfs(int curr, int destination, ArrayList<ArrayList<Integer>> graph, boolean [] vis  ){
//        vis[curr]=true;
//        if(curr == destination)
//            yes=true;
//        for(int node: graph.get(curr)){
//            if(!vis[node]){
//                dfs(node,destination,graph,vis);
//            }
//        }
//    }
//}
