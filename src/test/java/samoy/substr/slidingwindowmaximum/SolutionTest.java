package samoy.substr.slidingwindowmaximum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxSlidingWindow() {
        Solution s = new Solution();
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        assertArrayEquals(new int[]{1}, s.maxSlidingWindow(new int[]{1}, 1));
    }
}