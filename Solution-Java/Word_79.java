class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, 0, word, i, j)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int start, String word, int i, int j) {
        if (start == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(start)) return false;
        board[i][j] = '#';
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (dfs(board, start + 1, word, x, y)) return true;
        }
        board[i][j] = word.charAt(start);
        return false;
    }
}