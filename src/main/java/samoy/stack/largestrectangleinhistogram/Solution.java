package samoy.stack.largestrectangleinhistogram;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link <a href="https://leetcode.cn/problems/largest-rectangle-in-histogram/description/?envType=study-plan-v2&envId=top-100-liked">柱状图中最大的矩形</a>
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 空数组或单个元素的特殊情况处理
        if (len == 0) return 0;
        if (len == 1) return heights[0];

        int area = 0; // 初始化最大面积为0
        Deque<Integer> deque = new ArrayDeque<>(); // 使用双端队列来存储高度的下标

        // 遍历每个柱子
        for (int i = 0; i < len; i++) {
            // 当栈不空且当前柱子高度小于栈顶柱子高度时，计算栈顶柱子能形成的最大矩形面积
            while (!deque.isEmpty() && heights[deque.peekLast()] > heights[i]) {
                area = getArea(heights, i, area, deque);
            }
            // 将当前柱子的下标入栈
            deque.addLast(i);
        }

        // 处理剩余的柱子
        while (!deque.isEmpty()) {
            area = getArea(heights, len, area, deque);
        }

        return area; // 返回最大面积
    }

    // 辅助方法，计算以当前高度为限制条件下的最大矩形面积
    private int getArea(int[] heights, int len, int area, Deque<Integer> deque) {
        int height = heights[deque.removeLast()]; // 获取并移除栈顶柱子的高度
        // 连续相同高度的柱子一起处理，确保计算的是连续的矩形区域
        while (!deque.isEmpty() && heights[deque.peekLast()] == height) {
            deque.removeLast();
        }
        // 计算宽度，若栈空，则宽度为当前位置到开头；否则为当前位置与栈顶下标之间的距离
        int width = deque.isEmpty() ? len : len - deque.peekLast() - 1;
        // 更新最大面积
        area = Math.max(area, width * height);
        return area;
    }
}
