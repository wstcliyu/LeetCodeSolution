// Refer to Lowest_236
// The most voted solution of Lowest_236 because this question is a little different that p and q are not guaranteed in the tree
class Solution {
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }
    
    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int l = helper(root.left, p, q) ? 1 : 0;
        int r = helper(root.right, p, q) ? 1 : 0;
        int m = (root == p || root == q) ? 1 : 0;
        int sum = l + r + m;
        if (sum == 2) res = root;
        return sum > 0;
    }
}