package samoy.slidewindow.findallanagramsinastring;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findAnagrams() {
        Solution s = new Solution();
        assertEquals(List.of(0, 6), s.findAnagrams("cbaebabacd", "abc"));
        assertEquals(List.of(0, 1, 2), s.findAnagrams("abab", "ab"));
        assertEquals(List.of(0, 6), s.findAnagrams2("cbaebabacd", "abc"));
        assertEquals(List.of(0, 1, 2), s.findAnagrams2("abab", "ab"));
    }
}