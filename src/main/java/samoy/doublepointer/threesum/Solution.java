package samoy.doublepointer.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 首先对数组进行排序，以便更容易找到和为0的三元组
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(); // 存储满足条件的三元组
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 设置目标值为0-nums[i]
            int target = -nums[i];
            // 设置头尾指针
            int head = i + 1, tail = n - 1;
            while (head < tail) {
                int sum = nums[head] + nums[tail];
                if (sum < target) {  // 偏小
                    head++;
                } else if (sum > target) {  // 偏大
                    tail--;
                } else { // 相等
                    result.add(List.of(nums[head], nums[tail], nums[i]));
                    // 去重
                    while (head < tail && nums[head] == nums[head + 1]) head++;
                    while (head < tail && nums[tail] == nums[tail - 1]) tail--;
                    // 移动指针
                    head++;
                    tail--;
                }
            }
        }

        return result;
    }
}


