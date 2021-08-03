class WordDictionary {
    
    class TrieNode {
        private TrieNode[] next = new TrieNode[26];
        private boolean isEnd = false;
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    private boolean search(String word, int start, TrieNode node) {
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.next[j] != null && search(word, i + 1, node.next[j])) {
                        return true;
                    }
                }
                return false;
            } else if (node.next[c - 'a'] == null) {
                return false;
            } else {
                node = node.next[c - 'a'];
            }
        }
        return node.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */