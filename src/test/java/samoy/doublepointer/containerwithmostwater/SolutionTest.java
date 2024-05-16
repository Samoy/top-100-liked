package samoy.doublepointer.containerwithmostwater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxArea() {
        Solution s = new Solution();
        assertEquals(49, s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        assertEquals(1, s.maxArea(new int[]{1, 1}));
    }
}