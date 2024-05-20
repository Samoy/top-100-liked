package samoy.substr.minimumwindowsubstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minWindow() {
        Solution s = new Solution();
        assertEquals("BANC", s.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", s.minWindow("a", "a"));
        assertEquals("", s.minWindow("a", "aa"));
    }
}