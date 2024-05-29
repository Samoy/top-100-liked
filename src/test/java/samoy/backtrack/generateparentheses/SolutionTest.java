package samoy.backtrack.generateparentheses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void generateParenthesis() {
        assertTrue(new Solution().generateParenthesis(3).containsAll(List.of("((()))", "(()())", "(())()", "()(())", "()()()")));
        assertTrue(new Solution().generateParenthesis(1).contains("()"));
    }
}