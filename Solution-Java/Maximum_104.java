/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// My solution using post-order
// BFS or Pre-order DFS also work
class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root, 1);
    }
    
    private int helper(TreeNode root, int depth) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return depth;
        depth++;
        return Math.max(helper(root.left, depth), helper(root.right, depth));
    }
}