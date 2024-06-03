package samoy.multidimensionaldp.editdistance;

import java.util.ArrayList;
import java.util.List;

/**
 * @link <a href="https://leetcode.cn/problems/edit-distance/description/?envType=study-plan-v2&envId=top-100-liked">编辑距离</a>
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        List<List<Integer>> op = new ArrayList<>();
        for (int i = 0; i < len1 + 1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < len2 + 1; j++) {
                if (i == 0) {
                    row.add(j);
                } else if (j == 0) {
                    row.add(i);
                } else {
                    row.add(0);
                }
            }
            op.add(row);
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    op.get(i + 1).set(j + 1, op.get(i).get(j));
                } else {
                    op.get(i + 1).set(j + 1, 1 + Math.min(Math.min(op.get(i + 1).get(j), op.get(i).get(j + 1)), op.get(i).get(j)));
                }
            }
        }
        return op.get(len1).get(len2);
    }
}