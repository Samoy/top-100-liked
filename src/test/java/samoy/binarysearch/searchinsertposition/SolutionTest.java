package samoy.binarysearch.searchinsertposition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void searchInsert() {
        int[] nums = new int[]{1, 3, 5, 6};
        assertEquals(2, new Solution().searchInsert(nums, 5));
        assertEquals(2, new Solution().searchInsert2(nums, 5));
        assertEquals(1, new Solution().searchInsert(nums, 2));
        assertEquals(2, new Solution().searchInsert2(nums, 5));
        assertEquals(4, new Solution().searchInsert(nums, 7));
        assertEquals(2, new Solution().searchInsert2(nums, 5));
    }
}