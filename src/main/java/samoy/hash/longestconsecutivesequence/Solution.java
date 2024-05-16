package samoy.hash.longestconsecutivesequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        // 使用HashSet存储数组中的所有数字，以方便快速查找
        Set<Integer> numSet = new HashSet<>();

        // 遍历数组，将所有数字添加到HashSet中
        for (int num : nums) {
            numSet.add(num); // 添加数字到集合
        }

        // 初始化最长连续序列的长度为0
        int sum = 0;

        // 遍历HashSet中的所有数字
        for (Integer num : numSet) {
            // 如果数字的前一个数字不在集合中（表示这不是连续序列的一部分）
            if (!numSet.contains(num - 1)) {
                // 初始化当前序列的第一个数字和当前序列的长度
                int currentNum = num;
                int currentSum = 1;

                // 当数字的下一个数字在集合中时，继续累加序列长度
                while (numSet.contains(currentNum + 1)) {
                    currentNum++; // 更新当前数字
                    currentSum++; // 累加序列长度
                }

                // 更新最长连续序列的长度
                sum = Math.max(sum, currentSum);
            }
        }

        // 返回最长连续序列的长度
        return sum;
    }
}
