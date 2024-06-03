package samoy.skills.nextpermutation;

/**
 * @link <a href="https://leetcode.cn/problems/next-permutation/?envType=study-plan-v2&envId=top-100-liked">下一个排列</a>
 */
class Solution {
    public void nextPermutation(int[] nums) {
        // 从右向左找到第一个降序的位置，即i
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 如果存在降序的位置（即i>=0），则在数组右侧找到第一个大于nums[i]的数nums[j]
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 交换nums[i]和nums[j]，使得nums[i]...nums[n-1]部分尽可能大
            swap(nums, i, j);
        }

        // 将nums[i+1]...nums[n-1]部分反转，以获得下一个字典序排列
        reverse(nums, i + 1);
    }

    // 辅助方法，用于交换数组中两个指定位置的元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 辅助方法，用于反转数组中指定范围内的元素
    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
