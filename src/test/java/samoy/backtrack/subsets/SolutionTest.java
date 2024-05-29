package samoy.backtrack.subsets;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void subsets() {
        List<List<Integer>> list = new Solution().subsets(new int[]{1, 2, 3});
        assertTrue(list.containsAll(
                List.of(
                        new ArrayList<Integer>(),
                        List.of(1),
                        List.of(2),
                        List.of(1, 2),
                        List.of(3),
                        List.of(1, 3),
                        List.of(2, 3),
                        List.of(1, 2, 3)
                )
        ));
        assertTrue(new Solution().subsets(new int[]{0}).containsAll(List.of(new ArrayList<Integer>(), List.of(0))));
    }
}