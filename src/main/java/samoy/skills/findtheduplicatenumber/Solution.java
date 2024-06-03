package samoy.skills.findtheduplicatenumber;

/**
 * @link <a href="https://leetcode.cn/problems/find-the-duplicate-number/?envType=study-plan-v2&envId=top-100-liked">寻找重复数</a>
 */
class Solution {
    // 主方法，用于找到包含n+1个整数的数组nums中的唯一重复的数
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;

        // 第一次相遇：找到数组中的环的入口点
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow); // 当快慢指针相遇时，找到了环的入口点

        // 第二次相遇：从数组头开始，让慢指针再次移动，直到与快指针再次相遇
        slow = 0;
        while (fast != slow) {
            slow = nums[slow]; // 慢指针每次移动一步
            fast = nums[fast]; // 快指针也每次移动一步，现在它们都以相同的速度移动
        }

        // 返回慢指针的值，即重复的数字
        return slow;
    }
}
