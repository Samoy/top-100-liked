package samoy.cupidity.besttimetobuyandsellstock;

/**
 * @link <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-100-liked">买卖股票的最佳时机</a>
 */
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0; // 初始化最大利润为0
        int minPrice = Integer.MAX_VALUE; // 初始化最低价格为正无穷大
        // 遍历股票价格数组
        for (int num : prices) {
            // 更新最低价格
            minPrice = Math.min(minPrice, num);
            // 计算当前利润并更新最大利润
            profit = Math.max(profit, num - minPrice);
        }
        return profit; // 返回最大利润
    }
}
