package samoy.doublepointer.threesum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void threeSum() {
        Solution s = new Solution();
        assertEquals(2, s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).size());
        assertEquals(0, s.threeSum(new int[]{0, 1, 1}).size());
        assertEquals(1, s.threeSum(new int[]{0, 0, 0}).size());
        assertEquals(1, s.threeSum(new int[]{0, 0, 0, 0}).size());
        assertEquals(9, s.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}).size());
    }
}