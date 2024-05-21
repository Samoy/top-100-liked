package samoy.array.mergeintervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void merge() {
        Solution s = new Solution();
        assertArrayEquals(new int[][]{
                new int[]{1, 6},
                new int[]{8, 10},
                new int[]{15, 18},
        }, s.merge(new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18},
        }));
        assertArrayEquals(new int[][]{
                new int[]{1, 5},
        }, s.merge(new int[][]{
                new int[]{1, 4},
                new int[]{4, 5},
        }));
    }
}