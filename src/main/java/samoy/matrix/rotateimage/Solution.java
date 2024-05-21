package samoy.matrix.rotateimage;

/**
 * @link <a href="https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&envId=top-100-liked">旋转图像</a>
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 步骤1：执行水平翻转
        // 这一步将矩阵沿着中间行镜像，将顶部行移动到底部。
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                // 交换元素
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        // 步骤2：沿主对角线交换矩阵
        // 在水平翻转后，沿着对角线交换元素完成90度顺时针旋转。
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) { // 只遍历到'i'，因为对角线交换操作是对称的
                // 沿对角线交换元素
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

