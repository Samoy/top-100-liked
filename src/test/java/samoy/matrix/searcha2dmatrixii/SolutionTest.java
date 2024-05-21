package samoy.matrix.searcha2dmatrixii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void searchMatrix() {
        Solution s = new Solution();
        int[][] matrix = new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30},
        };
        assertTrue(s.searchMatrix(matrix, 5));
        assertFalse(s.searchMatrix(matrix, 20));
    }
}