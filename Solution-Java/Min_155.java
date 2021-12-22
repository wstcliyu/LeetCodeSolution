// https://leetcode.com/problems/min-stack/discuss/49031/Share-my-Java-solution-with-ONLY-ONE-stack
class MinStack {
	long min;
    Stack<Long> stack;
    public MinStack(){
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);//Could be negative if min value needs to change
            if (x < min) min = x;
        }
    }
    public void pop() {
        if (stack.isEmpty()) return;
        
        long pop = stack.pop();
        
        if (pop < 0)  min = min - pop;//If negative, increase the min value
        
    }
    public int top() {
        long top = stack.peek();
        if (top > 0){
            return (int)(top + min);
        } else {
           return (int)(min);
        }
    }
    public int getMin() {
        return (int)min;
    }
}




// Approach 1: Stack of Value/ Minimum Pairs
class MinStack {
    
    private Stack<int[]> stack = new Stack<>();
    
    public MinStack() { }
    
    
    public void push(int x) {
        
        /* If the stack is empty, then the min value
         * must just be the first value we add. */
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
            return;
        }
        
        int currentMin = stack.peek()[1];
        stack.push(new int[]{x, Math.min(x, currentMin)});
    }
    
    
    public void pop() {
        stack.pop();
    }
    
    
    public int top() {
        return stack.peek()[0];
    }
    
    
    public int getMin() {
        return stack.peek()[1];
    }
}




// Approach 2: Two Stacks
class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    
    
    public MinStack() { }
    
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    
    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    
    public int top() {
        return stack.peek();
    }

    
    public int getMin() {
        return minStack.peek();
    }
}




// Approach 3: Improved Two Stacks
class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<int[]> minStack = new Stack<>();
    
    
    public MinStack() { }
    
    
    public void push(int x) {
        
        // We always put the number onto the main stack.
        stack.push(x);
        
        // If the min stack is empty, or this number is smaller than
        // the top of the min stack, put it on with a count of 1.
        if (minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.push(new int[]{x, 1});
        }
        
        // Else if this number is equal to what's currently at the top
        // of the min stack, then increment the count at the top by 1.
        else if (x == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
    }
    
    
    public void pop() {
        
        // If the top of min stack is the same as the top of stack
        // then we need to decrement the count at the top by 1.
        if (stack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
        }
        
        // If the count at the top of min stack is now 0, then remove
        // that value as we're done with it.
        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }
        
        // And like before, pop the top of the main stack.
        stack.pop();
    }
    
    
    public int top() {
        return stack.peek();
    }

    
    public int getMin() {
        return minStack.peek()[0];
    }
}