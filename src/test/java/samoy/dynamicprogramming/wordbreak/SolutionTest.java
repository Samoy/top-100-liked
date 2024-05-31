package samoy.dynamicprogramming.wordbreak;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void wordBreak() {
        assertTrue(new Solution().wordBreak("leetcode", List.of("leet", "code")));
        assertTrue(new Solution().wordBreak("applepenapple", List.of("apple", "pen")));
        assertFalse(new Solution().wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        assertTrue(new Solution().wordBreak("cars", List.of("car", "ca", "rs")));
        assertTrue(new Solution().wordBreak("abcd", List.of("a", "abc", "b", "cd")));
    }
}