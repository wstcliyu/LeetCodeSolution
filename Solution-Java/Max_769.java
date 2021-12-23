class Solution {
    public int maxChunksToSorted(int[] arr) {
        /* Most voted solution
         * Check the maximum of first k elements is k
         */
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }
}