// TreeMap App
class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}




// Brute Force
class MyCalendar {
    int[] st;
    int[] ed;
    int bookCount;

    public MyCalendar_729() {
        st = new int[1000];
        ed = new int[1000];
        bookCount = 0;
    }

    public boolean book(int start, int end) {
        for (int i = 0; i < bookCount; i++) {
            if (end > st[i] && start < ed[i])
                return false;
        }
        st[bookCount] = start;
        ed[bookCount++] = end;
        return true;
    }
}




// Binary Search Tree
class MyCalendar {
    
    class TreeNode {
        TreeNode left, right;
        int start, end;
        
        TreeNode() {}
        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    private TreeNode root;

    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        if (root == null) {
            root = new TreeNode(start, end);
            return true;
        }
        return check(root, start, end);
    }
    
    private boolean check(TreeNode node, int start, int end) {
        if (end <= node.start) {
            if (node.left == null) {
                node.left = new TreeNode(start, end);
                return true;
            } else {
                return check(node.left, start, end);
            }
        }
        
        if (start >= node.end) {
            if (node.right == null) {
                node.right = new TreeNode(start, end);
                return true;
            } else {
                return check(node.right, start, end);
            }
        }
        
        return false;
    }
}