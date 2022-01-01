// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/discuss/274621/JavaC%2B%2BPython-Iterative-Stack-Solution
// Most voted solution from lee215
class Solution {
	public TreeNode recoverFromPreorder(String S) {
        int level, val;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < S.length();) {
            for (level = 0; S.charAt(i) == '-'; i++) {
                level++;
            }
            for (val = 0; i < S.length() && S.charAt(i) != '-'; i++) {
                val = val * 10 + (S.charAt(i) - '0');
            }
            while (stack.size() > level) {
                stack.pop();
            }
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.add(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }
}




// My solution
class Solution {
	public TreeNode recoverFromPreorder(String S) {
        TreeNode dummy = new TreeNode(0);
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.addLast(new Pair<>(dummy, -1));
        int depth = 0, value = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-')
                depth++;
            else {
                value = value * 10 + S.charAt(i) - '0';
                if (i == S.length() - 1 || S.charAt(i + 1) == '-') {
                    TreeNode child = new TreeNode(value);
                    if (depth > stack.getLast().getValue())
                        stack.getLast().getKey().left = child;
                    else {
                        while (depth <= stack.getLast().getValue())
                            stack.removeLast();
                        stack.removeLast().getKey().right = child;
                    }
                    stack.addLast(new Pair<>(child, depth));
                    depth = 0;
                    value = 0;
                }
            }
        }
        
        return dummy.left;
    }
}