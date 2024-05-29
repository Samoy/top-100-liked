package samoy.backtrack.nqueens;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solveNQueens() {
        assertTrue(new Solution().solveNQueens(4).containsAll(List.of(List.of(".Q..", "...Q", "Q...", "..Q."), List.of("..Q.", "Q...", "...Q", ".Q.."))));
        assertTrue(new Solution().solveNQueens(1).contains(List.of("Q")));
    }
}