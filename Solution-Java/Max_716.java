// Approach #2: Double Linked List + TreeMap
class MaxStack {
    
    class Node {
        int val;
        Node prev, next;
        Node(int val) {
            this.val = val;
        }
    }
    
    class DoubleLinkedList {
        Node head, tail;
        
        DoubleLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }
        
        Node add(int x) {
            Node node = new Node(x);
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            return node;
        }
        
        Node remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }
    
    private DoubleLinkedList dll;
    private TreeMap<Integer, ArrayDeque<Node>> map;

    public MaxStack() {
        dll = new DoubleLinkedList();
        map = new TreeMap<>();
    }
    
    public void push(int x) {
        Node node = dll.add(x);
        map.computeIfAbsent(x, k -> new ArrayDeque<>()).add(node);
    }
    
    public int pop() {
        Node node = dll.remove(dll.tail.prev);
        return removeFromMap(node.val).val;
    }
    
    public int top() {
        return dll.tail.prev.val;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int max = map.lastKey();
        dll.remove(removeFromMap(max));
        return max;
    }
    
    private Node removeFromMap(int val) {
        ArrayDeque<Node> q = map.get(val);
        Node node = q.removeLast();
        if (q.isEmpty()) {
            map.remove(val);
        }
        return node;
    }
}




// Approach #1: Two Stacks
class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack();
        maxStack = new Stack();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}