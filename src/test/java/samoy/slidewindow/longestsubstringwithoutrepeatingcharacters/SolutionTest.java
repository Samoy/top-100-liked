package samoy.slidewindow.longestsubstringwithoutrepeatingcharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLongestSubstring() {
        Solution s = new Solution();
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
        assertEquals(1, s.lengthOfLongestSubstring(" "));
        assertEquals(2, s.lengthOfLongestSubstring("au"));
    }
}