package samoy.backtrack.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @link <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-100-liked">电话号码的字母组合</a>
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        // 如果输入为空字符串，直接返回空列表
        if (digits.isEmpty()) return new ArrayList<>();

        // 创建一个字符串数组，存储每个数字对应的字母
        String[] alphabet = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // 初始化一个空列表来存储所有可能的组合
        List<String> combinations = new ArrayList<>();

        // 使用回溯算法生成所有组合
        backtrack(combinations, alphabet, digits, 0, new StringBuffer());

        // 返回结果
        return combinations;
    }

    // 回溯辅助方法，递归生成所有可能的字母组合
    private void backtrack(List<String> combinations, String[] alphabet, String digits, int index, StringBuffer combination) {
        // 当遍历到字符串末尾时，将当前组合添加到结果列表中
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            // 获取当前数字对应的字母字符串
            char digit = digits.charAt(index);
            String lettres = alphabet[digit - '0'];

            // 遍历当前数字对应的字母，依次添加到当前组合中并递归
            for (int i = 0; i < lettres.length(); i++) {
                combination.append(lettres.charAt(i)); // 添加字母到当前组合
                backtrack(combinations, alphabet, digits, index + 1, combination); // 递归处理下一个数字
                combination.deleteCharAt(index); // 回溯，移除添加的字母
            }
        }
    }
}
