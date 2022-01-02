// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/discuss/1612105/3-Steps
// 1. Build directions for both start and destination from the root. Say we get "LLRRL" and "LRR".
// 2. Remove common prefix path. We remove "L", and now start direction is "LRRL", and destination - "RR"
// 3. Replace all steps in the start direction to "U" and add destination direction. The result is "UUUU" + "RR".

// I rewrite this most voted solution as follows
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String s = findPath(root, startValue, new StringBuilder());
        String d = findPath(root, destValue, new StringBuilder());
        int i = 0;
        while (i < Math.min(s.length(), d.length()) && s.charAt(i) == d.charAt(i)) {
            i++;
        }
        return "U".repeat(s.length() - i) + d.substring(i);
    }
    
    private String findPath(TreeNode root, int value, StringBuilder sb) {
        if (root == null) return null;
        if (root.val == value) return sb.toString();
        int len = sb.length();
        
        sb.append("L");
        String l = findPath(root.left, value, sb);
        sb.deleteCharAt(len);
        
        sb.append("R");
        String r = findPath(root.right, value, sb);
        sb.deleteCharAt(len);
        
        return l == null ? r : l;
    }
}