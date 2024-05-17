package samoy.doublepointer.containerwithmostwater;

/**
 * @link <a href="https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked">盛最多水的容器</a>
 */
class Solution {
    public int maxArea(int[] height) {
        // 头指针
        int start = 0;
        // 尾指针
        int end = height.length - 1;
        int capacity = 0;
        while (start < end) {
            // 设置容器宽度
            int width = end - start;
            capacity = Math.max(capacity, width * Math.min(height[start], height[end]));
            // 不断移动指针，总是将高度设为最大值
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return capacity;
    }
}