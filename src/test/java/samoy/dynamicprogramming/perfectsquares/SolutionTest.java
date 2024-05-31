package samoy.dynamicprogramming.perfectsquares;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void numSquares() {
        assertEquals(3, new Solution().numSquares(12));
        assertEquals(2, new Solution().numSquares(13));
    }
}