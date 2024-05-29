package samoy.binarysearch.searcha2dmatrix;

/**
 * @link <a href="https://leetcode.cn/problems/search-a-2d-matrix/?envType=study-plan-v2&envId=top-100-liked">搜索二维矩阵</a>
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1; // 获取矩阵的最后一行
        int col = matrix[0].length - 1; // 获取矩阵的最后一列
        int i = 0; // 初始化行索引

        // 如果目标值小于矩阵的第一行的第一个元素或大于最后一行的最后一个元素，直接返回false
        if (target < matrix[i][0] || target > matrix[row][col]) {
            return false;
        }

        // 主循环，直到找到目标值或遍历完所有行
        while (i <= row) {
            // 如果目标值大于当前行的最后一个元素，移动到下一行
            if (target > matrix[i][col]) {
                i++;
            }
            // 如果目标值小于当前行的最后元素，使用二分查找在当前行中寻找目标值
            else if (target < matrix[i][col]) {
                int left = 0, right = col - 1; // 初始化二分查找的边界
                while (left <= right) {
                    int mid = (right - left) / 2 + left;
                    int num = matrix[i][mid];

                    // 如果找到目标值，返回true
                    if (num == target) {
                        return true;
                    }
                    // 如果目标值大于中间元素，更新左边界
                    else if (num > target) {
                        right = mid - 1;
                    }
                    // 如果目标值小于中间元素，更新右边界
                    else {
                        left = mid + 1;
                    }
                }
                // 如果二分查找结束未找到目标值，返回false
                return false;
            }
            // 如果目标值等于当前行的第一个元素，说明已经找到目标值，返回true
            else {
                return true;
            }
        }

        // 如果循环结束仍未找到目标值，返回false
        return false;
    }
}
