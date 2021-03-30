class Solution:
	# Iteration #1
	def preorderTraversal(self, root: TreeNode) -> List[int]:
        res, stack = [], []
        node = root
        while stack or node:
            if node:
                res.append(node.val)
                stack.append(node)
                node = node.left
            else:
                node = stack.pop().right
        return res




	# Iteration #2
    def preorderTraversal(self, root: TreeNode) -> List[int]:
    	if not root:
            return []
        res, stack = [], []
        stack.append(root)
        while stack:
        	node = stack.pop()
        	res.append(node.val)
        	if node.right:
        		stack.append(node.right)
        	if node.left:
        		stack.append(node.left)
        return res
