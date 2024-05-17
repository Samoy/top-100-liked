package samoy.substr.slidingwindowmaximum;

import java.util.*;

/**
 * @link <a href="https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked">滑动窗口最大值</a>
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 单调递减队列
        Deque<Integer> deque = new ArrayDeque<>();
        // 结果列表
        int[] result = new int[nums.length - k + 1];
        // 结果下标
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 维护队列的单调性
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.pollLast();
            }
            // 将下标添加到队列中
            deque.addLast(i);
            // 此时才形成窗口
            if (i >= k - 1) {
                // 将最大值添加到结果中
                result[j++] = nums[deque.getFirst()];
                // 当队首元素已不在当前窗口范围内，即在左边界(i- k + 1)之前，将其移除
                if (deque.getFirst() == i - k + 1) {
                    deque.pollFirst();
                }
            }
        }
        return result;
    }
}
