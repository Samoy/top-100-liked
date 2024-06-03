package samoy.skills.nextpermutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void nextPermutation() {
        int[] arr1 = new int[]{1, 2, 3};
        new Solution().nextPermutation(arr1);
        assertArrayEquals(new int[]{1, 3, 2}, arr1);
        int[] arr2 = new int[]{3, 2, 1};
        new Solution().nextPermutation(arr2);
        assertArrayEquals(new int[]{1, 2, 3}, arr2);
        int[] arr3 = new int[]{1, 1, 5};
        assertArrayEquals(new int[]{1, 5, 1}, arr3);
    }
}