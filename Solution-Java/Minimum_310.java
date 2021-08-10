class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        init(n, edges);
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            for (int i = leaves.size(); i > 0; i--) {
                int leaf = leaves.removeFirst();
                for (int neighbor : graph.get(leaf)) {
                    graph.get(neighbor).remove(leaf);
                    if (graph.get(neighbor).size() == 1) {
                        leaves.add(neighbor);
                    }
                }
            }
        }
        return leaves;
    }
    
    private void init(int n, int[][] edges) {
        remainingNodes = n;
        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
            graph.computeIfAbsent(e[1], k -> new HashSet<>()).add(e[0]);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) leaves.add(entry.getKey());
        }
        System.out.println(leaves.toString());
    }
    
    private LinkedList<Integer> leaves = new LinkedList<>();
    private HashMap<Integer, Set<Integer>> graph = new HashMap<>();
    private int remainingNodes;
}