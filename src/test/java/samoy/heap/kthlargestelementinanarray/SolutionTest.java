package samoy.heap.kthlargestelementinanarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findKthLargest() {
        assertEquals(5, new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, new Solution().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}