package samoy.cupidity.jumpgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void canJump() {
        assertTrue(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}