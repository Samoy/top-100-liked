package samoy.backtrack.combinationsum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void combinationSum() {
        assertTrue(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7).containsAll(List.of(List.of(2, 2, 3), List.of(7))));
        assertTrue(new Solution().combinationSum(new int[]{2, 3, 5}, 8).containsAll(List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5))));
        assertTrue(new Solution().combinationSum(new int[]{2}, 1).isEmpty());
    }
}