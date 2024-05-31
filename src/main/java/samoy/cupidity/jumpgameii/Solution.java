package samoy.cupidity.jumpgameii;

/**
 * @link <a href="https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-100-liked">跳跃游戏Ⅱ</a>
 */
class Solution {
    public int jump(int[] nums) {
        // 获取数组长度
        int len = nums.length;
        // 初始化结束位置，当前最大可达位置和跳跃次数
        int end = 0;
        int maxPosition = 0;
        int steps = 0;

        // 遍历数组，从0开始
        for (int i = 0; i < len - 1; i++) {
            // 更新当前最大可达位置，取当前位置加上跳跃值和当前最大可达位置中较大的一个
            maxPosition = Math.max(maxPosition, i + nums[i]);

            // 如果到达了当前结束位置，增加跳跃次数并更新结束位置
            if (i == end) {
                steps++; // 增加跳跃次数
                end = maxPosition; // 更新结束位置为新的最大可达位置
            }
        }

        // 返回跳跃次数
        return steps;
    }
}
