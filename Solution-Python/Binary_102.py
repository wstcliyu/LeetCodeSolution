from collections import deque

class Solution:
    # Iteration
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        res = []
        q = deque([root])
        while q:
            layer = []
            for i in range(len(q)):
                node = q.popleft()
                layer.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(layer)
        return res



    # Recursion. Similar with 107.
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        res = []
        self.levelMaker(res, root, 0)
        return res
    
    def levelMaker(self, res: List[List[int]], root: TreeNode, depth: int):
        if depth >= len(res):
            res.append([])
        res[depth].append(root.val)
        if root.left:
            self.levelMaker(res, root.left, depth + 1)
        if root.right:
            self.levelMaker(res, root.right, depth + 1)