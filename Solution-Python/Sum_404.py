# This problem can be solved recursively or iteratively, level-order, pre-order, post-order, in-order(Morris)
class Solution:
    # Judge if the left child of each node is a left leaf
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        if not root:
            return 0
        if root.left and not root.left.left and not root.left.right:
            return root.left.val + self.sumOfLeftLeaves(root.right)
        return self.sumOfLeftLeaves(root.left) + self.sumOfLeftLeaves(root.right)



    # Judge if each node is a left leaf
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        return self.preorder(root, False)
        
    def preorder(self, root: TreeNode, isLeftChild: bool) -> int:
        if not root:
            return 0
        rootVal = 0
        if isLeftChild and not root.left and not root.right:
            rootVal = root.val
        return rootVal + self.preorder(root.left, True) + self.preorder(root.right, False)