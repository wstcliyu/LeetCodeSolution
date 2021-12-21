// Approach: Greedy
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentJumpEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }
}




// My Solution: BFS
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currMax = 0;
        int i = 0;
        while (currMax < nums.length - 1) {
            jumps++;
            int prevMax = currMax;
            for (; i <= prevMax; i++) {
                currMax = Math.max(currMax, i + nums[i]);
            }
            if (currMax == prevMax) {
                return -1;
            } 
        }
        return jumps;
    }
}




// My updated BFS
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int start = 0;
        int queueEnd = 0;
        while (start <= queueEnd && queueEnd < nums.length - 1) {
            for (int i = queueEnd; i >= start; i--) {
                queueEnd = Math.max(queueEnd, i + nums[i]);
            }
            jumps++;
        }
        return jumps;
    }
}