// Second voted solution using DFS and BFS (I prefer this solution)
class Solution {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> q = new LinkedList<>();
        boolean found = false;

        for (int i = 0; i < m && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (A[i][j] == 1) {
                    dfs(A, visited, q, i, j);
                    found = true;
                }
            }
        }

        for (int step = 0; !q.isEmpty(); step++) {
            for (int k = q.size(); k > 0; k--) {
                int[] c = q.removeFirst();
                for (int[] d : dirs) {
                    int i = c[0] + d[0], j = c[1] + d[1];
                    if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
                        if (A[i][j] == 1) return step;
                        visited[i][j] = true;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        
        return -1;
    }

    private void dfs(int[][] A, boolean[][] visited, Queue<int[]> q, int i, int j) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j] || A[i][j] == 0) return;
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        for (int[] dir : dirs)
            dfs(A, visited, q, i + dir[0], j + dir[1], dirs);
    }
}




// https://leetcode.com/problems/shortest-bridge/discuss/189293/C%2B%2B-BFS-Island-Expansion-%2B-UF-Bonus
// Most voted solution using DFS and BFS
// DFS to paint one group of grid to color 2
// Returns true if a grid with value 1 is found and then DFS to finish painting color 2
class Solution {
    boolean paint(int[][] A, int i, int j) {
        if (i < 0 || j < 0 || i == A.length || j == A.length || A[i][j] != 1) return false;
        A[i][j] = 2;
        paint(A, i, j + 1);
        paint(A, i, j - 1);
        paint(A, i + 1, j);
        paint(A, i - 1, j);
        return true;
    }

    // BFS to expand
    boolean expand(int[][] A, int i, int j, int cl) {
        if (i < 0 || j < 0 || i == A.length || j == A.length) return false;
        if (A[i][j] == 0) A[i][j] = cl + 1;
        return A[i][j] == 1;
    }

    int shortestBridge(int[][] A) {
        boolean found = false;
        for (int i = 0; !found && i < A.length; ++i)
            for (int j = 0; !found && j < A[0].length; ++j) found = paint(A, i, j);

        for (int cl = 2; ; ++cl) for (int i = 0; i < A.length; ++i) for (int j = 0; j < A.length; ++j)
            if (A[i][j] == cl && ((expand(A, i - 1, j, cl) || expand(A, i, j - 1, cl) ||
                expand(A, i + 1, j, cl) || expand(A, i, j + 1, cl))))
                    return cl - 2;
    }
}