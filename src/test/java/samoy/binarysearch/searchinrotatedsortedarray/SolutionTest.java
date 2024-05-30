package samoy.binarysearch.searchinrotatedsortedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void search() {
        assertEquals(4, new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, new Solution().search(new int[]{1}, 0));
    }
}