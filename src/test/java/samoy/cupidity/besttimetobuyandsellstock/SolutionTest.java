package samoy.cupidity.besttimetobuyandsellstock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxProfit() {
        assertEquals(5, new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, new Solution().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}