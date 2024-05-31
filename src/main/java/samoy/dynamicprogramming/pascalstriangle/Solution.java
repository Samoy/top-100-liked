package samoy.dynamicprogramming.pascalstriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @link <a href="https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked">杨辉三角</a>
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(row);
        }
        return ans;
    }
}