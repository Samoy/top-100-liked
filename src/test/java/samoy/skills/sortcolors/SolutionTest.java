package samoy.skills.sortcolors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sortColors() {
        int[] arr1 = new int[]{2, 0, 2, 1, 1, 0};
        new Solution().sortColors(arr1);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, arr1);
        int[] arr2 = new int[]{2, 0, 1};
        new Solution().sortColors(arr2);
        assertArrayEquals(new int[]{0, 1, 2}, arr2);
    }
}