package samoy.dynamicprogramming.houserobber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void rob() {
        assertEquals(4, new Solution().rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, new Solution().rob(new int[]{2, 7, 9, 3, 1}));
        assertEquals(4, new Solution().rob2(new int[]{1, 2, 3, 1}));
        assertEquals(12, new Solution().rob2(new int[]{2, 7, 9, 3, 1}));
    }
}