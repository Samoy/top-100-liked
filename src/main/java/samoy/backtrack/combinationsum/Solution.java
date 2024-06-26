package samoy.backtrack.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @link <a href="https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked">组合总和</a>
 */
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>(); // 状态（子集）
        Arrays.sort(candidates); // 对 candidates 进行排序
        int start = 0; // 遍历起始点
        List<List<Integer>> res = new ArrayList<>(); // 结果列表（子集列表）
        backtrack(state, target, candidates, start, res);
        return res;
    }

    void backtrack(List<Integer> element, int target, int[] choices, int start, List<List<Integer>> res) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(element));
            return;
        }
        // 遍历所有选择
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        for (int i = start; i < choices.length; i++) {
            // 剪枝一：若子集和超过 target ，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            if (target - choices[i] < 0) {
                break;
            }
            // 尝试：做出选择，更新 target, start
            element.add(choices[i]);
            // 进行下一轮选择
            backtrack(element, target - choices[i], choices, i, res);
            // 回退：撤销选择，恢复到之前的状态
            element.removeLast();
        }
    }
}