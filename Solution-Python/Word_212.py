class TrieNode:
    def __init__(self):
        self.next = dict()
        self.is_end = False

class Solution:
    def build_trie(self, words: List[str]) -> TrieNode:
        root = TrieNode()
        for word in words:
            node = root
            for c in word:
                if not node.next.get(c):
                    node.next[c] = TrieNode()
                node = node.next[c]
            node.is_end = True
        return root
    
    def dfs(self, board: List[List[str]], root: TrieNode, res: List[str], sb: str, i: int, j: int):
        c = board[i][j]
        if c == '#' or not root.next.get(c):
            return
        board[i][j] = '#'
        sb += c
        root = root.next[c]
        if root.is_end:
            res.append(sb)
            root.is_end = False # avoid duplicate by removing word from dictionary
        for d in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            x, y = d[0] + i, d[1] + j
            if x >= 0 and y >= 0 and x < len(board) and y < len(board[0]):
                self.dfs(board, root, res, sb, x, y)
        board[i][j] = c
        
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = self.build_trie(words)
        res = []
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(board, root, res, "", i, j)
        return res