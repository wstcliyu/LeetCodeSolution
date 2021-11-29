class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, 0, word, i, j)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int idx, String word, int i, int j) {
        if (idx == word.length() - 1) return true;
        board[i][j] = '#';
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length 
                && board[x][y] == word.charAt(idx + 1) && dfs(board, idx + 1, word, x, y)) {
                return true;
            }
        }
        board[i][j] = word.charAt(idx);
        return false;
    }
}