// My Union Find template
// Space complexity : O(m * n) as required by UnionFind data structure.
// Time complexity : O(m * n + L) where L is the number of operations, m is the number of rows and n is the number of columns.
// it takes O(m * n) to initialize UnionFind, and O(L) to process positions.
// Note that Union operation takes essentially (amortized O(log*(n)) approximately O(1)) constant time when UnionFind is implemented with both path compression and union by rank.
// https://en.wikipedia.org/wiki/Disjoint-set_data_structure

class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        for (int[] p : positions) {
            int c1 = n * p[0] + p[1];
            if (uf.add(c1)) {
                for (int[] d : dirs) {
                    int x = p[0] + d[0];
                    int y = p[1] + d[1];
                    int c2 = n * x + y;
                    if (x >= 0 && y >= 0 && x < m && y < n && uf.root[c2] != -1) {
                        uf.union(c1, c2);
                    }
                }
            }
            res.add(uf.count);
        }
        return res;
    }
    
    class UnionFind {
        int count;
        int[] root, weight;
        
        UnionFind(int N) {
            count = 0;
            weight = new int[N];
            root = new int[N];
            Arrays.fill(root, -1);
        }
        
        int find(int x) {
            if (root[x] != x)
                root[x] = find(root[x]);
            return root[x];
        }
        
        boolean union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx == ry) {
                return true;
            }
            if (weight[rx] < weight[ry]) {
                root[rx] = ry;
                weight[ry] += weight[rx];
            } else {
                root[ry] = rx;
                weight[rx] += weight[ry];
            }
            count--;
            return false;
        }
        
        boolean add(int x) {
            if (root[x] == -1) {
                root[x] = x;
                count++;
                return true;
            }
            return false;
        }
    }
}