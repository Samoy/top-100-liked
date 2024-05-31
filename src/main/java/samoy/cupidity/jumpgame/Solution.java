package samoy.cupidity.jumpgame;

/**
 * @link <a href="https://leetcode.cn/problems/jump-game/?envType=study-plan-v2&envId=top-100-liked">跳跃游戏</a>
 */
class Solution {
    public boolean canJump(int[] nums) {
        // 初始化能够到达的最远下标为当前位置
        int furthestReachableIndex = 0;
        // 遍历数组，从0开始
        for (int i = 0; i < nums.length; i++) {
            // 如果当前下标大于已到达的最远下标，说明无法到达更远的位置，返回false
            if (i > furthestReachableIndex) {
                return false;
            }
            // 更新能够到达的最远下标，取当前下标加上跳跃值和当前最远下标中较大的一个
            furthestReachableIndex = Math.max(furthestReachableIndex, i + nums[i]);
        }
        // 如果遍历到数组末尾，说明可以到达最后一个下标，返回true
        return true;
    }
}

