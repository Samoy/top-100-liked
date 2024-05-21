package samoy.matrix.spiralmatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @link <a href="https://leetcode.cn/problems/spiral-matrix/?envType=study-plan-v2&envId=top-100-liked">螺旋矩阵</a>
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return Collections.emptyList();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> list = new ArrayList<>();
        // 螺旋的顺序是右->下->左->上的顺序
        while (true) {
            // 从左到右
            for (int i = left; i <= right; i++) list.add(matrix[top][i]); // 向右
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) list.add(matrix[i][right]); // 向下
            if (--right < left) break;
            for (int i = right; i >= left; i--) list.add(matrix[bottom][i]); // 向左
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) list.add(matrix[i][left]); // 向上
            if (++left > right) break;
        }
        return list;
    }
}