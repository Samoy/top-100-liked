package samoy.dynamicprogramming.longestvalidparentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestValidParentheses() {
//        assertEquals(2, new Solution().longestValidParentheses("(()"));
        assertEquals(4, new Solution().longestValidParentheses(")()())"));
        assertEquals(8,new Solution().longestValidParentheses("()((((())))"));
    }
}