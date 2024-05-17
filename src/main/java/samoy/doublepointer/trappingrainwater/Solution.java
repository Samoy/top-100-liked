package samoy.doublepointer.trappingrainwater;

/**
 * @link <a href="https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-100-liked">接雨水</a>
 */
class Solution {
    public int trap(int[] height) {
        // 初始化接雨水的总和为0
        int sum = 0;
        // 初始化两个指针，head指向数组的开始，tail指向数组的末尾
        int head = 0, tail = height.length - 1;
        // 初始化两个变量，headMax和tailMax分别记录当前head和tail位置的最大高度
        int headMax = 0, tailMax = 0;

        // 当head小于tail时，继续循环
        while (head < tail) {
            // 更新head位置的最大高度，取height[head]与headMax的较大值
            headMax = Math.max(headMax, height[head]);
            // 更新tail位置的最大高度，取height[tail]与tailMax的较大值
            tailMax = Math.max(tailMax, height[tail]);

            // 如果head位置的柱子低，说明雨水会堆积在head位置，更新sum并移动head
            if (height[head] < height[tail]) {
                sum += headMax - height[head];
                head++;
            }
            // 否则，雨水会堆积在tail位置，更新sum并移动tail
            else {
                sum += tailMax - height[tail];
                tail--;
            }
        }
        // 返回接雨水的总和
        return sum;
    }
}
