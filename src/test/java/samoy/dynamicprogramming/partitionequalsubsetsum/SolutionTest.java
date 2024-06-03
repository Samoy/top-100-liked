package samoy.dynamicprogramming.partitionequalsubsetsum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void canPartition() {
        assertTrue(new Solution().canPartition(new int[]{1, 5, 11, 5}));
        assertFalse(new Solution().canPartition(new int[]{1, 2, 3, 5}));
    }
}