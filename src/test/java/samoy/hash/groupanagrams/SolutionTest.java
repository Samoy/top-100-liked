package samoy.hash.groupanagrams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

class SolutionTest {
    @Test
    void groupAnagrams() {
        Solution s = new Solution();
        assertEquals(3, s.groupAnagrams(Stream.of("eat", "tea", "tan", "ate", "nat", "bat").toList()).size());
        assertEquals(1, s.groupAnagrams(Stream.of("").toList()).size());
        assertEquals(1, s.groupAnagrams(Stream.of("a").toList()).size());
    }
}