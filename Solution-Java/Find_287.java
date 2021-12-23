// Approach 7: Floyd's Tortoise and Hare (Cycle Detection)
class Solution {
    public int findDuplicate(int[] nums) {
        
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}




// Approach 3: Negative Marking
class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }
        
        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return duplicate;
    }
}




// Approach 5: Binary Search
class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int num : nums) 
                if (num <= mid) count++;
            if (count <= mid)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}




// Approach 6: Sum of Set Bits
class Solution {
    
    // Find the position of the Most Significant Bit in num    
    int calcMaxBit(int num) {
        int bits = 0;
        while (num > 0) {
            num /= 2;
            bits++;
        }
        return bits;
    }

    // Find the largest number in nums
    int findMaxNum(int[] nums) {
        int max_num = 0;
        for (int i = 0; i < nums.length; i++)
            max_num = Math.max(max_num, nums[i]);
        return max_num;
    }
    
    public int findDuplicate(int[] nums) {
        int duplicate = 0;
        int n = nums.length - 1;
        int max_num = findMaxNum(nums);
        int max_bit = calcMaxBit(max_num);
        
        // Iterate over each bit        
        for (int bit = 0; bit < max_bit; bit++) {
            int mask = (1 << bit);
            int base_count = 0, nums_count = 0;

            for (int i = 0; i <= n; i++) {
                // If bit is set in number (i) then add 1 to base_count                
                if ((i & mask) > 0) {
                    base_count++;
                }
                // If bit is set in nums[i] then add 1 to nums_count
                if ((nums[i] & mask) > 0) {
                    nums_count++;
                }
            }

            // If the current bit is more frequently set in nums than it is in 
            // the range [1, 2, ..., n] then it must also be set in the duplicate number
            if (nums_count > base_count) {
                duplicate |= mask;
            }
        }
        return duplicate;
    }
}




// Approach 2: Set
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }
}




// Approach 1: Sort
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                return nums[i];
        }

        return -1;
    }
}