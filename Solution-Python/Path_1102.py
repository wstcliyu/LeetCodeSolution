# https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/416227/Python-Dijkstra-Binary-Search-%2B-DFS-Union-Find-complexity-analysis
# Similar with Swim_778




# Dijkstra
class Solution:
    def maximumMinimumPath(self, A: List[List[int]]) -> int:
        dire = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        R, C = len(A), len(A[0])
        
        maxHeap = [(-A[0][0], 0, 0)]
        seen = [[0 for _ in range(C)] for _ in range(R)]
        while maxHeap:
            val, x, y = heapq.heappop(maxHeap)
            # seen[x][y] = 1 # got TLE
            if x == R - 1 and y == C - 1: return -val
            for dx, dy in dire:
                nx, ny = x + dx, y + dy
                if 0 <= nx < R and 0 <= ny < C and not seen[nx][ny]:
                    seen[nx][ny] = 1 # passed
                    heapq.heappush(maxHeap, (max(val, -A[nx][ny]), nx, ny))
        return -1




# Binary Search + DFS
class Solution:
    def maximumMinimumPath(self, A: List[List[int]]) -> int:
        dire = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        R, C = len(A), len(A[0])
        
        def check(val):
            memo = [[0 for _ in range(C)] for _ in range(R)]
            
            def dfs(x,y):
                if x == R - 1 and y == C - 1:
                    return True
                memo[x][y] = 1
                for d in dire:
                    nx = x + d[0]
                    ny = y + d[1]
                    if 0 <= nx < R and 0 <= ny < C and not memo[nx][ny] and A[nx][ny] >= val and dfs(nx,ny):
                        return True
                return False
            
            return dfs(0,0)   
        
        unique = set()
        ceiling = min(A[0][0], A[-1][-1])
        for r in range(R):
            for c in range(C):
                if A[r][c] <= ceiling:
                    unique.add(A[r][c])
                
        arr = sorted(unique)
        l, r = 0, len(arr) - 1
        while l <= r:
            m = l + (r - l) // 2
            # if check(m):
            if check(arr[m]):
                # cause we're trying to find the MAXIMUM of 'minimum'
                l = m + 1
            else:
                r = m - 1
        return arr[r]




# Union Find
class Solution:
    def maximumMinimumPath(self, A: List[List[int]]) -> int:
        R, C = len(A), len(A[0])
        parent = [i for i in range(R * C)]
        dire = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        seen = [[0 for _ in range(C)] for _ in range(R)]
        
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(x, y):
            rx, ry = find(x), find(y)
            if rx != ry:
                parent[ry] = rx
        
        points = [(x, y) for x in range(R) for y in range(C)]
        points.sort(key = lambda x: A[x[0]][x[1]], reverse = True)
        
        for x, y in points:
            seen[x][y] = 1
            for dx, dy in dire:
                nx, ny = x + dx, y + dy
                if 0 <= nx < R and 0 <= ny < C and seen[nx][ny]:
                    union(x * C + y, nx * C + ny)
            if find(0) == find(R * C - 1):
                return A[x][y]
        return -1