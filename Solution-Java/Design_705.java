// BST as Bucket 
// Time: O(log(N/K))
// where N is the number of all possible values and K is the number of predefined buckets, which is 769.
// Assuming that the values are evenly distributed, we could consider that the average size of bucket is N/K
// Space: O(K+M) where K is the number of predefined buckets, and M is the number of unique values that have been inserted into the HashSet.
class MyHashSet {
    
    private BSTree[] bstArray;
    private int keyRange;

    public MyHashSet() {
        keyRange = 769;
        bstArray = new BSTree[keyRange];
        for (int i = 0; i < keyRange; i++) {
            bstArray[i] = new BSTree();
        }
    }
    
    protected int _hash(int key) {
        return (key % keyRange);
    }
    
    public void add(int key) {
        int bucketIndex = _hash(key);
        bstArray[bucketIndex].insert(key);
    }
    
    public void remove(int key) {
        int bucketIndex = _hash(key);
        bstArray[bucketIndex].delete(key);
    }
    
    public boolean contains(int key) {
        int bucketIndex = _hash(key);
        return bstArray[bucketIndex].exists(key);
    }
}

class BSTree {
    TreeNode root;
    
    public void insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
            return;
        }
        TreeNode parent = null;
        TreeNode node = root;
        boolean leftChild = false;
        while (node != null) {
            parent = node;
            if (key < node.val) {
                node = node.left;
                leftChild = true;
            } else if (key > node.val) {
                node = node.right;
                leftChild = false;
            } else {
                return;
            }
        }
        if (leftChild) {
            parent.left = new TreeNode(key);
        } else {
            parent.right = new TreeNode(key);
        }
    }
    
    private int successorValueInRightChild(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
    
    private int predecessorValueInLeftChild(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
    
    private TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = successorValueInRightChild(root);
                root.right = delete(root.right, root.val);
            } else {
                root.val = predecessorValueInLeftChild(root);
                root.left = delete(root.left, root.val);
            }
        }
        return root;
    }
    
    public void delete(int key) {
        root = delete(root, key);
    }
    
    public boolean exists(int key) {
        TreeNode node = root;
        while (node != null) {
            if (key < node.val) {
                node = node.left;
            } else if (key > node.val) {
                node = node.right;
            } else {
                return true;
            }
        }
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */




// LinkedList as Bucket
// Time: O(N/K)
// where N is the number of all possible values and K is the number of predefined buckets, which is 769.
// Assuming that the values are evenly distributed, we could consider that the average size of bucket is N/K
// Space: O(K+M) where K is the number of predefined buckets, and M is the number of unique values that have been inserted into the HashSet.
class MyHashSet {
  private Bucket[] bucketArray;
  private int keyRange;

  /** Initialize your data structure here. */
  public MyHashSet() {
    this.keyRange = 769;
    this.bucketArray = new Bucket[this.keyRange];
    for (int i = 0; i < this.keyRange; ++i)
      this.bucketArray[i] = new Bucket();
  }

  protected int _hash(int key) {
    return (key % this.keyRange);
  }

  public void add(int key) {
    int bucketIndex = this._hash(key);
    this.bucketArray[bucketIndex].insert(key);
  }

  public void remove(int key) {
    int bucketIndex = this._hash(key);
    this.bucketArray[bucketIndex].delete(key);
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int bucketIndex = this._hash(key);
    return this.bucketArray[bucketIndex].exists(key);
  }
}


class Bucket {
  private LinkedList<Integer> container;

  public Bucket() {
    container = new LinkedList<Integer>();
  }

  public void insert(Integer key) {
    int index = this.container.indexOf(key);
    if (index == -1) {
      this.container.addFirst(key);
    }
  }

  public void delete(Integer key) {
    this.container.remove(key);
  }

  public boolean exists(Integer key) {
    int index = this.container.indexOf(key);
    return (index != -1);
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */




// 2D Array
class MyHashSet {
    
    private boolean[][] table;
    private int m = 1001, n = 1000;

    public MyHashSet() {
        table = new boolean[m][n];
    }
    
    public void add(int key) {
        table[key % m][key / m] = true;
    }
    
    public void remove(int key) {
        table[key % m][key / m] = false;
    }
    
    public boolean contains(int key) {
        return table[key % m][key / m];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */