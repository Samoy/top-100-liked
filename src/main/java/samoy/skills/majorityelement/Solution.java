package samoy.skills.majorityelement;

/**
 * @link <a href="https://leetcode.cn/problems/majority-element/?envType=study-plan-v2&envId=top-100-liked">多数元素</a>
 */
class Solution {
    public int majorityElement(int[] nums) {
        // 使用Boyer-Moore投票算法
        int count = 0; // 候选元素出现的次数
        int candidate = nums[0]; // 候选元素
        for (int num : nums) {
            // 如果候选元素为空，则将当前元素作为候选元素
            if (count == 0) {
                candidate = num;
            }
            // 如果当前元素与候选元素相同，则候选元素出现的次数加1，否则减1
            count += (num == candidate) ? 1 : -1;
        }
        // 返回候选元素
        return candidate;
    }
}