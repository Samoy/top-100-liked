package samoy.stack.largestrectangleinhistogram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void largestRectangleArea() {
        assertEquals(10, new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        assertEquals(4, new Solution().largestRectangleArea(new int[]{2, 4}));
    }
}