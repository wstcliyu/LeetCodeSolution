class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isEnd = false;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isEnd = true;
        }
        return root;
    }
    
    private void dfs(char[][] board, int i, int j, List<String> res, TrieNode root, StringBuilder sb) {
        char c = board[i][j];
        board[i][j] = '#';
        sb.append(c);
        root = root.next[c - 'a'];
        if (root.isEnd) {
            res.add(sb.toString());
            root.isEnd = false;
        }
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length 
                && board[x][y] != '#' && root.next[board[x][y] - 'a'] != null) {
                dfs(board, i + d[0], j + d[1], res, root, sb);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        board[i][j] = c;
    }
    
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '#' && root.next[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, res, root, new StringBuilder());
                }
            }
        }
        return res;
    }
}