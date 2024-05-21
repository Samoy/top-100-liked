package samoy.array.rotatearray;

/**
 * @link <a href="https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-100-liked">轮转数组</a>
 */
class Solution {
    public void rotate(int[] nums, int k) {
        // 计算实际需要轮转的次数，防止溢出
        k %= nums.length;

        // 第一步：反转整个数组
        reverse(nums, 0, nums.length - 1);

        // 第二步：反转前 k 个元素
        reverse(nums, 0, k - 1);

        // 第三步：反转剩余的元素
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 反转数组 nums 的指定部分
     *
     * @param nums  数组
     * @param start 反转起始索引
     * @param end   反转结束索引
     */
    private void reverse(int[] nums, int start, int end) {
        // 使用双指针法进行反转
        while (start < end) {
            // 交换 start 和 end 位置的元素
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            // 更新指针位置
            start++;
            end--;
        }
    }
}
