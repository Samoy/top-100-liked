package samoy.backtrack.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/?envType=study-plan-v2&envId=top-100-liked">全排列</a>
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 初始化结果列表，用于存储所有全排列
        List<List<Integer>> res = new ArrayList<>();

        // 将输入的数组转换为列表，便于操作
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        // 数组的长度
        int n = nums.length;

        // 调用回溯方法生成全排列
        backtrack(n, output, res, 0);

        // 返回所有全排列
        return res;
    }

    // 回溯方法，用于生成全排列
    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int start) {
        // 当第一个位置到倒数第一个位置的元素都已经确定时，说明已经完成了一种排列
        if (start == n) {
            // 将当前排列添加到结果列表中
            res.add(new ArrayList<>(output));
            return;
        }

        // 遍历当前位置之后的元素，尝试将其放在当前位置
        for (int i = start; i < n; i++) {
            // 交换元素，固定当前位置的元素
            Collections.swap(output, start, i);
            // 递归调用，生成当前位置之后的全排列
            backtrack(n, output, res, start + 1);
            // 回溯，撤销交换，尝试下一个元素
            Collections.swap(output, start, i);
        }
    }
}
