package samoy.skills.singlenumber;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-100-liked">只出现一次的数字</a>
 */
class Solution {
    /**
     * 求只出现了一次的元素
     *
     * @param nums 给定数组
     * @return 只出现一次的元素
     * @apiNote 在这两个方案中，本方法更优秀。原因如下：
     * 1. 时间复杂度：两个方法在理论上都达到了线性时间复杂度O(n)，因为它们都只遍历了一次数组。
     * 但是，{@link #singleNumber2} 方法使用了Java 8的Stream API，虽然这并不改变算法的基本时间复杂度，
     * 但在实际应用中，Stream操作可能会引入额外的开销，尤其是在处理大规模数据时，因为Stream操作涉及方法调用和潜在的对象创建。
     * 2. 空间复杂度：singleNumber 方法仅使用了一个额外的整型变量ans来存储结果，符合题目要求的常量级额外空间。
     * 而singleNumber2 方法虽然逻辑上也符合常量空间要求，但在使用Stream的reduce操作时，可能会有内部缓存或中间对象的创建，
     * 这取决于JVM的具体实现，但通常这不是一个显著的空间开销，因为它依然在栈上操作且优化较好，但不如直接循环直观和低耗。
     * 3. 可读性和性能：直接循环的方式（本方法）在可读性和执行效率上通常优于使用Stream API的方式，特别是在对性能敏感的场景下。
     * Stream API的使用更多是为了提高代码的表达力和在处理复杂数据流操作时的便利性，而不是为了简单的线性遍历和计算。
     * 综上所述，尽管两者都能解决问题，但从执行效率和代码的简洁明了角度来看，本方法更为推荐。
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        // 由于数字和其本身进行异或为0，而任何数字和0异或都是其自身，因此这道题的答案迎刃而解了。
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    @Deprecated
    public int singleNumber2(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // 由于数字和其本身进行异或为0，而任何数字和0异或都是其自身，因此这道题的答案迎刃而解了。
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }
}