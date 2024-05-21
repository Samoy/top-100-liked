package samoy.array.rotatearray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void rotate() {
        Solution s = new Solution();
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = new int[]{-1, -100, 3, 99};
        s.rotate(arr1, 3);
        s.rotate(arr2, 2);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, arr1);
        assertArrayEquals(new int[]{3, 99, -1, -100}, arr2);
    }
}