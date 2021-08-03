class TrieNode:
    def __init__(self):
        self.next = dict()
        self.is_end = False

class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        node = self.root
        for c in word:
            if not node.next.get(c):
                node.next[c] = TrieNode()
            node = node.next[c]
        node.is_end = True

    def search(self, word: str) -> bool:
        return self.search_helper(word, 0, self.root)
        
    def search_helper(self, word: str, start: int, node: TrieNode) -> bool:
        for i in range(start, len(word)):
            c = word[i]
            if c == '.':
                for j in string.ascii_lowercase:
                    if node.next.get(j) and self.search_helper(word, i + 1, node.next[j]):
                        return True
                return False
            elif not node.next.get(c):
                return False
            else:
                node = node.next[c]
        return node.is_end


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)