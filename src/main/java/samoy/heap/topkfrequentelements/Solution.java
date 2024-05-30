package samoy.heap.topkfrequentelements;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @link <a href="https://leetcode.cn/problems/top-k-frequent-elements/description/?envType=study-plan-v2&envId=top-100-liked">前K个高频元素</a>
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 使用哈希表记录每个数字出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 使用优先队列来比较频率
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue() != 0 ? b.getValue() - a.getValue() : a.getKey() - b.getKey());
        // 将哈希表中的元素添加到优先对垒
        priorityQueue.addAll(map.entrySet());
        int[] ans = new int[k];
        // 将前k个频率最高的元素放入结果数组
        for (int i = 0; i < k; i++) {
            ans[i] = Objects.requireNonNull(priorityQueue.poll()).getKey();
        }
        return ans;
    }
}