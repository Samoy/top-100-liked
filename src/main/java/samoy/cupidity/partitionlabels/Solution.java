package samoy.cupidity.partitionlabels;

import java.util.*;

/**
 * @link <a href="https://leetcode.cn/problems/partition-labels/?envType=study-plan-v2&envId=top-100-liked">划分字母区间</a>
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        // 创建一个长度为26的数组，用于存储每个字符在字符串s中最后一次出现的位置
        int[] last = new int[26];
        // 获取字符串长度
        int length = s.length();

        // 遍历字符串，更新last数组
        for (int i = 0; i < length; i++) {
            // 将字符减去'a'，得到对应的数组下标
            last[s.charAt(i) - 'a'] = i;
        }

        // 初始化分割列表
        List<Integer> partition = new ArrayList<>();
        // 初始化起始和结束指针
        int start = 0, end = 0;

        // 遍历字符串，确定每个片段的结束位置
        for (int i = 0; i < length; i++) {
            // 更新end，取当前字符在last数组中的值和end的较大者
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // 当i等于end时，表示当前片段结束，添加片段长度到partition
            if (i == end) {
                partition.add(end - start + 1); // 添加片段长度
                start = end + 1; // 更新起始指针
            }
        }

        // 返回分割后的片段长度列表
        return partition;
    }
}
