class Solution {
    public boolean isCompleteTree(TreeNode root) {
        // Cannot use ArrayDeque because it throws NPE when adding null value
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean end = false;
        while (!q.isEmpty()) {
            TreeNode node = q.removeFirst();
            if (node == null) {
                end = true;
            } else {
                if (end) return false;
                q.add(node.left);
                q.add(node.right);
            }
        }
        return true;
    }
}