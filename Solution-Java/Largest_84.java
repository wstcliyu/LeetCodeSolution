// Approach 5: Using Stack
// Time: O(n), Space: O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            while ((stack.peek() != -1)
                    && (heights[stack.peek()] > heights[i])) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
}




// Approach 4: Better Divide and Conquer
// We can reduce the time complexity by using a Segment Tree to find the minimum every time which can be done in O(logn) time.
// Time complexity : O(nlogn). Segment tree takes nlogn for a total of nn times.
// Space complexity : O(n). Space required for Segment Tree.




// Approach 3: Divide and Conquer Approach
// Time: average case O(n logn), worst case O(n^2)
// Space: O(n)
public class Solution {
    public int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minindex = start;
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;
        return Math.max(heights[minindex] * (end - start + 1),
                        Math.max(calculateArea(heights, start, minindex - 1),
                                calculateArea(heights, minindex + 1, end))
                );
    }

    public int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }
}