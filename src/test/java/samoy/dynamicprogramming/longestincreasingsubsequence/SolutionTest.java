package samoy.dynamicprogramming.longestincreasingsubsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLIS() {
        assertEquals(4, new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(4, new Solution().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        assertEquals(1, new Solution().lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }
}