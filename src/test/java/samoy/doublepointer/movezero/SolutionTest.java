package samoy.doublepointer.movezero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void moveZeroes() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        int[] nums2 = new int[]{0};
        int[] nums3 = new int[]{0, 1, 0};
        solution.moveZeroes(nums1);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums1);
        solution.moveZeroes(nums2);
        assertArrayEquals(new int[]{0}, nums2);
        solution.moveZeroes(nums3);
        assertArrayEquals(new int[]{1, 0, 0}, nums3);
    }
}