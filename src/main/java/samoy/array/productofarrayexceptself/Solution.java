package samoy.array.productofarrayexceptself;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 初始化结果数组，长度与输入数组相同，第一个元素设为 1（因为任何数乘以 1 都是其本身）
        int[] result = new int[nums.length];
        result[0] = 1;

        // 前缀积：从左到右计算每个位置左侧所有元素的乘积
        for (int i = 1; i < nums.length; i++) {
            // 当前位置的前缀积等于前一位置的前缀积乘以前一位置的元素值
            // 这一前缀积派出了当前元素
            result[i] = result[i - 1] * nums[i - 1];
        }

        // 后缀积初始化为 1，用于存储右侧所有元素的乘积
        int suffix = 1;

        // 从右到左遍历，同时更新结果数组
        for (int i = nums.length - 1; i >= 0; i--) {
            // 当前位置的结果等于左侧的前缀积乘以右侧的后缀积
            // 更新后缀积为当前元素值乘以前一个后缀积（为下一次迭代做准备）
            // 这一后缀积排除了当前元素
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }

        // 返回计算好的结果数组
        return result;
    }
}
