// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/discuss/1032143/Java-Detailed-Explanation-DP-with-Graph-Demo
// 2D DP
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i > 0 ? dp[i - 1][j] : 0;
                int y = j > 0 ? dp[i][j - 1] : 0;
                int z = i > 0 && j > 0 ? dp[i - 1][j - 1] : 0;
                dp[i][j] = matrix[i][j] ^ x ^ y ^ z;
                pq.add(dp[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}