public class Increasing_897 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // This problem should refer to in-order traversal
    // Refer to Binary_94




    // In-Order Traversal
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }




    // Traversal with Relinking
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }




    // Morris inorder traversal
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        TreeNode prev = dummy;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                prev.right = curr;
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = curr;
                    prev = curr;
                    curr.left = null;
                    curr = curr.right;
                }
            }
        }
        return dummy.right;
    }




    // Iteration using stack
    public TreeNode increasingBST(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode dummy = new TreeNode(0), p = dummy;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                root = cur.right;
                cur.left = null;
                p.right = cur;
                p = p.right;
            }
        }
        return dummy.right;
    }




    // Most voted solution using recursion
    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }
    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }




    // My solution
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        return helper(root)[0];
    }
    
    private TreeNode[] helper(TreeNode root) {
        TreeNode[] res = new TreeNode[2];
        if (root.left == null) {
            res[0] = root;
        } else {
            TreeNode[] leftRes = helper(root.left);
            res[0] = leftRes[0];
            leftRes[1].right = root;
            root.left = null;
        }
        if (root.right == null) {
            res[1] = root;
        } else {
            TreeNode[] rightRes = helper(root.right);
            res[1] = rightRes[1];
            root.right = rightRes[0];
        }
        return res;
    }
}