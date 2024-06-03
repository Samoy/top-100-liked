package samoy.multidimensionaldp.longestpalindromicsubstring;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestPalindrome() {
        assertEquals("bb", new Solution().longestPalindrome("cbbd"));
        assertEquals("bb", new Solution().longestPalindrome("bb"));
        assertThat(new Solution().longestPalindrome("babad"), anyOf(equalTo("bab"), equalTo("aba")));
    }
}