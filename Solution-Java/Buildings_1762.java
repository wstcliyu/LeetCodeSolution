// Mono Queue
class Solution {
    public int[] findBuildings(int[] heights) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (q.isEmpty() || heights[i] > heights[q.getLast()]) {
                q.add(i);
            }
        }
        
        int[] res = new int[q.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = q.removeLast();
        }
        return res;
    }
}




// Mono Stack
class Solution {
    public int[] findBuildings(int[] heights) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.getLast()] <= heights[i]) {
                stack.removeLast();
            }
            stack.addLast(i);
        }
        
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeFirst();
        }
        return res;
    }
}