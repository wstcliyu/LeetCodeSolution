// Standard solution #2: Two Pointers
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int res = -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum >= k) {
                r--;
            } else {
                res = Math.max(res, sum);
                l++;
            }
        }
        return res;
    }
}



// Standard solution #3: Binary Search
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int answer = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            int idx = Arrays.binarySearch(nums, i + 1, nums.length, k - nums[i] - 1);
            int j = (idx >= 0 ? idx : ~idx);
            if (j == nums.length || nums[j] > k - nums[i] - 1) {
                j--;
            }
            if (j > i) {
                answer = Math.max(answer, nums[i] + nums[j]);
            }
        }
        return answer;
    }
}