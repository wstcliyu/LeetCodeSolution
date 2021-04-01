class Solution:
    # Using Stack
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res, stack, node = [], [], root
        while stack or node:
            if node:
                stack.append(node)
                node = node.left
            else:
                node = stack.pop()
                res.append(node.val)
                node = node.right
        return res



    # Morris Traversal
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res, node = [], root
        while node:
            if node.left:
                pred = node.left
                while pred.right and pred.right != node:
                    pred = pred.right
                if pred.right:
                    pred.right = None
                    res.append(node.val)
                    node = node.right
                else:
                    pred.right = node
                    node = node.left
            else:
                res.append(node.val)
                node = node.right
        return res