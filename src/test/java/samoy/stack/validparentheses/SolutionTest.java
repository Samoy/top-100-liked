package samoy.stack.validparentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isValid() {
        assertTrue(new Solution().isValid("()"));
        assertTrue(new Solution().isValid("()[]{}"));
        assertFalse(new Solution().isValid("(]"));
        assertTrue(new Solution().isValid("{[]}"));
    }
}