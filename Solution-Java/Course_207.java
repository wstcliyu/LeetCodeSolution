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
        for (int i = 0; !isCycle && i < numCourses; i++) {
            if (colors[i] == Color.WHITE) dfs(i);
        }
        return !isCycle;
    }
    
    private void dfs(int start) {
        if (isCycle) return;
        colors[start] = Color.GRAY;
        if (graph.containsKey(start)) {
            for (int neighbor : graph.get(start)) {
                if (colors[neighbor] == Color.WHITE) {
                    dfs(neighbor);
                } else if (colors[neighbor] == Color.GRAY) {
                    isCycle = true;
                    return;
                }
            }
        }
        colors[start] = Color.BLACK;
    }
    
    private void init(int numCourses, int[][] prerequisites) {
        colors = new Color[numCourses];
        Arrays.fill(colors, Color.WHITE);
        graph = new HashMap<>();
        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }
        isCycle = false;
    }
    
    private Color[] colors;
    private HashMap<Integer, List<Integer>> graph;
    private boolean isCycle;
    
    enum Color {
        WHITE,
        GRAY,
        BLACK
    }  
}