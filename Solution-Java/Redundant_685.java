// https://leetcode.com/problems/redundant-connection-ii/discuss/278105/topic
// There are 2 cases (the above link concludes 3 cases):
// 1. There exists a directed cycle: removing any edge in the directed cycle makes a tree, so we return the last edge which causes cycle
// 2. A node has 2 parents: The 2 edges are the candidates, so we ignore the 2nd edge and see if there exists an undirected cycle.

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        int[] can1 = null;
        int[] can2 = null;
        int[] lastEdgeCauseCycle = null;
        int[] parent = new int[n + 1];
        for (int[] e : edges) {
            if (parent[e[1]] == 0) {
                parent[e[1]] = e[0];
                if (!uf.union(e[0], e[1])) {
                    lastEdgeCauseCycle = e;
                }
            } else {
                // Found a node with 2 parents, so we try to ignore the 2nd edge by not connecting e[0], e[1]
                can1 = new int[]{parent[e[1]], e[1]};
                can2 = e;
            }
        }
        if (can1 != null && can2 != null) {
            // Case 2 (A node has 2 parents)
            // Since we ignored 2nd edge, it is the correct edge to remove if no cycle is detected
            return lastEdgeCauseCycle == null ? can2 : can1;
        } else {
            // Case 1 (There exists a directed cycle)
            return lastEdgeCauseCycle;
        }
    }
    
    class UnionFind {
        private int[] root, weight;
        
        UnionFind(int n) {
            root = new int[n + 1];
            weight = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                root[i] = i;
                weight[i] = 1;
            }
        }
        
        int find(int x) {
            if (root[x] != x)
                root[x] = find(root[x]);
            return root[x];
        }
        
        boolean union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx == ry) {
                return false;
            }
            if (weight[rx] < weight[ry]) {
                root[rx] = ry;
                weight[ry] += weight[rx];
            } else {
                root[ry] = rx;
                weight[rx] += weight[ry];
            }
            return true;
        }
    }
}