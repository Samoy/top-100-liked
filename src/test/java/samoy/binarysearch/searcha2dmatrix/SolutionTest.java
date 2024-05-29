package samoy.binarysearch.searcha2dmatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void searchMatrix() {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertTrue(new Solution().searchMatrix(matrix, 3));
        assertFalse(new Solution().searchMatrix(matrix, 13));
        assertTrue(new Solution().searchMatrix(new int[][]{{1, 3, 5}}, 1));
    }
}