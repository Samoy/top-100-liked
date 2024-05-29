package samoy.backtrack.palindromepartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * @link <a href="https://leetcode.cn/problems/palindrome-partitioning/?envType=study-plan-v2&envId=top-100-liked">分割回文串</a>
 */
class Solution {
    // 初始化结果列表和临时存储子串的列表
    List<List<String>> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        // 调用回溯方法，起始索引为0
        backtrack(s, 0);

        // 返回结果列表
        return ans;
    }

    // 回溯方法，用于递归生成所有可能的回文子串分割
    public void backtrack(String s, int index) {
        // 当索引到达字符串末尾，表示找到了一个分割方案，将其添加到结果列表中
        if (index == s.length()) {
            ans.add(new ArrayList<>(temp));
        }

        // 遍历字符串剩余部分，尝试以每个字符作为子串的结束
        for (int i = index; i < s.length(); i++) {
            // 检查从index到i的子串是否为回文
            if (isPalindrome(s, index, i)) {
                // 如果是回文，将其添加到临时列表中
                temp.add(s.substring(index, i + 1));

                // 继续回溯剩余部分
                backtrack(s, i + 1);

                // 回溯完成后，移除添加的子串，恢复临时列表
                temp.removeLast();
            }
        }
    }

    // 判断子串是否为回文
    // 参数s是原始字符串，start和end是子串的起始和结束索引
    private boolean isPalindrome(String s, int start, int end) {
        // 使用while循环，比较子串的首尾字符，直到start和end相遇
        while (start < end) {
            // 如果首尾字符不相等，子串不是回文，返回false
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            // 移动首尾索引，逐步比较子串内部的字符
            start++;
            end--;
        }
        // 如果没有发现不相等的字符，子串是回文，返回true
        return true;
    }
}

