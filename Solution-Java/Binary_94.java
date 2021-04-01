class Binary_94 {
    // Using Stack
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }



    // Morris Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                res.add(node.val);
                node = node.right;
            } else {
                TreeNode pred = node.left;
                while (pred.right != null && pred.right != node) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = node;
                    node = node.left;
                } else {
                    pred.right = null;
                    res.add(node.val);
                    node = node.right;
                }
            }
        }
        return res;
    }
}