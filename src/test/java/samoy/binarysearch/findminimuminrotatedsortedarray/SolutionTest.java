package samoy.binarysearch.findminimuminrotatedsortedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findMin() {
        assertEquals(1, new Solution().findMin(new int[]{3, 4, 5, 1, 2}));
        assertEquals(0, new Solution().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        assertEquals(11, new Solution().findMin(new int[]{11, 13, 15, 17}));
    }
}