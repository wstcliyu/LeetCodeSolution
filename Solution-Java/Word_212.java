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
    
    private void dfs(char[][] board, TrieNode root, List<String> res, StringBuilder sb, int i, int j) {
        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null) {
            return;
        }
        board[i][j] = '#';
        sb.append(c);
        root = root.next[c - 'a'];
        if (root.isEnd) {
            res.add(sb.toString());
            root.isEnd = false; // avoid duplicate by removing word from dictionary
        }
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                dfs(board, root, res, sb, x, y);
            }
        }
        board[i][j] = c;
        sb.deleteCharAt(sb.length() - 1);
    }
    
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, res, new StringBuilder(), i, j);
            }
        }
        return res;
    }
}