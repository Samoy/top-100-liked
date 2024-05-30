package samoy.binarysearch.medianoftwosortedarrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findMedianSortedArrays() {
        assertEquals(2, new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{2}));
        assertEquals(2.5, new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}