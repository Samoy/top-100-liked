package samoy.binarysearch.searchinsertposition;

import java.util.Arrays;

/**
 * @link <a href="https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-100-liked">搜索插入位置</a>
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int searchInsert2(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index < 0 ? -index - 1 : index;
    }
}