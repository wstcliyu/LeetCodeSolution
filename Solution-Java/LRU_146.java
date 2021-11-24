class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        
        Node() {}
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private HashMap<Integer, Node> map;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            insertAtTail(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        insertAtTail(new Node(key, value));
        if (map.size() > capacity) {
            removeNode(head.next);             
        }
    }
    
    private void insertAtTail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        map.put(node.key, node);
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */