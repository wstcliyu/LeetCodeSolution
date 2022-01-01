// Recursion
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;       
    }
}




// Iteration
// https://leetcode.com/problems/trim-a-binary-search-tree/discuss/107026/Java-solution-iteration-version
class Solution {
	public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }

        //Find a valid root which is used to return.
        while (root.val < L || root.val > R) {
            if (root.val < L) {
                root = root.right;
            }
            if (root.val > R) {
                root = root.left;
            }
        }

        TreeNode node = root;

        // Remove the invalid nodes from left subtree.
        while (node != null) {
            while (node.left != null && node.left.val < L) {
                node.left = node.left.right; 
                // If the left child is smaller than L, then we just keep the right subtree of it. 
            }
            node = node.left;
        }

        node = root;

        // Remove the invalid nodes from right subtree
        while (node != null) {
            while (node.right != null && node.right.val > R) {
                node.right = node.right.left;
                // If the right child is biggrt than R, then we just keep the left subtree of it. 
            }
            node = node.right;
        }

        return root;
    }
}