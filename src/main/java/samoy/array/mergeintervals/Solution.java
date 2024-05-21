package samoy.array.mergeintervals;

import java.util.*;

/**
 * @link <a href="https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked">合并区间</a>
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        // 如果没有区间，直接返回空数组
        if (intervals.length == 0) {
            return new int[0][2];
        }

        // 首先按区间的起始值对区间进行排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        // 使用 ArrayList 存储合并后的不重叠区间
        List<int[]> merged = new ArrayList<>();

        // 遍历排序后的区间数组
        for (int[] interval : intervals) {
            int first = interval[0], second = interval[1];

            // 如果当前区间与上一个区间不重合（或没有上一个区间），则添加到结果列表中
            if (merged.isEmpty() || merged.getLast()[1] < first) {
                merged.add(new int[]{first, second});
            } else {
                // 如果当前区间与上一个区间重合，更新上一个区间的结束值
                merged.getLast()[1] = Math.max(merged.getLast()[1], second);
            }
        }

        // 将 ArrayList 转换为二维整数数组并返回
        return merged.toArray(new int[merged.size()][]);
    }
}
