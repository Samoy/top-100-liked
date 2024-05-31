package samoy.dynamicprogramming.longestincreasingsubsequence;

/**
 * @link <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-100-liked">最长递增子序列</a>
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // 初始化动态规划数组d，长度为n+1，用于存储最长递增子序列的结束元素
        int[] d = new int[n + 1];
        // 最长递增子序列的长度
        int len = 1;

        // 第一个元素自动成为子序列的一部分
        d[len] = nums[0];

        // 遍历数组中的其余元素
        for (int i = 1; i < n; i++) {
            // 如果当前元素大于d[len]，说明可以扩展最长递增子序列
            if (nums[i] > d[len]) {
                // 直接将当前元素添加到最长子序列的末尾
                d[++len] = nums[i];
            } else {
                // 否则，使用二分查找找到合适的插入位置
                int l = 1, r = len, pos = 0;
                // 在d数组中找到第一个大于等于nums[i]的元素的位置
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                // 在找到的位置之后插入nums[i]
                d[pos + 1] = nums[i];
            }
        }

        // 返回最长递增子序列的长度
        return len;
    }
}
