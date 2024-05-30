package samoy.binarysearch.findminimuminrotatedsortedarray;

/**
 * @link <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked">寻找旋转排序数组中的最小值</a>
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        // 当左指针小于右指针时，持续二分查找
        while (left < right) {
            // 计算中间索引，防止(left + right)溢出
            int mid = left + (right - left) / 2;

            // 如果中间元素小于右端点元素，说明最小值在中间或其左侧
            if (nums[mid] < nums[right]) {
                // 缩小搜索范围至左半部分，包括mid
                right = mid;
            } else {
                // 否则，最小值在中间元素的右侧（包括mid+1）
                // 注意：这里不直接更新为mid-1，因为nums[mid]可能等于nums[left]，最小值可能在右侧
                left = mid + 1;
            }
        }

        // 当left == right时，循环结束，此时left指向的就是最小元素
        return nums[left];
    }
}
