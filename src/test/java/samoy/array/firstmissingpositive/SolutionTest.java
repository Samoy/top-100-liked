package samoy.array.firstmissingpositive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void firstMissingPositive() {
        Solution s = new Solution();
        assertEquals(3, s.firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(2, s.firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(1, s.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        assertEquals(5, s.firstMissingPositive(new int[]{1, 2, 3, 4}));
    }
}