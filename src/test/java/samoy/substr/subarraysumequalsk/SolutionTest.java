package samoy.substr.subarraysumequalsk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void subarraySum() {
        Solution s = new Solution();
        assertEquals(2, s.subarraySum(new int[]{1, 1, 1}, 2));
        assertEquals(2, s.subarraySum(new int[]{1, 2, 3}, 3));
        assertEquals(3, s.subarraySum(new int[]{1, -1, 0}, 0));
        assertEquals(2, s.subarraySum2(new int[]{1, 1, 1}, 2));
        assertEquals(2, s.subarraySum2(new int[]{1, 2, 3}, 3));
        assertEquals(3, s.subarraySum2(new int[]{1, -1, 0}, 0));
    }
}