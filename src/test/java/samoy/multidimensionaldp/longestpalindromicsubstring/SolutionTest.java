package samoy.multidimensionaldp.longestpalindromicsubstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestPalindrome() {
//        assertEquals("bab", new Solution().longestPalindrome("babad"));
//        assertEquals("bb", new Solution().longestPalindrome("cbbd"));
        assertEquals("bb", new Solution().longestPalindrome("bb"));
    }
}