package samoy.hash.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * @link <a href="https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked">两数之和</a>
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (m.containsKey(other)) {
                return new int[]{m.get(other), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{};
    }
}