// Topological Sort - BFS
class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        init(n, relations);
        int res = 0;
        int count = 0;
        while (!q.isEmpty()) {
            count += q.size();
            res++;
            for (int i = q.size(); i > 0; i--) {
                int node = q.removeFirst();
                for (int j = 1; j <= n; j++) {
                    if (graph[node][j] && --inDegree[j] == 0) {
                        q.add(j);
                    }
                }
            }
        }
        return count == n ? res : -1;
    }
    
    private void init(int n, int[][] relations) {
        graph = new boolean[n + 1][n + 1];
        inDegree = new int[n + 1];
        q = new ArrayDeque<>();
        for (int[] r : relations) {
            graph[r[0]][r[1]] = true;
            inDegree[r[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
    }
    
    private boolean[][] graph;
    private int[] inDegree;
    private Deque<Integer> q;
}




// DFS: detect cycle + find longest path
class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        init(n, relations);
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dfs(i, n));
        }
        return isCycle ? -1 : res;
    }
    
    private void init(int n, int[][] relations) {
        graph = new boolean[n + 1][n + 1];
        heights = new int[n + 1];
        for (int[] r : relations) {
            graph[r[0]][r[1]] = true;
        }
    }
    
    private int dfs(int start, int n) {
        if (isCycle) return -1;
        if (heights[start] != 0) return heights[start];
        heights[start] = -1;
        int height = 1;
        for (int i = 1; i <= n; i++) {
            if (!graph[start][i]) continue;
            int childHeight = dfs(i, n);
            if (childHeight == -1) {
                isCycle = true;
                return -1;
            }
            height = Math.max(height, childHeight + 1);
        }
        heights[start] = height;
        return height;
    }
    
    private boolean[][] graph;
    private int[] heights;
    private boolean isCycle = false;
    private int res = 0;
}