// One ArrayList
class BrowserHistory {
    
    List<String> urls = new ArrayList<>();
    int idx, bound;

    public BrowserHistory(String homepage) {
        urls.add(homepage);
        idx = 0;
        bound = 0;
    }
    
    public void visit(String url) {
        if (idx == bound && bound == urls.size() - 1) {
            urls.add(url);
        } else {
            urls.set(idx + 1, url);
        }
        idx++;
        bound = idx;
    }
    
    public String back(int steps) {
        idx -= Math.min(steps, idx);
        return urls.get(idx);
    }
    
    public String forward(int steps) {
        idx += Math.min(steps, bound - idx);
        return urls.get(idx);
    }
}




// Two Stacks
class BrowserHistory {
    
    Stack<String> history = new Stack<>();
    Stack<String> future = new Stack<>();

    public BrowserHistory(String homepage) {
        history.push(homepage);
    }
    
    public void visit(String url) {
        future.clear();
        history.push(url);
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps && history.size() > 1; i++) {
            future.push(history.pop());
        }
        return history.peek();
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps && !future.isEmpty(); i++) {
            history.push(future.pop());
        }
        return history.peek();
    }
}




// Doubly Linked List
class BrowserHistory {
    class Node {
        String url;
        Node prev, next;
        Node(String url) {
            this.url = url;
        }
    }
    
    Node head, p;

    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        p = head;
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        p.next = node;
        node.prev = p;
        p = node;
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps && p.prev != null; i++) {
            p = p.prev;
        }
        return p.url;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps && p.next != null; i++) {
            p = p.next;
        }
        return p.url;
    }
}


/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */