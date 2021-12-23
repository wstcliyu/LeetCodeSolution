// Approach 2: O(1) Space, Efficient Solution
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstColBeZero = false;
        boolean firstRowBeZero = false;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) continue;
                if (i == 0) firstRowBeZero = true;
                if (j == 0) firstColBeZero = true;
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0 && (matrix[i][0] == 0 || matrix[0][j] == 0))
                    matrix[i][j] = 0;
            }
        }
        
        if (firstColBeZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if (firstRowBeZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}