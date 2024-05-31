package samoy.dynamicprogramming.pascalstriangle;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void generate() {
        assertIterableEquals(List.of(
                List.of(1),
                List.of(1, 1),
                List.of(1, 2, 1),
                List.of(1, 3, 3, 1),
                List.of(1, 4, 6, 4, 1)
        ), new Solution().generate(5));
        assertIterableEquals(List.of(List.of(1)), new Solution().generate(1));
    }
}