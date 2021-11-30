// Union Find
// Time: O(Na(N))~O(N)
// Space: O(N)
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] e : edges) {
            if (!uf.union(e[0], e[1])) {
                return e;
            }
        }
        return null;
    }
    
    class UnionFind {
        int[] root, weight;
        
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