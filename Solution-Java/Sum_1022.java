class Solution {
    // My latest solution using recursion
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int preSum) {
        if (root == null) return 0;
        preSum = preSum * 2 + root.val;
        if (root.left == null && root.right == null) {
            return preSum;
        }
        return helper(root.left, preSum) + helper(root.right, preSum);
    }




    // My first solution using recursion
    // Alternative solution in my mind: level-order traversal (BFS)
    int sum;
    
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode node, int prefix) {
        prefix = (prefix << 1) + node.val;
        if (node.left == null && node.right == null)
            sum += prefix;
        if (node.left != null)
            dfs(node.left, prefix);
        if (node.right != null)
            dfs(node.right, prefix);
    }




    // My first solution using iterative pre-order traversal
    public int sumRootToLeaf(TreeNode root) {
        int sum = 0;
        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(root, 0));
        while (!deque.isEmpty()) {
            Pair<TreeNode, Integer> pair = deque.removeLast();
            TreeNode node = pair.getKey();
            int prefix = (pair.getValue() << 1) + node.val;
            if (node.left == null && node.right == null)
                sum += prefix;
            if (node.right != null)
                deque.add(new Pair<>(node.right, prefix));
            if (node.left != null)
                deque.add(new Pair<>(node.left, prefix));
        }
        return sum;
    }
}




// Solution using Morris in-order traversal
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        int rootToLeaf = 0, currNumber = 0;
        int steps;
        TreeNode predecessor;

        while (root != null) {
            // If there is a left child,
            // then compute the predecessor.
            // If there is no link predecessor.right = root --> set it.
            // If there is a link predecessor.right = root --> break it.
            if (root.left != null) {
                // Predecessor node is one step to the left
                // and then to the right till you can.
                predecessor = root.left;
                steps = 1;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                    ++steps;
                }

                // Set link predecessor.right = root
                // and go to explore the left subtree
                if (predecessor.right == null) {
                    currNumber = (currNumber << 1) | root.val;
                    predecessor.right = root;
                    root = root.left;
                }
                // Break the link predecessor.right = root
                // Once the link is broken,
                // it's time to change subtree and go to the right
                else {
                    // If you're on the leaf, update the sum
                    if (predecessor.left == null) {
                        rootToLeaf += currNumber;
                    }
                    // This part of tree is explored, backtrack
                    for(int i = 0; i < steps; ++i) {
                        currNumber >>= 1;
                    }
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // If there is no left child
            // then just go right.
            else {
                currNumber = (currNumber << 1) | root.val;
                // if you're on the leaf, update the sum
                if (root.right == null) {
                    rootToLeaf += currNumber;
                }
                root = root.right;
            }
        }
        return rootToLeaf;
    }
}