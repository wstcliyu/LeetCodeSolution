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




// Rewrite DFS
class Solution {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private State[] states;
    private int[] heights;
    
    enum State {
        UNVISITED,
        VISITING,
        VISITED
    }
    
    private void init(int n, int[][] relations) {
        states = new State[n + 1];
        Arrays.fill(states, State.UNVISITED);
        heights = new int[n + 1];
        Arrays.fill(heights, 1);
        for (int[] r : relations) {
            graph.computeIfAbsent(r[0], k -> new ArrayList<>()).add(r[1]);
        }
    }
    
    private int dfs(int i) {
        if (states[i] == State.VISITING) {
            heights[i] = -1;
            return -1;
        } else if (states[i] == State.UNVISITED) {
            states[i] = State.VISITING;
            int height = 1;
            if (graph.containsKey(i)) {
                for (int neighbor : graph.get(i)) {
                    int neighborHeight = dfs(neighbor);
                    if (neighborHeight == -1) {
                        heights[i] = -1;
                        return -1;
                    } else {
                        heights[i] = Math.max(heights[i], 1 + neighborHeight);
                    }
                }
            }
        }
        states[i] = State.VISITED;
        return heights[i];
    }
    
    public int minimumSemesters(int n, int[][] relations) {
        init(n, relations);
        int res = 1;
        for (int i = 1; i <= n; i++) {
            int height = dfs(i);
            if (height == -1) return -1;
            res = Math.max(res, height);
        }
        return res;
    }
}