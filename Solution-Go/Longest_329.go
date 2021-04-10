// DFS + Memoization
func longestIncreasingPath(matrix [][]int) int {
    m, n := len(matrix), len(matrix[0])
    cache := make([][]int, m)
    for i := 0; i < m; i++ {
        cache[i] = make([]int, n)
    }
    ans := 0
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            tmp := dfs(matrix, i, j, cache)
            if ans < tmp {
                ans = tmp
            }
        }
    }
    return ans
}

func dfs(matrix [][]int, i int, j int, cache [][]int) int {
    if cache[i][j] > 0 {
        return cache[i][j]
    }
    // dirs := [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}
    for _, d := range [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}} {
        x, y := i + d[0], j + d[1]
        if x >= 0 && y >= 0 && x < len(matrix) && y < len(matrix[0]) && matrix[x][y] > matrix[i][j] {
            if tmp := dfs(matrix, x, y, cache); cache[i][j] < tmp {
                cache[i][j] = tmp
            }
        }
    }
    cache[i][j]++
    return cache[i][j]
}



// Topological Sort
func longestIncreasingPath(matrix [][]int) int {
    dirs := [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}
    m, n := len(matrix), len(matrix[0])
    inDegree := make([][]int, m)
    for i := 0; i < m; i++ {
        inDegree[i] = make([]int, n)
    }
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            for _, d := range dirs {
                x, y := i + d[0], j + d[1]
                if x >= 0 && y >= 0 && x < len(matrix) && y < len(matrix[0]) && matrix[x][y] > matrix[i][j] {
                    inDegree[x][y]++
                }
            }
        }
    }
    q := [][]int{}
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if inDegree[i][j] == 0 {
                q = append(q, []int{i, j})
            }
        }
    }
    ans := 0
    for len(q) > 0 {
        ans++
        for k := len(q); k > 0; k-- {
            node := q[0]
            q = q[1:]
            for _, d := range dirs {
                x, y := node[0] + d[0], node[1] + d[1]
                if x >= 0 && y >= 0 && x < len(matrix) && y < len(matrix[0]) && matrix[x][y] > matrix[node[0]][node[1]] {
                    if inDegree[x][y]--; inDegree[x][y] == 0 {
                        q = append(q, []int{x, y})
                    }
                }
            }
        }
    }
    return ans
}