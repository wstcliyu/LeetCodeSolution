from collections import deque

class Solution:
    # Iteration #1
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res, stack = deque(), []
        node = root
        while stack or node:
            if node:
                res.appendleft(node.val)
                stack.append(node)
                node = node.right
            else:
                node = stack.pop().left
        return res



    # Iteration #2
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        res, stack = deque(), [root]
        while stack:
            node = stack.pop()
            res.appendleft(node.val)
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        return res