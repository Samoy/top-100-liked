package samoy.backtrack.palindromepartitioning;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void partition() {
        assertTrue(new Solution().partition("aab").containsAll(List.of(List.of("a", "a", "b"), List.of("aa", "b"))));
        assertTrue(new Solution().partition("a").contains(List.of("a")));
    }
}