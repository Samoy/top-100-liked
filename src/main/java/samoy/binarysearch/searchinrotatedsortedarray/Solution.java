package samoy.binarysearch.searchinrotatedsortedarray;

/**
 * @link <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked">搜索旋转排序数组</a>
 */
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length; // 获取数组长度
        if (n == 0) { // 如果数组为空，直接返回 -1
            return -1;
        }
        if (n == 1) { // 如果数组只有一个元素，直接比较并返回下标或 -1
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1; // 初始化左边界和右边界
        // 进行二分查找
        while (l <= r) {
            int mid = (l + r) / 2; // 计算中间索引
            if (nums[mid] == target) { // 如果中间元素就是目标值，返回下标
                return mid;
            }
            // 判断中间元素与数组首元素的关系，以确定旋转边界在哪一侧
            if (nums[0] <= nums[mid]) {
                // 如果中间元素大于等于首元素，说明旋转边界在中间元素右侧
                if (nums[0] <= target && target < nums[mid]) { // 如果目标值在首元素和中间元素之间，更新右边界
                    r = mid - 1;
                } else { // 否则，目标值在中间元素右侧，更新左边界
                    l = mid + 1;
                }
            } else {
                // 如果中间元素小于首元素，说明旋转边界在中间元素左侧
                if (nums[mid] < target && target <= nums[n - 1]) { // 如果目标值在中间元素和末元素之间，更新左边界
                    l = mid + 1;
                } else { // 否则，目标值在中间元素左侧，更新右边界
                    r = mid - 1;
                }
            }
        }
        // 如果循环结束仍未找到，返回 -1
        return -1;
    }
}
