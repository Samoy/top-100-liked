package samoy.stack.dailytemperatures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @link <a href="https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=top-100-liked">每日温度</a>
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 获取数组长度
        int len = temperatures.length;
        // 初始化结果数组，长度与输入数组相同，初始值设为0
        int[] ans = new int[len];
        Arrays.fill(ans, 0);
        // 创建一个单调递减队列
        Deque<Integer> deque = new ArrayDeque<>();

        // 遍历输入数组
        for (int i = 0; i < len; i++) {
            // 获取当前温度值
            int temp = temperatures[i];

            // 当队列非空且当前温度高于队首温度时
            while (!deque.isEmpty() && temp > temperatures[deque.peek()]) {
                // 获取队首索引并计算天数
                int index = deque.pop();
                // 更新结果数组，将天数存入对应位置
                ans[index] = i - index;
            }

            // 将当前索引入队
            deque.push(i);
        }

        // 返回结果数组
        return ans;
    }
}
