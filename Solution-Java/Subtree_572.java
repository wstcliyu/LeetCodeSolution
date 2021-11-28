// Construct String
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return toString(root).contains(toString(subRoot));
    }
    
    private String toString(TreeNode root) {
        if (root == null) return "X";
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(root.val).append(",").append(toString(root.left)).append(toString(root.right)).append(")");
        return sb.toString();
    }
}




// Post-order
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return subRoot == null;
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2 == null;
        return t2 != null && t1.val == t2.val && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }
    
    // private boolean isSame(TreeNode t1, TreeNode t2) {
    //     if (t1 == null && t2 == null) return true;
    //     if (t1 == null || t2 == null) return false;
    //     return t1.val == t2.val && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    // }
}