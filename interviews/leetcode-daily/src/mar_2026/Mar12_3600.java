package mar_2026;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/maximize-spanning-tree-stability-with-upgrades/?envType=daily-question&envId=2026-03-10
//Solution URL -> https://www.youtube.com/watch?v=BZ-dn_2oupQ
public class Mar12_3600 {

    // Approach - (Binary Search + DSU)
    // T.C : O(nlog(maxStability - minStability))
    // S.C : O(n+e), n = number of nodes, e = number of edges

    //DSU Path Traversal and Minimum 
    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);

            if (xParent == yParent) {
                return false;
            }

            if (rank[xParent] > rank[yParent]) {
                parent[yParent] = xParent;
            } else if (rank[xParent] < rank[yParent]) {
                parent[xParent] = yParent;
            } else {
                parent[xParent] = yParent;
                rank[yParent]++;
            }

            return true;
        }
    }

    class Solution {

        private boolean check(int n, int[][] edges, int k, int mid) {
            DSU dsu = new DSU(n);

            List<int[]> upgradeCandidates = new ArrayList<>();

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int s = edge[2];
                int m = edge[3];

                //If the Mandatory edge weight/Strength is less we cant form MST here
                if (m == 1) {
                    if (s < mid) {
                        return false;
                    }
                    dsu.union(u, v);
                } else {
                    //If Its greater then we cna take this node withoiut wasting K
                    if (s >= mid) {
                        dsu.union(u, v);
                    } else if (2 * s >= mid) { //Otherwise we might take this if we reduce k
                        upgradeCandidates.add(new int[] { u, v });
                    }
                }
            }

            for (int[] edge : upgradeCandidates) {
                int u = edge[0];
                int v = edge[1];

                //FInding if its having a common parent no MST , if not then We cna take this
                //As well this will ensure once a node is connected we cna anyways reach and no cycle
                if (dsu.find(u) != dsu.find(v)) {
                    if (k <= 0) {
                        return false;
                    }
                    dsu.union(u, v);
                    k--;
                }
            }

            int root = dsu.find(0);

            for (int node = 1; node < n; node++) {
                if (dsu.find(node) != root) {
                    return false;
                }
            }

            return true;
        }

        public int maxStability(int n, int[][] edges, int k) {

            DSU dsu = new DSU(n);

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int m = edge[3];

                //Checking For Cycle for DSU , if cycle return -1;
                //Taking this edge as we have to Take this mandatory
                if (m == 1) {
                    if (dsu.find(u) == dsu.find(v)) {
                        return -1;
                    }
                    dsu.union(u, v);
                }
            }

            int result = -1;
            int l = 1;
            int r = (int) 2e5;

            //Binary Search on Answer Range
            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (check(n, edges, k, mid)) {
                    result = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            return result;
        }
    }

}
