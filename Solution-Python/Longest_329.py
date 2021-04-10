class Solution:
    # DFS + Memoization
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        self.m, self.n = len(matrix), len(matrix[0])
        cache = [[0]*self.n for i in range(self.m)]
        ans = 0
        for i in range(self.m):
            for j in range(self.n):
                ans = max(ans, self.dfs(matrix, i, j, cache))
        return ans
    
    def dfs(self, matrix: List[List[int]], i: int, j: int, cache: List[List[int]]) -> int:
        if cache[i][j] > 0:
            return cache[i][j]
        for d in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
            x, y = i + d[0], j + d[1]
            if x >= 0 and y >= 0 and x < self.m and y < self.n and matrix[x][y] > matrix[i][j]:
                cache[i][j] = max(cache[i][j], self.dfs(matrix, x, y, cache))
        cache[i][j] += 1
        return cache[i][j]



    # Topological Sort
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        inDegree = [[0]*n for i in range(m)]
        for i in range(m):
            for j in range(n):
                for d in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    x, y = i + d[0], j + d[1]
                    if x >= 0 and y >= 0 and x < m and y < n and matrix[x][y] > matrix[i][j]:
                        inDegree[x][y] += 1
        q = deque()
        for i in range(m):
            for j in range(n):
                if inDegree[i][j] == 0:
                    q.append((i, j))
        ans = 0
        while q:
            ans += 1
            for k in range(len(q)):
                i, j = q.popleft()
                for d in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    x, y = i + d[0], j + d[1]
                    if x >= 0 and y >= 0 and x < m and y < n and matrix[x][y] > matrix[i][j]:
                        inDegree[x][y] -= 1
                        if inDegree[x][y] == 0:
                            q.append((x, y))
        return ans