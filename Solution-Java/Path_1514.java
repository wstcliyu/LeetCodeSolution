// https://leetcode.com/problems/path-with-maximum-probability/discuss/731767/JavaPython-3-2-codes%3A-Bellman-Ford-and-Dijkstra's-algorithm-w-brief-explanation-and-analysis.

// Dijkstra
// 1. Initialize all vertices probabilities as 0, except start, which is 1;
// 2. Put all currently reachable vertices into a Priority Queue/heap, priority ordered by the corresponding current probability, REVERSELY;
// 3. Whenever popped out a vertex with currently highest probability, check if it is the end vertex; If yes, we have already found the solution; otherwise, traverse all its neighbors to update neighbors' probabilities if necessary; Note: when forwarding one step, multiply the corresponding succProb value with the probaboility of current vertex.
// 4. Repeat 2 & 3 to find the max probability for end; If can NOT, return 0.0d.
// Time: O((n + E) * logE), space: O(n + E), where E = edges.length.
class Solution {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0], b = edges[i][1];
            g.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, i});    
            g.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});    
        }
        double[] p = new double[n];
        p[start] = 1d;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> -p[i]));
        pq.offer(start);
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur == end) {
                return p[end];
            }
            for (int[] a : g.getOrDefault(cur, Collections.emptyList())) {
                int neighbor = a[0], index = a[1];
                if (p[cur] * succProb[index] > p[neighbor]) {
                    p[neighbor] = p[cur] * succProb[index];
                    pq.offer(neighbor);
                }
            }
        }
        return 0d;
    }
}




// Bellman Ford
// 1. Initialize all vertices probabilities as 0, except start, which is 1;
// 2. Use BFS to traverse all reachable vertices from start, update the corresponding probilities whenever we can have a higher probability; otherwise, ignore that vertex; Note: when forwarding one step, multiply the corresponding succProb value with the probaboility of current vertex;
// 3. Repeat 2 till all probabilities reach their maximum values.
// 4. Return the probability of end as solution.
// Time: O(n * E), space: O(n + E), where E = edges.length.
class Solution {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0], b = edges[i][1];
            g.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, i});
            g.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});
        }
        double[] p = new double[n];
        p[start] = 1d;
        Queue<Integer> q = new LinkedList<>(Arrays.asList(start));
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] a : g.getOrDefault(cur, Collections.emptyList())) {
                int neighbor = a[0], index = a[1];
                if (p[cur] * succProb[index] > p[neighbor]) {
                    p[neighbor] = p[cur] * succProb[index];
                    q.offer(neighbor);
                }
            }
        }
        return p[end];
    }
}
