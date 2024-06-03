package samoy.multidimensionaldp.longestcommonsubsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestCommonSubsequence() {
        assertEquals(3, new Solution().longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, new Solution().longestCommonSubsequence("abc", "abc"));
        assertEquals(0, new Solution().longestCommonSubsequence("abc", "def"));
    }
}