// Iterative Method Using stack
class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (visited.contains(node)) {
                stack.pop();
                sb.append(")");
            } else {
                visited.add(node);
                sb.append("(" + node.val);
                if (node.left == null && node.right != null)
                    sb.append("()");
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
        }
        return sb.substring(1, sb.length() - 1);
    }
}




// Using Recursion
class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null) return String.valueOf(t.val);
        if (t.right == null) return t.val + "(" + tree2str(t.left) + ")";
        else return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }
}




// My solution (Recursion) using StringBuilder, faster than just using String
// Complexity same as the above solution Using Recursion
class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        return sb.toString();
    }
    private void helper(TreeNode t, StringBuilder sb) {
        if(t == null)
            return;
        if(t.left == null && t.right == null)
            sb.append(t.val);
        else if(t.right == null) {
            sb.append(t.val + "(");
            helper(t.left, sb);
            sb.append(")");
        }
        else {
            sb.append(t.val + "(");
            helper(t.left, sb);
            sb.append(")(");
            helper(t.right, sb);
            sb.append(")");
        }
    }
}