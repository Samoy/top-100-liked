package samoy.binarysearch.findfirstandlastpositionofelementinsortedarray;

/**
 * @link <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked">在排序数组中查找元素的第一个和最后一个位置</a>
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 使用二分查找找到目标值的第一个出现位置
        int leftIdx = binarySearch(nums, target, true);
        // 使用二分查找找到目标值的最后一个出现位置
        int rightIdx = binarySearch(nums, target, false) - 1;

        // 检查找到的范围是否有效
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }

        // 无效范围，返回 [-1, -1]
        return new int[]{-1, -1};
    }

    /**
     * 二分查找实现，寻找目标值在非递减数组中的边界
     *
     * @param nums 非递减排序的整数数组
     * @param target 要查找的目标值
     * @param lower 若为true，查找目标值的左侧边界；若为false，查找右侧边界
     * @return 目标值的边界位置，若未找到返回数组长度
     */
    private int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        // 当左边界小于等于右边界时，进行二分查找
        while (left <= right) {
            // 计算中间索引
            int mid = (left + right) / 2;

            // 根据lower判断查找左侧还是右侧边界
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                // 如果中间元素大于目标值或（对于左侧边界查找，中间元素大于等于目标值），更新右边界
                right = mid - 1;
                // 更新答案为当前中间索引
                ans = mid;
            } else {
                // 如果中间元素小于目标值，更新左边界
                left = mid + 1;
            }
        }
        // 返回答案
        return ans;
    }
}
