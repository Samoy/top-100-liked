package samoy.matrix.setmatrixzeroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void setZeroes() {
        Solution s = new Solution();
        int[][] matrix1 = new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 0, 1},
                new int[]{1, 1, 1}
        };
        int[][] matrix2 = new int[][]{
                new int[]{0, 1, 2, 0},
                new int[]{3, 4, 5, 2},
                new int[]{1, 3, 1, 5}
        };
        s.setZeroes(matrix1);
        s.setZeroes(matrix2);
        assertArrayEquals(new int[][]{
                new int[]{1, 0, 1},
                new int[]{0, 0, 0},
                new int[]{1, 0, 1}
        }, matrix1);
        assertArrayEquals(new int[][]{
                new int[]{0, 0, 0, 0},
                new int[]{0, 4, 5, 0},
                new int[]{0, 3, 1, 0}
        }, matrix2);
    }
}