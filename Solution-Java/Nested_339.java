// Approach 1: Depth-first Search
class Solution {

    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> list, int depth) {
        int total = 0;
        for (NestedInteger nested : list) {
            if (nested.isInteger()) {
                total += nested.getInteger() * depth;
            } else {
                total += dfs(nested.getList(), depth + 1);
            }
        }
        return total;
    }
}



// Approach 2: Breadth-first Search
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nested = queue.poll();
                if (nested.isInteger()) {
                    total += nested.getInteger() * depth;
                } else {
                    queue.addAll(nested.getList());
                }
            }
            depth++;
        }
        return total;
    }
}
