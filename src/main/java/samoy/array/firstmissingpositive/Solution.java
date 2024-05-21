package samoy.array.firstmissingpositive;

import java.util.Arrays;

/**
 * @link <a href="https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked">缺失的第一个正数</a>
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        // 如果1不存在于数组中，则说明缺失的最小正整数为1
        if (Arrays.stream(nums).noneMatch(value -> value == 1)) return 1;
        // 将所有小于1或者大于长度的数字都置为1
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num <= 0 || num > nums.length) {
                nums[i] = 1;
            }
        }
        // 将数字出现的索引设置为负数
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        // 找出第一个出现正数的位置，即是缺失的最小正整数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 如果均为负数，则说明最小的正整数为数组长度+1
        return nums.length + 1;
    }
}