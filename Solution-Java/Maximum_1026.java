// Max minus Min
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, 100_000, 0);
    }
    
    private int maxAncestorDiff(TreeNode root, int min, int max) {
        if (root == null) return max - min;
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        return Math.max(maxAncestorDiff(root.left, min, max), maxAncestorDiff(root.right, min, max));
    }
}




// Compare distance between the node and the max/min ancestor
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }
    
    private int helper(TreeNode root, int min, int max) {
        if (root == null) return 0;
        int dif = Math.max(Math.abs(root.val - max), Math.abs(root.val - min));
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        dif = Math.max(dif, helper(root.left, min, max));
        dif = Math.max(dif, helper(root.right, min, max));
        return dif;
    }
}