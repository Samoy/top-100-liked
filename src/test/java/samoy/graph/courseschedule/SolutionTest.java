package samoy.graph.courseschedule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void canFinish() {
        assertTrue(new Solution().canFinish(2, new int[][]{{1, 0}}));
        assertFalse(new Solution().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}