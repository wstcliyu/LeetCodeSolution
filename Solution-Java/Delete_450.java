/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */




// Recursion
class Solution {
  /*
  One step right and then always left
  */
  public int successor(TreeNode root) {
    root = root.right;
    while (root.left != null) root = root.left;
    return root.val;
  }

  /*
  One step left and then always right
  */
  public int predecessor(TreeNode root) {
    root = root.left;
    while (root.right != null) root = root.right;
    return root.val;
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;

    // delete from the right subtree
    if (key > root.val) root.right = deleteNode(root.right, key);
    // delete from the left subtree
    else if (key < root.val) root.left = deleteNode(root.left, key);
    // delete the current node
    else {
      // the node is a leaf
      if (root.left == null && root.right == null) root = null;
      // the node is not a leaf and has a right child
      else if (root.right != null) {
        root.val = successor(root);
        root.right = deleteNode(root.right, root.val);
      }
      // the node is not a leaf, has no right child, and has a left child    
      else {
        root.val = predecessor(root);
        root.left = deleteNode(root.left, root.val);
      }
    }
    return root;
  }
}




// Rewrite method on CLRS
class Solution {
    private void transplant(TreeNode oldNode, TreeNode newNode, TreeNode parentNode) {
        if (parentNode.left == oldNode) {
            parentNode.left = newNode;
        } else {
            parentNode.right = newNode;
        }
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = new TreeNode(0);
        parent.left = root;
        TreeNode node = root;
        while (node != null && node.val != key) {
            parent = node;
            if (key < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (node == null) {
            return root;
        }
        if (node.left == null) {
            transplant(node, node.right, parent);
        } else if (node.right == null) {
            transplant(node, node.left, parent);
        } else {
            TreeNode successor = node.right;
            if (successor.left != null) {
                TreeNode parentOfSuccessor = node;
                while (successor.left != null) {
                    parentOfSuccessor = successor;
                    successor = successor.left;
                }
                transplant(successor, successor.right, parentOfSuccessor);
                successor.right = node.right;
            }
            transplant(node, successor, parent);
            successor.left = node.left;
        }
        return node == root ? parent.left : root;
    }
    
}