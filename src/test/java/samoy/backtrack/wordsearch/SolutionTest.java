package samoy.backtrack.wordsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void exist() {
        char[][] matrix = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        assertTrue(new Solution().exist(matrix, "ABCCED"));
        assertTrue(new Solution().exist(matrix, "SEE"));
        assertFalse(new Solution().exist(matrix, "ABCB"));
    }
}