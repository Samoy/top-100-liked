package samoy.matrix.setmatrixzeroes;

/**
 * @link <a href="https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-100-liked">矩阵置零</a>
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        // Get the dimensions of the matrix
        int m = matrix.length, n = matrix[0].length;

        // Create two boolean arrays to mark rows and columns with at least one 0
        boolean[] rowMarkers = new boolean[m]; // For tracking rows
        boolean[] colMarkers = new boolean[n]; // For tracking columns

        // First pass: mark rows and columns with 0s
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowMarkers[i] = colMarkers[j] = true; // Mark both row and column
                }
            }
        }

        // Second pass: set all elements in marked rows and columns to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowMarkers[i] || colMarkers[j]) { // If the row or column is marked, set the element to 0
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
