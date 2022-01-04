// My solution
class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int getFood(char[][] grid) {
        int[] start = findStart(grid);
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(start);
        grid[start[0]][start[1]] = 'X';
        int step = 0;
        while (!q.isEmpty()) {
            step++;
            for (int i = q.size(); i > 0; i--) {
                start = q.removeFirst();
                for (int[] d : dirs) {
                    int x = start[0] + d[0];
                    int y = start[1] + d[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != 'X') {
                        if (grid[x][y] == '#') {
                            return step;
                        }
                        grid[x][y] = 'X';
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        return -1;
    }
    
    private int[] findStart(char[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException();
    }
}