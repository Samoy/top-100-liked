package samoy.skills.sortcolors;

/**
 * <a href="https://leetcode.cn/problems/sort-colors/?envType=study-plan-v2&envId=top-100-liked">颜色分类</a>
 */
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length; // 获取数组长度
        int p0 = 0, p2 = n - 1; // 初始化双指针，p0指向0（红色）元素的末尾，p2指向2（蓝色）元素的开头

        // 使用单个循环遍历数组
        for (int i = 0; i <= p2; ++i) {
            // 当前元素是2（蓝色），将其移到数组末尾
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i]; // 临时变量用于交换元素
                nums[i] = nums[p2]; // 将2移动到末尾
                nums[p2] = temp; // 将末尾的元素（可能是2或非2）移到原2的位置
                --p2; // 更新蓝色指针
            }

            // 当前元素是0（红色），将其移到数组开头
            if (nums[i] == 0) {
                int temp = nums[i]; // 临时变量用于交换元素
                nums[i] = nums[p0]; // 将0移动到开头
                nums[p0] = temp; // 将开头的元素（可能是0或非0）移到原0的位置
                ++p0; // 更新红色指针
            }
        }
    }
}
