// Third voted solution: Segment Tree with lazy propagation (general case of K-booking)
// https://leetcode.com/problems/my-calendar-ii/discuss/109528/nlogd-Java-solution-using-segment-tree-with-lazy-propagation-(for-the-general-case-of-K-booking)
class MyCalendarTwo {

	class SegmentTreeNode {
        int l, r;
        int k, lazy;
        SegmentTreeNode left, right;
        SegmentTreeNode(int l, int r, int k) {
            this.l = l;
            this.r = r;
            this.k = k;
            this.lazy = 0;
            this.left = this.right = null;
        }
    }

	SegmentTreeNode root;

    public MyCalendarTwo() {
        root = new SegmentTreeNode(0, 1_000_000_000, 0);
    }
    
    public boolean book(int start, int end) {
        if (query(root, start, end - 1) >= 2) return false;
        update(root, start, end - 1, 1);
        return true;
    }
    
    private int query(SegmentTreeNode node, int i, int j) {
        if (i > j || node == null || i > node.r || j < node.l) return 0;
        if (i <= node.l && j >= node.r) return node.k;
        normalize(node);
        return Math.max(query(node.left, i, j), query(node.right, i, j));
    }
    
    private void update(SegmentTreeNode node, int i, int j, int val) {
        if (i > j || node == null || i > node.r || j < node.l) return;
        if (i <= node.l && j >= node.r) {
            node.k += val;
            node.lazy += val;
            return;
        }
        normalize(node);
        update(node.left, i, j, val);
        update(node.right, i, j, val);
        node.k = Math.max(node.left.k, node.right.k);
    }
    
    private void normalize(SegmentTreeNode node) {
        if (node.l < node.r) {
            if (node.left == null || node.right == null) {
                int m = node.l + (node.r - node.l) / 2;
                node.left = new SegmentTreeNode(node.l, m, node.k);
                node.right = new SegmentTreeNode(m + 1, node.r, node.k);
            } else {
                node.left.k += node.lazy;
                node.left.lazy += node.lazy;
                node.right.k += node.lazy;
                node.right.lazy += node.lazy;
            }
        }
        node.lazy = 0;
    }
}




// Approach #2: Boundary Count
class MyCalendarTwo {
    TreeMap<Integer, Integer> delta;

    public MyCalendarTwo() {
        delta = new TreeMap();
    }

    public boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d: delta.values()) {
            active += d;
            if (active >= 3) {
                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);
                if (delta.get(start) == 0)
                    delta.remove(start);
                return false;
            }
        }
        return true;
    }
}




// Approach #1: Brute Force
public class MyCalendarTwo {
    List<int[]> calendar;
    List<int[]> overlaps;

    MyCalendarTwo() {
        overlaps = new ArrayList();
        calendar = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] iv: overlaps) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        for (int[] iv: calendar) {
            if (iv[0] < end && start < iv[1])
                overlaps.add(new int[]{Math.max(start, iv[0]), Math.min(end, iv[1])});
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}