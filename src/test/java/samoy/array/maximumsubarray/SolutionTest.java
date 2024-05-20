package samoy.array.maximumsubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxSubArray() {
        Solution s = new Solution();
        assertEquals(6, s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, s.maxSubArray(new int[]{1}));
        assertEquals(23, s.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}