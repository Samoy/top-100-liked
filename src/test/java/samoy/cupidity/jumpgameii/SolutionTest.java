package samoy.cupidity.jumpgameii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void jump() {
        assertEquals(2, new Solution().jump(new int[]{2, 3, 1, 1, 4}));
        assertEquals(2, new Solution().jump(new int[]{2, 3, 0, 1, 4}));
    }
}