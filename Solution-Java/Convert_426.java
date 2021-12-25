// In-order recursion
class Solution {
  // the smallest (first) and the largest (last) nodes
  Node first = null;
  Node last = null;

  public void helper(Node node) {
    if (node != null) {
      // left
      helper(node.left);
      // node 
      if (last != null) {
        // link the previous node (last)
        // with the current one (node)
        last.right = node;
        node.left = last;
      }
      else {
        // keep the smallest node
        // to close DLL later on
        first = node;
      }
      last = node;
      // right
      helper(node.right);
    }
  }

  public Node treeToDoublyList(Node root) {
    if (root == null) return null;

    helper(root);
    // close DLL
    last.right = first;
    first.left = last;
    return first;
  }
}




// Morris traversal
class Solution {
    Node first, last;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        while (root != null) {
            if (root.left == null) {
                visit(root);
                root = root.right;
            } else {
                Node pred = root.left;
                while (pred.right != null && pred.right != root) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = root;
                    root = root.left;
                } else {
                    pred.right = null;
                    visit(root);
                    root = root.right;
                }
            }
        }
        last.right = first;
        first.left = last;
        return first;
    }
    
    private void visit(Node node) {
        if (last != null) {
            last.right = node;
            node.left = last;
        } else {
            first = node;
        }
        last = node;
    }
}