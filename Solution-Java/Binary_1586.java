class BSTIterator {
    
    private Stack<TreeNode> stack;
    private List<Integer> visited;
    private int pointer;
    
    private void pushAllLeftDescendantsInStack(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        visited = new ArrayList<>();
        pointer = -1;
        pushAllLeftDescendantsInStack(root);
    }
    
    public boolean hasNext() {
       return pointer < visited.size() - 1 || !stack.isEmpty(); 
    }
    
    public int next() {
        ++pointer;
        if (pointer == visited.size()) {
            TreeNode node = stack.pop();
            pushAllLeftDescendantsInStack(node.right);
            visited.add(node.val);
        }
        return visited.get(pointer);
    }
    
    public boolean hasPrev() {
        return pointer > 0;
    }
    
    public int prev() {
        return visited.get(--pointer);
    }
    
}