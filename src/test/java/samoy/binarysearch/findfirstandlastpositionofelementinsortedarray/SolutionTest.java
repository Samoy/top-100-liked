package samoy.binarysearch.findfirstandlastpositionofelementinsortedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void searchRange() {
        assertArrayEquals(new int[]{3, 4}, new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        assertArrayEquals(new int[]{-1, -1}, new Solution().searchRange(new int[]{}, 0));
        assertArrayEquals(new int[]{0, 0}, new Solution().searchRange(new int[]{1,}, 1));
        assertArrayEquals(new int[]{0, 1}, new Solution().searchRange(new int[]{2, 2}, 2));
    }
}