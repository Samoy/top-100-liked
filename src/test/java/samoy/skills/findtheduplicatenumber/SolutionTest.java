package samoy.skills.findtheduplicatenumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findDuplicate() {
        assertEquals(2, new Solution().findDuplicate(new int[]{1, 3, 4, 2, 2}));
//        assertEquals(3, new Solution().findDuplicate(new int[]{3, 1, 3, 4, 2}));
//        assertEquals(3, new Solution().findDuplicate(new int[]{3, 3, 3, 3, 3}));
    }
}