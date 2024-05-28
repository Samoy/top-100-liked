package samoy.graph.rottingoranges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void orangesRotting() {
        assertEquals(4, new Solution().orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        }));
        assertEquals(-1, new Solution().orangesRotting(new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        }));
        assertEquals(0, new Solution().orangesRotting(new int[][]{{0, 2}}));
    }
}