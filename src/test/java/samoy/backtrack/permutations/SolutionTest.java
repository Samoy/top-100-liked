package samoy.backtrack.permutations;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @Test
    void permute() {
        List<List<Integer>> res = new Solution().permute(new int[]{1, 2, 3});
        assertTrue(res.containsAll(
                List.of(
                        List.of(1, 2, 3),
                        List.of(1, 3, 2),
                        List.of(2, 1, 3),
                        List.of(2, 3, 1),
                        List.of(3, 1, 2),
                        List.of(3, 2, 1)
                )
        ));
        assertIterableEquals(List.of(
                List.of(0, 1),
                List.of(1, 0)
        ), new Solution().permute(new int[]{0, 1}));
        assertIterableEquals(List.of(List.of(1)), new Solution().permute(new int[]{1}));
    }
}