package samoy.skills.singlenumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void singleNumber() {
        assertEquals(1, new Solution().singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, new Solution().singleNumber(new int[]{4, 1, 2, 1, 2}));
        assertEquals(1, new Solution().singleNumber(new int[]{1}));
    }
}