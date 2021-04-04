class MyCircularQueue {
    
    private int[] q;
    private int cap, size;
    private int start, end;

    public MyCircularQueue(int k) {
        q = new int[k];
        cap = k;
        size = 0;
        start = 0;
        end = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        q[end] = value;
        end = (end + 1) % cap;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        start = (start + 1) % cap;
        size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return q[start];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return q[(end + cap - 1) % cap];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == cap;
    }
}