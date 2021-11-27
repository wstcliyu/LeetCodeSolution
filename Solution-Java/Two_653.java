// Using DFS and HashSet
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}




// Using BFS and HashSet
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        Queue < TreeNode > queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }
}




// Using BST
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List < Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}




// Time Complexity: O(nh), Space Complexity: O(h). h is the height of the tree, which is logn at best case, and n at worst case.
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root,  k);
    }
    
    public boolean dfs(TreeNode root,  TreeNode cur, int k){
        if(cur == null) return false;
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }
    
    public boolean search(TreeNode root, TreeNode cur, int value){
        if(root == null) return false;
        return (root.val == value) && (root != cur) 
            || (root.val < value) && search(root.right, cur, value) 
            || (root.val > value) && search(root.left, cur, value);
    }
}