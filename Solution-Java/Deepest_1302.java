// My solution using recursion
class Solution {
    class Result {
        int depth, sum;
        Result(int depth, int sum) {
            this.depth = depth;
            this.sum = sum;
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        return helper(0, root).sum;
    }
    
    private Result helper(int depth, TreeNode root) {
        if (root == null) return new Result(0, 0);
        if (root.left == null && root.right == null) return new Result(depth, root.val);
        Result l = helper(depth + 1, root.left);
        Result r = helper(depth + 1, root.right);
        if (l.depth == r.depth) return new Result(l.depth, l.sum + r.sum);
        return l.depth > r.depth ? l : r;
    }
}




// Iterative DFS Preorder Traversal
class Solution {
  public int deepestLeavesSum(TreeNode root) {
    int deepestSum = 0, depth = 0, currDepth;
    Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
    stack.push(new Pair(root, 0));

    while (!stack.isEmpty()) {
      Pair<TreeNode, Integer> p = stack.pop();
      root = p.getKey();
      currDepth = p.getValue();

      if (root.left == null && root.right == null) {
        // if this leaf is the deepest one seen so far
        if (depth < currDepth) {
          deepestSum = root.val;      // start new sum
          depth = currDepth;          // note new depth    
        } else if (depth == currDepth) {
          // if there were already leaves at this depth
          deepestSum += root.val;     // update existing sum    
        }
      } else {
        if (root.right != null) {
          stack.push(new Pair(root.right, currDepth + 1));
        }
        if (root.left != null) {
          stack.push(new Pair(root.left, currDepth + 1));
        }
      }
    }
    return deepestSum;
  }
}




// Optimized Iterative BFS Traversal
class Solution {
  public int deepestLeavesSum(TreeNode root) {
    ArrayDeque<TreeNode>  nextLevel = new ArrayDeque(),
                          currLevel = new ArrayDeque();
    nextLevel.offer(root);

    while (!nextLevel.isEmpty()) {
      // prepare for the next level
      currLevel = nextLevel.clone();
      nextLevel.clear();

      for (TreeNode node: currLevel) {
        // add child nodes of the current level
        // in the queue for the next level
        if (node.left != null) {
          nextLevel.offer(node.left);
        }
        if (node.right != null) {
          nextLevel.offer(node.right);
        }
      }
    }
    int deepestSum = 0;
    for (TreeNode node: currLevel) {
      deepestSum += node.val;
    }
    return deepestSum;
  }
}