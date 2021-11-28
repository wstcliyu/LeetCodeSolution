// Refer to Lowest_236 most voted solution (because the nodes are guaranteed in the tree)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null) return null;
        for (TreeNode node : nodes) {
            if (root == node) return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, nodes);
        TreeNode r = lowestCommonAncestor(root.right, nodes);
        if (l != null && r != null) return root;
        return l == null ? r : l;
    }
}




// Refer to Lowest_236
class Solution {
    private TreeNode lca = null;
    private Set<TreeNode> set = new HashSet<>();
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        for (TreeNode node : nodes) {
            set.add(node);
        }
        helper(root);
        return lca;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int m = set.contains(root) ? 1 : 0;
        int sum = l + r + m;
        if (lca == null && sum == set.size()) lca = root;
        return sum;
    }
}