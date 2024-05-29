package samoy.backtrack.lettercombinationsofaphonenumber;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void letterCombinations() {
        Solution s = new Solution();
        assertTrue(s.letterCombinations("23").containsAll(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")));
//        assertTrue(s.letterCombinations("").isEmpty());
//        assertTrue(s.letterCombinations("2").containsAll(List.of("a", "b", "c")));
    }
}