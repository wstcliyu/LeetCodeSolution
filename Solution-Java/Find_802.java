// Reverse Topological Sort - BFS
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        init(graph);
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.removeFirst();
            res.add(node);
            if (adj.containsKey(node)) {
                for (int neighbor : adj.get(node)) {
                    if (--outDegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }
        Collections.sort(res);
        return res;
    }
    
    private void init(int[][] graph) {
        n = graph.length;
        outDegree = new int[n];
        for (int i = 0; i < n; i++) {
            outDegree[i] = graph[i].length;
            for (int j : graph[i]) {
                adj.computeIfAbsent(j, k -> new HashSet<>()).add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) q.add(i);
        }
    }
    
    private int n;
    private HashMap<Integer, Set<Integer>> adj = new HashMap<>();
    private int[] outDegree;
    private LinkedList<Integer> q = new LinkedList<>();
}




// DFS
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        init(graph);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i)) res.add(i);
        }
        return res;
    }
    
    boolean dfs(int start) {
        if (colors[start] != Color.WHITE) {
            return colors[start] == Color.BLACK;
        }
        colors[start] = Color.GRAY;
        for (int neighbor : graph[start]) {
            if (colors[neighbor] == Color.GRAY || colors[neighbor] == Color.WHITE && !dfs(neighbor)) return false;
        }
        colors[start] = Color.BLACK;
        return true;
    }
    
    private void init(int[][] graph) {
        colors = new Color[graph.length];
        Arrays.fill(colors, Color.WHITE);
        this.graph = graph;
    }
    
    private Color[] colors;
    private int[][] graph;
    
    enum Color {
        WHITE,
        GRAY,
        BLACK
    }
}