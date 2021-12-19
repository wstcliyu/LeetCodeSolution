class Solution {
    public int kIncreasing(int[] arr, int k) {
        int res = 0;
        for (int i = 0; i < k; i++) {
            int len = (arr.length - 1 - i) / k + 1;
            int[] nums = new int[len];
            for (int j = 0; i + j * k < arr.length; j++) {
                nums[j] = arr[i + j * k];
            }
            
            res += len - lengthOfLongestNonDecreasingSequence(nums);
        }
        return res;
    }
    
    private int lengthOfLongestNonDecreasingSequence(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int i = myBinarySearch(tails, num, size);
            tails[i] = num;
            if (i == size) size++;
        }
        return size;
    }
    
    private int myBinarySearch(int[] A, int target, int size) {
        int l = 0, r = size;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}