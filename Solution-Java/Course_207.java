// Topological Sort (BFS)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
            inDegree[p[0]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int p = q.removeFirst();
            count++;
            if (graph.containsKey(p)) {
                for (int c : graph.get(p)) {
                    if (--inDegree[c] == 0) {
                        q.add(c);
                    }
                }
            }
        }
        return count == numCourses;
    }
}




// Topological Sort (DFS)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        init(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == WHITE) dfs(i);
        }
        return !isCycle;
    }
    
    private void dfs(int start) {
        if (isCycle) return;
        color[start] = GRAY;
        if (graph.containsKey(start)) {
            for (int neighbor : graph.get(start)) {
                if (color[neighbor] == WHITE) {
                    dfs(neighbor);
                } else if (color[neighbor] == GRAY) {
                    isCycle = true;
                    return;
                }
            }
        }
        color[start] = BLACK;
    }
    
    private void init(int numCourses, int[][] prerequisites) {
        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }
        color = new int[numCourses];
        Arrays.fill(color, WHITE);
    }
    
    private HashMap<Integer, List<Integer>> graph = new HashMap<>();
    private boolean isCycle = false;
    private int[] color;
    private static final int WHITE = 1;
    private static final int GRAY = 2;
    private static final int BLACK = 3;
}