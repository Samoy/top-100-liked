package samoy.dynamicprogramming.climbingstairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void climbStairs() {
        assertEquals(1, new Solution().climbStairs(1));
        assertEquals(2, new Solution().climbStairs(2));
        assertEquals(3, new Solution().climbStairs(3));
        assertEquals(1, new Solution().climbStairs2(1));
        assertEquals(2, new Solution().climbStairs2(2));
        assertEquals(3, new Solution().climbStairs2(3));
    }
}