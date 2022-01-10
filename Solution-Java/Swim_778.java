// Approach #1: Heap
// Time Complexity: O(N^2 logN). We may expand O(N^2) nodes, and each one requires O(logN) time to perform the heap operations.
// Space Complexity: O(N^2), the maximum size of the heap.
class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        Set<Integer> seen = new HashSet();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((k1, k2) ->
                grid[k1 / N][k1 % N] - grid[k2 / N][k2 % N]);
        pq.offer(0);
        int ans = 0;

        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int k = pq.poll();
            int r = k / N, c = k % N;
            ans = Math.max(ans, grid[r][c]);
            if (r == N-1 && c == N-1) return ans;

            for (int i = 0; i < 4; ++i) {
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * N + cc;
                if (0 <= cr && cr < N && 0 <= cc && cc < N && !seen.contains(ck)) {
                    pq.offer(ck);
                    seen.add(ck);
                }
            }
        }

        throw null;
    }
}




// Approach #2: Binary Search and DFS
// Time Complexity: O(N^2 log N). Our depth-first search during a call to possible is O(N^2), and we make up to O(logN) of them.
// Space Complexity: O(N^2), the maximum size of the stack.
class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int lo = grid[0][0], hi = N * N;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!possible(mi, grid)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    public boolean possible(int T, int[][] grid) {
        int N = grid.length;
        Set<Integer> seen = new HashSet();
        seen.add(0);
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        Stack<Integer> stack = new Stack();
        stack.add(0);

        while (!stack.empty()) {
            int k = stack.pop();
            int r = k / N, c = k % N;
            if (r == N-1 && c == N-1) return true;

            for (int i = 0; i < 4; ++i) {
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * N + cc;
                if (0 <= cr && cr < N && 0 <= cc && cc < N
                        && !seen.contains(ck) && grid[cr][cc] <= T) {
                    stack.add(ck);
                    seen.add(ck);
                }
            }
        }

        return false;
    }
}




// Approach #3: Minimal Spanning Tree Algorithm (Union-Find)
// Time Complexity: O(N^2 log N^2)
// Space Complexity: O(N^2). We use some auxiliary data structures that are proportional to the size of the grid, i.e. N^2
class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        # find the representative of the set
        def parent(x):
            while root[x]!=x:
                root[x]=root[root[x]]
                x=root[x]
            return x

        def union(x,y):
            px=parent(x)
            py=parent(y)
            if px!=py:
                if size[px]>size[py]:
                    px,py=py,px
                size[py]+=size[px]
                root[px]=py

        n=len(grid)
        size=[1]*(n*n)
        root=list(range(n*n))
        vis=[[False]*n for _ in range(n)]
        positions=sorted([(i,j) for i in range(n) for j in range(n)],key=lambda x:grid[x[0]][x[1]])

        for i,j in positions:
            vis[i][j]=True
            # explore the neighbors to grow the disjoint sets
            for x,y in (i+1,j),(i-1,j),(i,j-1),(i,j+1):
                if 0<=x<n and 0<=y<n and vis[x][y]:
                    union(i*n+j,x*n+y)

            # the start and end points are joined together
            if parent(0)==parent(n*n-1):
                return grid[i][j]