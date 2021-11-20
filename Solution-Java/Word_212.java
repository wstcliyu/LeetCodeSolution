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
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return;
        }
        char c = board[i][j];
        if (board[i][j] == '#' || root.next[board[i][j] - 'a'] == null) {
            return;
        }
        root = root.next[c - 'a'];
        sb.append(c);
        board[i][j] = '#';
        if (root.isEnd) {
            res.add(sb.toString());
            root.isEnd = false; // avoid duplicate by removing word from dictionary
        }
        for (int[] d : dirs) {
            dfs(board, i + d[0], j + d[1], res, root, sb);
        }
        sb.deleteCharAt(sb.length() - 1); // corresponding to sb.append(c)
        board[i][j] = c; // corresponding to board[i][j] = '#'
    }
    
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, res, root, new StringBuilder());
            }
        }
        return res;
    }
}