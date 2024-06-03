package samoy.multidimensionaldp.editdistance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minDistance() {
        assertEquals(3, new Solution().minDistance("horse", "ros"));
        assertEquals(5, new Solution().minDistance("intention", "execution"));
    }
}