class Minimum_209 {
    // O(n) Sliding Windown(Min)
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int res = Integer.MAX_VALUE;
        for (int sum = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }



    // O(nlogn) Binary Search
    public int minSubArrayLen(int target, int[] nums) {
        int[] sums = new int[nums.length + 1];
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            sums[r + 1] = sum;
            int l = myBinarySearch(sums, sum - target, r + 1);
            if (l != -1) {
                res = Math.min(res, r - l + 1);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    
    private int myBinarySearch(int[] sums, int sum, int r) {
        int l = 0;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (sums[m] <= sum) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l - 1;
    }
}