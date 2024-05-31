package samoy.cupidity.partitionlabels;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void partitionLabels() {
        assertIterableEquals(List.of(9, 7, 8), new Solution().partitionLabels("ababcbacadefegdehijhklij"));
        assertIterableEquals(List.of(10), new Solution().partitionLabels("eccbbbbdec"));
    }
}