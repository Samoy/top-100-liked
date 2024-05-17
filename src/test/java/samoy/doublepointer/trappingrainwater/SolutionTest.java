package samoy.doublepointer.trappingrainwater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void trap() {
        Solution s = new Solution();
        assertEquals(6, s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(9, s.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}