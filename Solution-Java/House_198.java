// Approach 1: Recursion with Memoization
class Solution {
    
    private int[] memo;
    
    public int rob(int[] nums) {
        
        this.memo = new int[100];
        
        // Fill with sentinel value representing not-calculated recursions.
        Arrays.fill(this.memo, -1);
        
        return this.robFrom(0, nums);
    }
    
    private int robFrom(int i, int[] nums) {
        
        // No more houses left to examine.
        if (i >= nums.length) {
            return 0;
        }
        
        // Return cached value.
        if (this.memo[i] > -1) {
            return this.memo[i];
        }
        
        // Recursive relation evaluation to get the optimal answer.
        int ans = Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]);
        
        // Cache for future use.
        this.memo[i] = ans;
        return ans;
    }
}




// Approach 2: Dynamic Programming
class Solution {
    
    public int rob(int[] nums) {
        
        int N = nums.length;
        
        // Special handling for empty array case.
        if (N == 0) {
            return 0;
        }
        
        int[] maxRobbedAmount = new int[nums.length + 1];
        
        // Base case initializations.
        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N - 1] = nums[N - 1];
        
        // DP table calculations.
        for (int i = N - 2; i >= 0; --i) {
            
            // Same as the recursive solution.
            maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
        }
        
        return maxRobbedAmount[0];
    }
}




// Approach 3: Optimized Dynamic Programming
class Solution {
    
    public int rob(int[] nums) {
        
        int N = nums.length;
        
        // Special handling for empty array case.
        if (N == 0) {
            return 0;
        }
        
        int robNext, robNextPlusOne;
        
        // Base case initializations.
        robNextPlusOne = 0;
        robNext= nums[N - 1];
        
        // DP table calculations. Note: we are not using any
        // table here for storing values. Just using two
        // variables will suffice.
        for (int i = N - 2; i >= 0; --i) {
            
            // Same as the recursive solution.
            int current = Math.max(robNext, robNextPlusOne + nums[i]);
            
            // Update the variables
            robNextPlusOne = robNext;
            robNext = current;
        }
        
        return robNext;
    }
}