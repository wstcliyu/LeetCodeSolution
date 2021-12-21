// Pre-order. Top-down.
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        return (min == null || min < root.val) && (max == null || max > root.val)
        && isValidBST(root.left, min, root.val) 
        && isValidBST(root.right, root.val, max);
    }
}




// Post-order. Bottom-up.
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root).isValidBST;
    }
    
    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(true, null, null);
        }
        Result l = dfs(root.left);
        Result r = dfs(root.right);
        boolean isValidBST = l.isValidBST && r.isValidBST 
            && (l.max == null || l.max < root.val) 
            && (r.min == null || r.min > root.val);
        int min = l.min == null ? root.val : l.min;
        int max = r.max == null ? root.val : r.max;
        return new Result(isValidBST, min, max);
    }
    
    class Result {
        boolean isValidBST;
        Integer min, max;
        Result(boolean isValidBST, Integer min, Integer max) {
            this.isValidBST = isValidBST;
            this.min = min;
            this.max = max;
        }
    }
}