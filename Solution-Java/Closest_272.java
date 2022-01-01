// https://leetcode.com/problems/closest-binary-search-tree-value-ii/discuss/70503/O(logN)-Java-Solution-with-two-stacks-following-hint
// Second voted solution
// Time: O(klgn), Space(lgn)
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        initPredStack(pred, root, target);
        initSuccStack(succ, root, target);
        // Pay attention here
        // If target equals a certain element in the BST, the top elements of these 2 stacks are equal
        // So we first need to call either getNextPred() or getNextSucc()
        if (!succ.isEmpty() && !pred.isEmpty() && succ.peek().val == pred.peek().val) {
            getNextPred(pred);
            // My mistake
            // res.add(getNextPred(pred));
            // succ.pop();
        }
        while (res.size() < k) {
            if (pred.isEmpty()) {
                res.add(getNextSucc(succ));
            } else if (succ.isEmpty()) {
                res.add(getNextPred(pred));
            } else {
                double pred_diff = Math.abs((double)pred.peek().val - target);
                double succ_diff = Math.abs((double)succ.peek().val - target);
                if (pred_diff < succ_diff) {
                    res.add(getNextPred(pred));
                } else {
                    res.add(getNextSucc(succ));
                }
            }
        }
        return res;
    }
    
    private void initPredStack(Stack<TreeNode> pred, TreeNode root, double target) {
        while (root != null) {
            if (root.val == target) {
                pred.push(root);
                return;
            } else if (root.val < target) {
                pred.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
    
    private void initSuccStack(Stack<TreeNode> succ, TreeNode root, double target) {
        while (root != null) {
            if (root.val == target) {
                succ.push(root);
                return;
            } else if (root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
    
    private int getNextPred(Stack<TreeNode> pred) {
        TreeNode node = pred.pop();
        int res = node.val;
        node = node.left;
        while (node != null) {
            pred.push(node);
            node = node.right;
        }
        return res;
    }
    
    private int getNextSucc(Stack<TreeNode> succ) {
        TreeNode node = succ.pop();
        int res = node.val;
        node = node.right;
        while (node != null) {
            succ.push(node);
            node = node.left;
        }
        return res;
    }
}




// https://leetcode.com/problems/closest-binary-search-tree-value-ii/discuss/70511/AC-clean-Java-solution-using-two-stacks
// Most voted solution
// The time complexity given by the author is incorrect
// Time: O(n), Space(n)
class Solution {
  	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList<>();

		Stack<Integer> s1 = new Stack<>(); // predecessors
		Stack<Integer> s2 = new Stack<>(); // successors

		inorder(root, target, false, s1);
		inorder(root, target, true, s2);

		while (k-- > 0) {
			if (s1.isEmpty())
				res.add(s2.pop());
			else if (s2.isEmpty())
				res.add(s1.pop());
			else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target))
				res.add(s1.pop());
			else
				res.add(s2.pop());
		}

		return res;
	}

	// inorder traversal
	void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
		if (root == null) return;

		inorder(reverse ? root.right : root.left, target, reverse, stack);
		// early terminate, no need to traverse the whole tree
		if ((reverse && root.val <= target) || (!reverse && root.val > target)) return;
		// track the value of current node
		stack.push(root.val);
		inorder(reverse ? root.left : root.right, target, reverse, stack);
	}		
}




// Approach 3: QuickSelect, O(N) time
class Solution {
    List<Integer> nums;
    double target;
    
    public void swap(int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }
    
    public void inorder(TreeNode r, List<Integer> nums) {
        if (r == null) 
            return;
                    
        inorder(r.left, nums);
        nums.add(r.val);
        inorder(r.right, nums);
    }

    public int partition(int left, int right, int pivotIndex) {
        double pivotDist = dist(pivotIndex);
        // 1. move pivot to end
        swap(pivotIndex, right);
        int storeIndex = left;

        // 2. move more close elements to the left
        for (int i = left; i <= right; i++) {
            if (dist(i) < pivotDist) {
                swap(storeIndex, i);
                storeIndex++;
            }
        }

        // 3. move pivot to its final place
        swap(storeIndex, right);

        return storeIndex;
    }
    
    public void quickselect(int left, int right, int kSmallest) {
        /*
        Sort a list within left..right till kth less close element
        takes its place. 
        */

        // base case: the list contains only one element
        if (left >= right) return;
        
        // select a random pivot_index
        Random randomNum = new Random();
        int pivotIndex = left + randomNum.nextInt(right - left); 

        // find the pivot position in a sorted list
        pivotIndex = partition(left, right, pivotIndex);

        // if the pivot is in its final sorted position
        if (kSmallest == pivotIndex) {
            return;    
        } else if (kSmallest < pivotIndex) {
            // go left
            quickselect(left, pivotIndex - 1, kSmallest);     
        } else {
            // go right 
            quickselect(pivotIndex + 1, right, kSmallest);  
        }
    }
    
    public double dist(int idx) {
        return Math.abs(nums.get(idx) - target);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        nums = new ArrayList();  
        this.target = target;
        inorder(root, nums);
        quickselect(0, nums.size() - 1, k);
        return nums.subList(0, k);
    }
}




// Approach 2: Recursive Inorder + Heap, O(N log k) time
class Solution {
    public void inorder(TreeNode r, List<Integer> nums, Queue<Integer> heap, int k) {
        if (r == null) 
            return;
                    
        inorder(r.left, nums, heap, k);
        heap.add(r.val);
        if (heap.size() > k) 
            heap.remove();
        inorder(r.right, nums, heap, k);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> nums = new ArrayList();
        
        // init heap 'less close element first'
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> Math.abs(o1 - target) > Math.abs(o2 - target) ? -1 : 1);
        inorder(root, nums, heap, k);
        return new ArrayList<>(heap);
    }
}




// Approach 1: Recursive Inorder + Sort, O(N log N) time
class Solution {
    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> nums = new ArrayList();
        inorder(root, nums);
        
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });
        return nums.subList(0, k);
    }
}
