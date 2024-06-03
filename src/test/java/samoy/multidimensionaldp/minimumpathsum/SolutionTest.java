package samoy.multidimensionaldp.minimumpathsum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minPathSum() {
        assertEquals(7, new Solution().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        assertEquals(12, new Solution().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
}