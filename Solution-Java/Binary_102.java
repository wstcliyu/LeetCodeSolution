class Binary_102 {
    // Iteration
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.removeFirst();
                layer.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(layer);
        }
        return res;
    }



    // Recursion. Similar with 107.
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) list.add(new LinkedList<Integer>());
        list.get(level).add(root.val);
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        // list.get(level).add(root.val);
        // Either pre-order or post-order is OK here.
    }
}