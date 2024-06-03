package samoy.dynamicprogramming.maximumproductsubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxProduct() {
        assertEquals(6, new Solution().maxProduct(new int[]{2, 3, -2, 4}));
        assertEquals(0, new Solution().maxProduct(new int[]{-2, 0, -1}));
        assertEquals(24, new Solution().maxProduct(new int[]{-2, 3, -4}));
        assertEquals(1000000000
                , new Solution().maxProduct(new int[]{0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0}));
    }
}