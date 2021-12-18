// Approach 1: Annotate Parent + BFS
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        annotateParent(parents, root, null);
        LinkedList<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        for (int i = 0; i < k; i++) {
            for (int j = q.size(); j > 0; j--) {
                TreeNode node = q.removeFirst();
                TreeNode parent = parents.get(node);
                if (parent != null && visited.add(parent)) q.add(parent);
                if (node.left != null && visited.add(node.left)) q.add(node.left);
                if (node.right != null && visited.add(node.right)) q.add(node.right);
            }
        }
        return q.stream().map(node -> node.val).collect(Collectors.toList());
    }
    
    private void annotateParent(HashMap<TreeNode, TreeNode> parents, TreeNode node, TreeNode parent) {
        parents.put(node, parent);
        if (node.left != null) annotateParent(parents, node.left, node);
        if (node.right != null) annotateParent(parents, node.right, node);
    }
}




// Approach 2: Percolate Distance (DFS)
class Solution {
    List<Integer> ans;
    TreeNode target;
    int K;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance: the number of edges on the path from node to target
    public int dfs(TreeNode node) {
        if (node == null)
            return -1;
        else if (node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int L = dfs(node.left), R = dfs(node.right);
            if (L != -1) {
                if (L == K) ans.add(node.val);
                if (L < K) subtree_add(node.right, L + 1);
                return L + 1;
            } else if (R != -1) {
                if (R == K) ans.add(node.val);
                if (R < K) subtree_add(node.left, R + 1);
                return R + 1;
            } else {
                return -1;
            }
        }
    }

    // Add all nodes 'K - dist' from the node to answer.
    public void subtree_add(TreeNode node, int dist) {
        if (node == null) return;
        if (dist == K)
            ans.add(node.val);
        else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }
}