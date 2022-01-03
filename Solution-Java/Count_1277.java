// Most voted solution using original matrix for DP
class Solution {
	public int countSquares(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (A[i][j] > 0 && i > 0 && j > 0) {
                    A[i][j] = Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i][j - 1])) + 1;
                }
                res += A[i][j];
            }
        }
        return res;
    }
}





// My solution
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[] row = new int[n];
        for (int i = 0; i < m; i++) {
            int[] newrow = new int[n];
            if (matrix[i][0] == 1) {
                newrow[0] = 1;
                res++;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) continue;
                newrow[j] = 1 + Math.min(newrow[j - 1], Math.min(row[j], row[j - 1]));
                res += newrow[j];
            }
            row = newrow;
        }
        return res;
    }
}