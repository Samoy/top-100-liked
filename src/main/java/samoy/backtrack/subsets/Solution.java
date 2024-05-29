package samoy.backtrack.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @link <a href="https://leetcode.cn/problems/subsets/description/?envType=study-plan-v2&envId=top-100-liked">子集</a>
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 计算数组的子集总数，由于是幂集，所以子集个数为2^n，n为数组长度
        int len = 1 << nums.length;
        // 初始化结果列表，用于存储所有子集
        List<List<Integer>> res = new ArrayList<>(len);

        // 遍历从0到2^n-1的所有整数
        for (int i = 0; i < len; i++) {
            // 初始化当前子集列表
            List<Integer> list = new ArrayList<>();

            // 遍历原数组，根据二进制位决定是否将当前元素添加到子集中
            for (int j = 0; j < nums.length; j++) {
                // 如果i的第j位为1，则将nums[j]添加到子集中
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            // 将当前子集添加到结果列表中
            res.add(list);
        }
        // 返回所有子集
        return res;
    }
}
