class Inorder_285 {
    // Second voted solution using iteration
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (root.val <= p.val)
                root = root.right;
            else {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }


    // Most voted solution using recursion
    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }


    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }


    
    // My solution
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode parentSucc = null;
        while (p.val != root.val) {
            if (p.val < root.val) {
                parentSucc = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (root.right == null) {
            return parentSucc;
        }
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}