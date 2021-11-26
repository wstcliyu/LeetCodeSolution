class MyHashMap {
    class Bucket {
        ListNode head = new ListNode(-1, -1);
    }

    class ListNode {
        int key, val;
        ListNode next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int idx(int key) {
        return Integer.hashCode(key) % buckets.length;
    }

    private ListNode find(Bucket bucket, int key) {
        ListNode node = bucket.head;
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    Bucket[] buckets;

    public Design_706() {
        buckets = new Bucket[6789];
    }

    public void put(int key, int value) {
        int i = idx(key);
        if (buckets[i] == null)
            buckets[i] = new Bucket();
        ListNode prev = find(buckets[i], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else
            prev.next.val = value;
    }

    public int get(int key) {
        int i = idx(key);
        if (buckets[i] == null)
            return -1;
        ListNode prev = find(buckets[i], key);
        if (prev.next == null)
            return -1;
        else
            return prev.next.val;
    }

    public void remove(int key) {
        int i = idx(key);
        if (buckets[i] == null)
            return;
        ListNode prev = find(buckets[i], key);
        if (prev.next == null)
            return;
        else
            prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */