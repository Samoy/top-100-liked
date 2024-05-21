package samoy.matrix.searcha2dmatrixii;

/**
 * @link <a href="https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked">搜索二维矩阵Ⅱ</a>
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 使用折半搜索的思想,从矩阵右上角开始搜索
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            int num = matrix[i][j];
            // 如果目标值大于当前值，向下移动行
            if (target > num) {
                i++;
            }
            // 如果目标值小于当前值，向移动行
            else if (target < num) {
                j--;
            }
            // 否则，说明找到了目标值
            else return true;
        }
        // 遍历完成，都没找到目标值，说明不存在
        return false;
    }
}