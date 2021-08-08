// Topological Sort (BFS)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses, prerequisites);
        int[] order = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int node = q.removeFirst();
            order[idx++] = node;
            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    if (--inDegree[neighbor] == 0) q.add(neighbor);
                }
            }
        }
        return idx == numCourses ? order : new int[0];
    }
    
    private void init(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>();
        inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
            inDegree[p[0]]++;
        }
        q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.add(i);
        }
    }
    
    private HashMap<Integer, List<Integer>> graph;
    private int[] inDegree;
    private Deque<Integer> q;
}




// Topological Sort (DFS)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses, prerequisites);
        for (int i = 0; !isCycle && i < numCourses; i++) {
            if (colors[i] == Color.WHITE) dfs(i);
        }
        return idx == 0 ? order : new int[0];
        // return isCycle ? new int[0] : order;
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
        order[--idx] = start;
    }
    
    private void init(int numCourses, int[][] prerequisites) {
        colors = new Color[numCourses];
        Arrays.fill(colors, Color.WHITE);
        graph = new HashMap<>();
        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }
        order = new int[numCourses];
        idx = numCourses;
        isCycle = false;
    }
    
    private Color[] colors;
    private HashMap<Integer, List<Integer>> graph;
    private int[] order;
    private int idx;
    private boolean isCycle;
    
    enum Color {
        WHITE,
        GRAY,
        BLACK
    }    
}